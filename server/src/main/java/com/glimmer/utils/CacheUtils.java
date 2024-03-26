package com.glimmer.utils;


import cn.hutool.core.util.BooleanUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.glimmer.Data.RedisData;
import com.glimmer.entity.User;
import com.glimmer.exception.UserException;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.K;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.glimmer.constant.RedisConstants.LOCK_USER_KEY;
import static com.glimmer.constant.RedisConstants.TTL;

@Slf4j
@Component
public class CacheUtils {

    private static final ExecutorService CACHE_REBUILD_EXECUTOR = Executors.newFixedThreadPool(10);
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 上排他锁
     * @param key
     * @return
     */
    private boolean tryLock(String key) {
        Boolean flag = stringRedisTemplate.opsForValue().setIfAbsent(key,"1",10,TimeUnit.SECONDS);
        return BooleanUtil.isTrue(flag);
    }

    /**
     * 解除排他锁
     * @param key
     */
    private void unlock(String key) {
        stringRedisTemplate.delete(key);
    }


    public void set(String key, Object value, Long time, TimeUnit unit){
        stringRedisTemplate.opsForValue().set(key, JSONUtil.toJsonStr(value), time, unit);
    }

    /**
     * 设置逻辑过期，写入redis
     * @param key
     * @param value
     * @param time
     * @param unit
     */
    public void setWithLogicalExpire(String key, Object value, Long time, TimeUnit unit) {
        //设置逻辑过期
        RedisData redisData = new RedisData();
        redisData.setData(value);
        redisData.setExpireTime(LocalDateTime.now().plusSeconds(unit.toSeconds(time)));
        //写入redis
        this.set(key, value, time, unit);
    }

    /**
     * 解决缓存穿透问题
     * @param keyPrefix
     * @param selector
     * @param type
     * @param dbFallback
     * @param time
     * @param unit
     * @return
     * @param <T>
     * @param <R>
     */
    public <T, R> T queryDataWithPassThrough(
            String keyPrefix, R selector, Class<T> type, Function<R, T> dbFallback, Long time, TimeUnit unit){
        String key = keyPrefix + selector;
        //1.从redis查询数据缓存
        String json = stringRedisTemplate.opsForValue().get(key);
        //2.判断是否存在

        if (StrUtil.isNotBlank(json)) {
            //3.如果存在，直接返回数据
            return JSONUtil.toBean(json, type);
        }
        //判断命中的是否是空值

        if (json != null){
            //返回一个错误信息
            return null;
        }

        //4.如果不存在，从数据库查找数据
        T t = dbFallback.apply(selector);

        //5.不存在，返回错误
        if (t == null) {
            //将空值写入redis
            stringRedisTemplate.opsForValue().set(key,"",TTL, TimeUnit.MINUTES);
            //返回错误信息
            return null;
        }
        //6.存在，写入redis
        this.set(key, t, time, unit);

        return t;
    }

    /**
     * 利用排他锁和逻辑过期解决缓存穿透问题
     * @return
     * @param
     */
    public <T, R> T queryWithLogicalExpire(String keyPrefix, R selector, Class<T> type, Function<R, T> dbFallback, Long time, TimeUnit unit){
        String key = keyPrefix + selector;
        //1.从redis查询数据缓存
        String json = stringRedisTemplate.opsForValue().get(key);
        //2.判断是否存在
        if (StrUtil.isBlank(json)) {
            //3.如果存在，直接返回数据
            return null;
        }
        //4.命中，将json转化为对象
        RedisData redisData =JSONUtil.toBean(json, RedisData.class);
        T t = JSONUtil.toBean((JSONObject) redisData.getData(), type);
        LocalDateTime expireTime = redisData.getExpireTime();
        //5.判断是否过期
        if (expireTime.isAfter(LocalDateTime.now())) {
            //未过期
            return t;
        }
        //已过期，缓存重建
        //6.缓存重建
        //获取互斥锁
        String lockKey = LOCK_USER_KEY + selector;
        boolean isLock = tryLock(lockKey);
        //判断是否获取锁成功
        if (isLock) {
            CACHE_REBUILD_EXECUTOR.submit(() -> {
                try {
                    //查询数据库
                    T t1 = dbFallback.apply(selector);
                    //写入redis
                    this.setWithLogicalExpire(key, t1, time, unit);
                } catch (Exception e) {
                    throw new UserException("未查询到用户信息");
                }finally {
                    //释放锁
                    unlock(lockKey);
                }
            });
        }
        //7.返回过期的用户信息
        return t;
    }



}
