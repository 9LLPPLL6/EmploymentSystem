package com.glimmer.server.impl;


import com.glimmer.dto.*;
import com.glimmer.exception.BaseException;
import com.glimmer.mapper.AskMapper;
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
    CacheUtils cacheUtils;

    @Override
    public List<ClubInfo> AskClubHistory() {return askMapper.AskClubHistory(idUtils.getId());}

    @Override
    public List<PositionInfo> AskPositionHistory() {return askMapper.AskPositionHistory(idUtils.getId());}

    @Override
    public List<ScholarshipInfo> AskScholarshipHistory() {return askMapper.AskScholarshipHistory(idUtils.getId());}

    @Override
    public List<SocialactInfo> AskSocialActHistory() {return askMapper.AskSocialActHistory(idUtils.getId());}

    @Override
    public List<EducationInfo> AskEducationHistory() {return askMapper.AskEducationHistory(idUtils.getId());}

    @Override
    public List<ProjectExperienceInfo> AskProjectHistory() {return askMapper.AskProjectHistory(idUtils.getId());}

    @Override
    public List<WorkExperienceInfo> AskWorkHistory() {return askMapper.AskWorkHistory(idUtils.getId());}

    @Override
    public List<BaseInfo> AskBaseHistory() {return askMapper.AskBaseHistory(idUtils.getId());}

    @Override
    public BaseInfo AskLatestBaseHistory(Integer id) {
        BaseInfo baseInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, BaseInfo.class, askMapper::AskLatestBaseHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (baseInfo == null){
            throw new BaseException("数据不存在");
        }

        return baseInfo;
    }

    @Override
    public EducationInfo AskLatestEducationHistory(Integer id) {
        EducationInfo educationInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, EducationInfo.class, askMapper::AskLatestEducationHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (educationInfo == null){
            throw new BaseException("数据不存在");
        }

        return educationInfo;
    }

    @Override
    public ClubInfo AskLatestClubHistory(Integer id) {
        ClubInfo clubInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, ClubInfo.class, askMapper::AskLatestClubHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (clubInfo == null){
            throw new BaseException("数据不存在");
        }

        return clubInfo;
    }

    @Override
    public PositionInfo AskLatestPositionHistory(Integer id) {
        PositionInfo positionInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, PositionInfo.class, askMapper::AskLatestPositionHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (positionInfo == null){
            throw new BaseException("数据不存在");
        }

        return positionInfo;
    }

    @Override
    public ScholarshipInfo AskLatestScholarshipHistory(Integer id) {
        ScholarshipInfo scholarshipInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, ScholarshipInfo.class, askMapper::AskLatestScholarshipHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    public SocialactInfo AskLatestSocialactHistory(Integer id) {
        SocialactInfo scholarshipInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, SocialactInfo.class, askMapper::AskLatestSocialActHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    public WorkExperienceInfo AskLatestWorkHistory(Integer id) {
        WorkExperienceInfo workExperienceInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, WorkExperienceInfo.class, askMapper::AskLatestWorkHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (workExperienceInfo == null){
            throw new BaseException("数据不存在");
        }

        return workExperienceInfo;
    }

    @Override
    public PositionInfo AskLatestProjectHistory(Integer id) {
        PositionInfo positionInfo = cacheUtils.queryDataWithPassThrough(CACHE_BASE_KEY, id, PositionInfo.class, askMapper::AskLatestPositionHistory, TTL, TimeUnit.MINUTES);
        //如果返回空值说明数据不存在
        if (positionInfo == null){
            throw new BaseException("数据不存在");
        }

        return positionInfo;
    }
}

