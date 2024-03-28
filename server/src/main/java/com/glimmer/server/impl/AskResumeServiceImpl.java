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
import org.springframework.cache.annotation.Cacheable;
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
    @Cacheable(cacheNames = "baseInfoCache", key = "#id")
    public BaseInfo AskLatestBaseHistory(Integer id) {
        BaseInfo baseInfo = askMapper.AskLatestBaseHistory(id);        //如果返回空值说明数据不存在
        if (baseInfo == null){
            throw new BaseException("数据不存在");
        }

        return baseInfo;
    }

    @Override
    @Cacheable(cacheNames = "educationInfoCache", key = "#id")
    public EducationInfo AskLatestEducationHistory(Integer id) {
        EducationInfo educationInfo = askMapper.AskLatestEducationHistory(id);
        //如果返回空值说明数据不存在
        if (educationInfo == null){
            throw new BaseException("数据不存在");
        }

        return educationInfo;
    }

    @Override
    @Cacheable(cacheNames = "clubInfoCache", key = "#id")
    public ClubInfo AskLatestClubHistory(Integer id) {
        ClubInfo clubInfo = askMapper.AskLatestClubHistory(id);
        //如果返回空值说明数据不存在
        if (clubInfo == null){
            throw new BaseException("数据不存在");
        }

        return clubInfo;
    }

    @Override
    @Cacheable(cacheNames = "positionInfoCache", key = "#id")
    public PositionInfo AskLatestPositionHistory(Integer id) {
        PositionInfo positionInfo = askMapper.AskLatestPositionHistory(id);
        //如果返回空值说明数据不存在
        if (positionInfo == null){
            throw new BaseException("数据不存在");
        }

        return positionInfo;
    }

    @Override
    @Cacheable(cacheNames = "scholarshipInfoCache", key = "#id")
    public ScholarshipInfo AskLatestScholarshipHistory(Integer id) {
        ScholarshipInfo scholarshipInfo = askMapper.AskLatestScholarshipHistory(id);
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    @Cacheable(cacheNames = "socialactInfo", key = "#id")
    public SocialactInfo AskLatestSocialactHistory(Integer id) {
        SocialactInfo scholarshipInfo = askMapper.AskLatestSocialActHistory(id);
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    @Cacheable(cacheNames = "workExperienceEntityCache", key = "#id")
    public WorkExperienceInfo AskLatestWorkHistory(Integer id) {
        WorkExperienceInfo workExperienceInfo = askMapper.AskLatestWorkHistory(id);
        //如果返回空值说明数据不存在
        if (workExperienceInfo == null){
            throw new BaseException("数据不存在");
        }

        return workExperienceInfo;
    }

    @Override
    @Cacheable(cacheNames = "projectInfoCache", key = "#id")
    public PositionInfo AskLatestProjectHistory(Integer id) {
        PositionInfo positionInfo = askMapper.AskLatestPositionHistory(id);
        //如果返回空值说明数据不存在
        if (positionInfo == null){
            throw new BaseException("数据不存在");
        }

        return positionInfo;
    }
}

