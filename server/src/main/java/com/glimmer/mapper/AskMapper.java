package com.glimmer.mapper;



import com.glimmer.dto.BaseInfo;
import com.glimmer.dto.EducationInfo;
import com.glimmer.dto.ProjectExperienceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AskMapper {

    @Select("select * from base_info where foreign_key = #{id}")
    List<BaseInfo> AskBaseHistory(int id);

    @Select("select * from education_info where foreign_key = #{id}")
    List<EducationInfo> AskEducationHistory(int id);

    @Select("select u.*,u2.*,u3.* from scholarship_info as u left join employment_system.club_experience_info u2 on u.foreign_key = u2.id left join employment_system.stu_position_info u3 on u3.id = u.foreign_key left join employment_system.social_act_info u4 on u4.id = u.foreign_key where u.foreign_key = #{id}")
    List<EducationInfo> AskSchoolHistory(int id);

    @Select("select * from project_experience_info where foreign_key = #{id}")
    List<ProjectExperienceInfo> AskProjectHistory(int id);

    @Select("select * from work_experience_info where foreign_key = #{id}")
    List<ProjectExperienceInfo> AskWorkHistory(int id);
}
