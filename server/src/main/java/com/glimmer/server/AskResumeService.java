package com.glimmer.server;



import com.glimmer.dto.*;

import java.util.List;

public interface AskResumeService {
    List<BaseInfo> AskBaseHistory();

    List<EducationInfo> AskEducationHistory();

    List<ProjectExperienceInfo> AskProjectHistory();

    List<WorkExperienceInfo> AskWorkHistory();

    BaseInfo AskLatestBaseHistory(Integer id);

    List<ClubInfo> AskClubHistory();

    List<PositionInfo> AskPositionHistory();

    List<ScholarshipInfo> AskScholarshipHistory();

    List<SocialactInfo> AskSocialActHistory();

    EducationInfo FindEducationHistory(Integer id);

    ClubInfo FindClubHistory(Integer id);

    PositionInfo FindPositionHistory(Integer id);

    ScholarshipInfo FindScholarshipHistory(Integer id);

    SocialactInfo FindSocialactHistory(Integer id);

    WorkExperienceInfo FindWorkHistory(Integer id);

    ProjectExperienceInfo FindProjectHistory(Integer id);
}
