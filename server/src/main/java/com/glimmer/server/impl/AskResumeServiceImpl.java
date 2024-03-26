package com.glimmer.server.impl;


import com.glimmer.dto.BaseInfo;
import com.glimmer.dto.EducationInfo;
import com.glimmer.dto.ProjectExperienceInfo;
import com.glimmer.mapper.AskMapper;
import com.glimmer.result.Result;
import com.glimmer.server.AskResumeService;
import com.glimmer.utils.CacheUtils;
import com.glimmer.utils.IdUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.glimmer.constant.RedisConstants.CACHE_BASE_KEY;
import static com.glimmer.constant.RedisConstants.TTL;

@Slf4j
@Service
public class AskResumeServiceImpl implements AskResumeService {

    @Autowired
    private AskMapper askMapper;

    @Autowired
    private IdUtils idUtils;

    @Resource
    private CacheUtils cacheUtils;

    @Override
    public Result<BaseInfo> AskNewestBaseHistory() {
        BaseInfo baseInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, idUtils.getId(), BaseInfo.class, askMapper::AskNewestBaseHistory, TTL, TimeUnit.MINUTES);

        //如果返回空值说明数据不存在
        if (baseInfo == null){
            return Result.error("数据不存在");
        }

        return Result.success("成功", baseInfo);
    }

    @Override
    public List<EducationInfo> AskEducationHistory() {
        return askMapper.AskEducationHistory(idUtils.getId());
    }

    @Override
    public List<ProjectExperienceInfo> AskProjectHistory() {
        return askMapper.AskProjectHistory(idUtils.getId());
    }

    @Override
    public List<ProjectExperienceInfo> AskWorkHistory() {return askMapper.AskWorkHistory(idUtils.getId());
    }

    @Override
    public List<EducationInfo> AskSchoolHistory() {
        return askMapper.AskSchoolHistory(idUtils.getId());
    }

    @Override
    public List<BaseInfo> AskBaseHistory() {
        return askMapper.AskBaseHistory(idUtils.getId());
    }
}

