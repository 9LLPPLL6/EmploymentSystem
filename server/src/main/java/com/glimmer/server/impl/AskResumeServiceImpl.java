package com.glimmer.server.impl;


import com.glimmer.dto.*;
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
    @Cacheable(cacheNames = "clubInfoCache", key = "#idUtils.getId()")
    public ClubInfo AskClubHistory() {
        ClubInfo clubInfo = askMapper.AskClubHistory(idUtils.getId());
        //如果返回空值说明数据不存在
        if (clubInfo == null){
            throw new BaseException("数据不存在");
        }
        return clubInfo;
    }

    @Override
    @Cacheable(cacheNames = "positionInfoCache", key = "#idUtils.getId()")
    public PositionInfo AskPositionHistory() {
        PositionInfo positionInfo = askMapper.AskPositionHistory(idUtils.getId());
        //如果返回空值说明数据不存在
        if (positionInfo == null){
            throw new BaseException("数据不存在");
        }

        return positionInfo;
    }

    @Override
    @Cacheable(cacheNames = "scholarshipInfoCache", key = "#idUtils.getId()")
    public ScholarshipInfo AskScholarshipHistory() {
        ScholarshipInfo scholarshipInfo = askMapper.AskScholarshipHistory(idUtils.getId());
        //如果返回空值说明数据不存在
        if (scholarshipInfo == null){
            throw new BaseException("数据不存在");
        }

        return scholarshipInfo;
    }

    @Override
    @Cacheable(cacheNames = "socialactInfo", key = "#idUtils.getId()")
    public SocialactInfo AskSocialActHistory() {
        SocialactInfo socialactInfo = askMapper.AskSocialActHistory(idUtils.getId());
        //如果返回空值说明数据不存在
        if (socialactInfo == null){
            throw new BaseException("数据不存在");
        }
        return socialactInfo;
    }

    @Override
    @Cacheable(cacheNames = "educationInfoCache", key = "#idUtils.getId()")
    public EducationInfo AskEducationHistory() {
        EducationInfo educationInfo = askMapper.AskEducationHistory(idUtils.getId());
        //如果返回空值说明数据不存在
        if (educationInfo == null){
            throw new BaseException("数据不存在");
        }
        return educationInfo;
    }

    @Override
    @Cacheable(cacheNames = "projectInfoCache", key = "#idUtils.getId()")
    public ProjectExperienceInfo AskProjectHistory() {
        ProjectExperienceInfo projectExperienceInfo = askMapper.AskProjectHistory(idUtils.getId());
        //如果返回空值说明数据不存在
        if (projectExperienceInfo == null){
            throw new BaseException("数据不存在");
        }
        return projectExperienceInfo;
    }

    @Override
    @Cacheable(cacheNames = "workExperienceEntityCache", key = "#idUtils.getId()")
    public WorkExperienceInfo AskWorkHistory() {
        WorkExperienceInfo workExperienceInfo = askMapper.AskWorkHistory(idUtils.getId());
        //如果返回空值说明数据不存在
        if (workExperienceInfo == null){
            throw new BaseException("数据不存在");
        }
        return workExperienceInfo;
    }

    @Override
    @Cacheable(cacheNames = "baseInfoCache", key = "#idUtils.getId()")
    public BaseInfo AskBaseHistory() {
        BaseInfo baseInfo = askMapper.AskBaseHistory(idUtils.getId());        //如果返回空值说明数据不存在
        if (baseInfo == null){
            throw new BaseException("数据不存在");
        }

        return baseInfo;
    }

    @Override
    @Cacheable(cacheNames = "baseInfoCache", key = "#id")
    public BaseInfo AskLatestBaseHistory(Integer id) {
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

