package com.glimmer.mapper;



import com.glimmer.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AskMapper {

    @Select("select * from personal_info where foreign_key = #{id}")
    BaseInfo AskBaseHistory(int id);

    @Select("select * from education_info where foreign_key = #{id}")
    EducationInfo AskEducationHistory(int id);

    @Select("select * from project_experience_info where foreign_key = #{id}")
    ProjectExperienceInfo AskProjectHistory(int id);

    @Select("select * from work_experience_info where foreign_key = #{id}")
    WorkExperienceInfo AskWorkHistory(int id);

    @Select("select * from club_experience_info where foreign_key = #{id}")
    ClubInfo AskClubHistory(int id);

    @Select("select * from stu_position_info where foreign_key = #{id}")
    PositionInfo AskPositionHistory(int id);

    @Select("select * from scholarship_info where foreign_key = #{id}")
    ScholarshipInfo AskScholarshipHistory(int id);

    @Select("select * from social_act_info where foreign_key = #{id}")
    SocialactInfo AskSocialActHistory(int id);

    @Select("select * from personal_info where id = #{id}")
    EducationInfo FindEducationHistory(Integer integer);

    @Select("select * from personal_info where id = #{id}")
    BaseInfo FindBaseHistory(int id);

    @Select("select * from project_experience_info where id = #{id}")
    ProjectExperienceInfo FindProjectHistory(int id);

    @Select("select * from work_experience_info where id = #{id}")
    WorkExperienceInfo FindWorkHistory(int id);

    @Select("select * from club_experience_info where id = #{id}")
    ClubInfo FindClubHistory(int id);

    @Select("select * from stu_position_info where id = #{id}")
    PositionInfo FindPositionHistory(int id);

    @Select("select * from scholarship_info where id = #{id}")
    ScholarshipInfo FindScholarshipHistory(int id);

    @Select("select * from social_act_info where id = #{id}")
    SocialactInfo FindSocialActHistory(int id);
}
