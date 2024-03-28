package com.glimmer.mapper;



import com.glimmer.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AskMapper {

    @Select("select * from base_info where foreign_key = #{id}")
    List<BaseInfo> AskBaseHistory(int id);

    @Select("select * from education_info where foreign_key = #{id}")
    List<EducationInfo> AskEducationHistory(int id);

    @Select("select * from project_experience_info where foreign_key = #{id}")
    List<ProjectExperienceInfo> AskProjectHistory(int id);

    @Select("select * from work_experience_info where foreign_key = #{id}")
    List<WorkExperienceInfo> AskWorkHistory(int id);

    @Select("select * from club_experience_info where foreign_key = #{id}")
    List<ClubInfo> AskClubHistory(int id);

    @Select("select * from stu_position_info where foreign_key = #{id}")
    List<PositionInfo> AskPositionHistory(int id);

    @Select("select * from scholarship_info where foreign_key = #{id}")
    List<ScholarshipInfo> AskScholarshipHistory(int id);

    @Select("select * from social_act_info where foreign_key = #{id}")
    List<SocialactInfo> AskSocialActHistory(int id);

    @Select("select * from base_info where id = #{id}")
    EducationInfo FindEducationHistory(Integer integer);

    @Select("select * from base_info where id = #{id}")
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
