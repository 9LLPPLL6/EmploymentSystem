package com.glimmer.server.impl;


import com.glimmer.dto.*;
import com.glimmer.entity.User;
import com.glimmer.exception.BaseException;
import com.glimmer.mapper.AskMapper;
import com.glimmer.server.AskResumeService;
import com.glimmer.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AskResumeServiceImpl implements AskResumeService {

    @Autowired
    private AskMapper askMapper;

    @Autowired
    private IdUtils idUtils;



    @Override
    @Cacheable(cacheNames = "clubInfoCache", key = "#foreignKey")
    public ClubInfo AskClubHistory(Integer foreignKey) {
        ClubInfo clubInfo = askMapper.AskClubHistory(foreignKey);
        //如果返回空值说明数据不存在
        if (clubInfo == null){
            throw new BaseException("数据不存在");
        }
        return clubInfo;
    }

    @Override
    @Cacheable(cacheNames = "positionInfoCache", key = "#foreignKey")
    public PositionInfo AskPositionHistory(Integer foreignKey) {
        PositionInfo positionInfo = askMapper.AskPositionHistory(foreignKey);
        //如果返回空值说明数据不存在
        if (positionInfo == null){
            throw new BaseException("数据不存在");
        }

        return positionInfo;
    }

    @Override
    @Cacheable(cacheNames = "scholarshipInfoCache", key = "#foreignKey")
    public ScholarshipInfo AskScholarshipHistory(Integer foreignKey) {
        ScholarshipInfo scholarshipInfo = askMapper.AskScholarshipHistory(foreignKey);
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    @Cacheable(cacheNames = "socialactInfo", key = "#foreignKey")
    public SocialactInfo AskSocialActHistory(Integer foreignKey) {
        SocialactInfo socialactInfo = askMapper.AskSocialActHistory(foreignKey);
        //如果返回空值说明数据不存在
        if (socialactInfo == null){
            throw new BaseException("数据不存在");
        }
        return socialactInfo;
    }

    @Override
    @Cacheable(cacheNames = "educationInfoCache", key = "#foreignKey")
    public EducationInfo AskEducationHistory(Integer foreignKey) {
        EducationInfo educationInfo = askMapper.AskEducationHistory(foreignKey);
        //如果返回空值说明数据不存在
        if (educationInfo == null){
            throw new BaseException("数据不存在");
        }
        return educationInfo;
    }

    @Override
    @Cacheable(cacheNames = "projectInfoCache", key = "#foreignKey")
    public ProjectExperienceInfo AskProjectHistory(Integer foreignKey) {
        ProjectExperienceInfo projectExperienceInfo = askMapper.AskProjectHistory(foreignKey);
        //如果返回空值说明数据不存在
        if (projectExperienceInfo == null){
            throw new BaseException("数据不存在");
        }
        return projectExperienceInfo;
    }

    @Override
    @Cacheable(cacheNames = "workExperienceEntityCache", key = "#foreignKey")
    public WorkExperienceInfo AskWorkHistory(Integer foreignKey) {
        WorkExperienceInfo workExperienceInfo = askMapper.AskWorkHistory(foreignKey);
        //如果返回空值说明数据不存在
        if (workExperienceInfo == null){
            throw new BaseException("数据不存在");
        }
        return workExperienceInfo;
    }

    @Override
    @Cacheable(cacheNames = "baseInfoCache", key = "#foreignKey")
    public BaseInfo AskBaseHistory(Integer foreignKey) {
        BaseInfo baseInfo = askMapper.AskBaseHistory(foreignKey);        //如果返回空值说明数据不存在
        if (baseInfo == null){
            throw new BaseException("数据不存在");
        }

        return baseInfo;
    }

    @Override
    @Cacheable(cacheNames = "baseInfoCache", key = "#id")
    public BaseInfo FindBaseHistory(Integer id) {
        BaseInfo baseInfo = askMapper.FindBaseHistory(id);        //如果返回空值说明数据不存在
        if (baseInfo == null){
            throw new BaseException("数据不存在");
        }

        return baseInfo;
    }

    @Override
    @Cacheable(cacheNames = "educationInfoCache", key = "#id")
    public EducationInfo FindEducationHistory(Integer id) {
        EducationInfo educationInfo = askMapper.FindEducationHistory(id);
        //如果返回空值说明数据不存在
        if (educationInfo == null){
            throw new BaseException("数据不存在");
        }

        return educationInfo;
    }

    @Override
    @Cacheable(cacheNames = "clubInfoCache", key = "#id")
    public ClubInfo FindClubHistory(Integer id) {
        ClubInfo clubInfo = askMapper.FindClubHistory(id);
        //如果返回空值说明数据不存在
        if (clubInfo == null){
            throw new BaseException("数据不存在");
        }

        return clubInfo;
    }

    @Override
    @Cacheable(cacheNames = "positionInfoCache", key = "#id")
    public PositionInfo FindPositionHistory(Integer id) {
        PositionInfo positionInfo = askMapper.FindPositionHistory(id);
        //如果返回空值说明数据不存在
        if (positionInfo == null){
            throw new BaseException("数据不存在");
        }

        return positionInfo;
    }

    @Override
    @Cacheable(cacheNames = "scholarshipInfoCache", key = "#id")
    public ScholarshipInfo FindScholarshipHistory(Integer id) {
        ScholarshipInfo scholarshipInfo = askMapper.FindScholarshipHistory(id);
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    @Cacheable(cacheNames = "socialactInfo", key = "#id")
    public SocialactInfo FindSocialactHistory(Integer id) {
        SocialactInfo scholarshipInfo = askMapper.FindSocialActHistory(id);
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    @Cacheable(cacheNames = "workExperienceEntityCache", key = "#id")
    public WorkExperienceInfo FindWorkHistory(Integer id) {
        WorkExperienceInfo workExperienceInfo = askMapper.FindWorkHistory(id);
        //如果返回空值说明数据不存在
        if (workExperienceInfo == null){
            throw new BaseException("数据不存在");
        }

        return workExperienceInfo;
    }

    @Override
    @Cacheable(cacheNames = "projectInfoCache", key = "#id")
    public ProjectExperienceInfo FindProjectHistory(Integer id) {
        ProjectExperienceInfo projectExperienceInfo = askMapper.FindProjectHistory(id);
        //如果返回空值说明数据不存在
        if (projectExperienceInfo == null){
            throw new BaseException("数据不存在");
        }

        return projectExperienceInfo;
    }
}

