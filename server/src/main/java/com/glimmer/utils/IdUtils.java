package com.glimmer.utils;

import com.glimmer.Data.CacheData;
import com.glimmer.entity.User;
import com.glimmer.exception.UserException;
import com.glimmer.mapper.IdMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.Objects;
import java.util.concurrent.TimeUnit;

import static com.glimmer.constant.RedisConstants.CACHE_USER_KEY;
import static com.glimmer.constant.RedisConstants.TTL;

@Slf4j
@Component
public class IdUtils {

    @Autowired
    private IdMapper idMapper;

    private static final String signKey = "EmploymentSystem";

//    @Cacheable(cacheNames = "userCache", key = "#result.id")
    public CacheData getId() {

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();
        String token = request.getHeader("token");
        Jws<Claims> claimsJwts = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(token);

        Claims claims = claimsJwts.getBody();
        User user = new User();
        user.setUsername((String) claims.get("username"));
        user.setPassword((String) claims.get("password"));
        Integer id = idMapper.selectId(user);
        if(id == null){
            //返回空值说明数据不存在
            throw new UserException("用户不存在");
        }

        return new CacheData(id);
//        String username = "tom";
//        String password = "123456";
//
//        return idMapper.selectId(username, password);
    }


}
