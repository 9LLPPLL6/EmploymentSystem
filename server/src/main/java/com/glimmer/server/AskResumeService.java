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

    EducationInfo AskLatestEducationHistory(Integer id);

    ClubInfo AskLatestClubHistory(Integer id);

    PositionInfo AskLatestPositionHistory(Integer id);

    ScholarshipInfo AskLatestScholarshipHistory(Integer id);

    SocialactInfo AskLatestSocialactHistory(Integer id);

    WorkExperienceInfo AskLatestWorkHistory(Integer id);

    PositionInfo AskLatestProjectHistory(Integer id);
}
