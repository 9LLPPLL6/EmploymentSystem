package com.glimmer.server.impl;


import com.glimmer.dto.BaseInfo;
import com.glimmer.dto.EducationInfo;
import com.glimmer.dto.ProjectExperienceInfo;
import com.glimmer.mapper.AskMapper;
import com.glimmer.server.AskResumeService;
import com.glimmer.utils.IdUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

