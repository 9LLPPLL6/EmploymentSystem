package com.glimmer.server;



import com.glimmer.dto.*;

import java.util.List;

public interface AskResumeService {
    BaseInfo AskBaseHistory();

    EducationInfo AskEducationHistory();

    ProjectExperienceInfo AskProjectHistory();

    WorkExperienceInfo AskWorkHistory();

    BaseInfo AskLatestBaseHistory(Integer id);

    ClubInfo AskClubHistory();

    PositionInfo AskPositionHistory();

    ScholarshipInfo AskScholarshipHistory();

    SocialactInfo AskSocialActHistory();

    EducationInfo FindEducationHistory(Integer id);

    ClubInfo FindClubHistory(Integer id);

    PositionInfo FindPositionHistory(Integer id);

    ScholarshipInfo FindScholarshipHistory(Integer id);

    SocialactInfo FindSocialactHistory(Integer id);

    WorkExperienceInfo FindWorkHistory(Integer id);

    ProjectExperienceInfo FindProjectHistory(Integer id);
}
