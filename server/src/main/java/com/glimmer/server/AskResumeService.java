package com.glimmer.server;



import com.glimmer.dto.BaseInfo;
import com.glimmer.dto.EducationInfo;
import com.glimmer.dto.ProjectExperienceInfo;
import com.glimmer.result.Result;

import java.util.List;

public interface AskResumeService {
    List<BaseInfo> AskBaseHistory();

    List<EducationInfo> AskEducationHistory();

    List<EducationInfo> AskSchoolHistory();

    List<ProjectExperienceInfo> AskProjectHistory();

    List<ProjectExperienceInfo> AskWorkHistory();

    Result<BaseInfo> AskNewestBaseHistory();
}
