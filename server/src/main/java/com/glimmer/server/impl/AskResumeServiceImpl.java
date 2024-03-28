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

