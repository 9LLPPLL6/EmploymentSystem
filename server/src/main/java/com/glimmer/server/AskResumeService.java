package com.glimmer.server;



import com.glimmer.dto.*;

import java.util.List;

public interface AskResumeService {
    BaseInfo AskBaseHistory(Integer foreignKey);

    EducationInfo AskEducationHistory(Integer foreignKey);

    ProjectExperienceInfo AskProjectHistory(Integer foreignKey);

    WorkExperienceInfo AskWorkHistory(Integer foreignKey);

    BaseInfo AskLatestBaseHistory(Integer id);

    ClubInfo AskClubHistory(Integer foreignKey);

    PositionInfo AskPositionHistory(Integer foreignKey);

    ScholarshipInfo AskScholarshipHistory(Integer foreignKey);

    SocialactInfo AskSocialActHistory(Integer foreignKey);

    EducationInfo FindEducationHistory(Integer id);

    ClubInfo FindClubHistory(Integer id);

    PositionInfo FindPositionHistory(Integer id);

    ScholarshipInfo FindScholarshipHistory(Integer id);

    SocialactInfo FindSocialactHistory(Integer id);

    WorkExperienceInfo FindWorkHistory(Integer id);

    ProjectExperienceInfo FindProjectHistory(Integer id);
}
