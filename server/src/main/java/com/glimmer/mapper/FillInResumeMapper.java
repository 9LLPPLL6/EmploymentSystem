package com.glimmer.mapper;

import com.glimmer.dto.*;
import com.glimmer.entity.PdfUrl;
import org.apache.ibatis.annotations.*;
import com.glimmer.utils.IdUtils;
import org.apache.ibatis.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 填写简历信息的mapper层接口
 */
@Mapper
public interface FillInResumeMapper {

    /**
     * 填写简历基本信息
     * @param baseInfo
     * @param foreignKey
     */
    @Insert("insert into personal_info(gender, phone, email, identity, foreign_key) values (#{baseInfo.gender},#{baseInfo.phone},#{baseInfo.email},#{baseInfo.identity},#{foreignKey})")
    public void fillInResumeBaseInfo(@Param("baseInfo") BaseInfo baseInfo, @Param("foreignKey") Integer foreignKey);

    /**
     * 删除用户简历基本信息
     * @param foreignKey
     */
    @Delete("delete from personal_info where foreign_key = #{foreignKey}")
    public void deleteResumeBaseInfo(@Param("foreignKey")Integer foreignKey);
    /**
     * 填写简历教育信息
     * @param educationInfo
     * @param foreignKey
     */
    @Insert("insert into education_info(school, major, degree, grade, `rank`, nature, foreign_key) values (#{educationInfo.school},#{educationInfo.major},#{educationInfo.degree},#{educationInfo.grade},#{educationInfo.rank},#{educationInfo.nature}, #{foreignKey})")
    public void fillInResumeEducationInfo(@Param("educationInfo") EducationInfo educationInfo,@Param("foreignKey") Integer foreignKey);

    /**
     * 删除简历教育信息
     * @param foreignKey
     */
    @Delete("delete from education_info where foreign_key = #{foreignKey}")
    public void deleteResumeEducationInfo(@Param("foreignKey")Integer foreignKey);

    /**
     * 填写简历社团经历信息
     * @param clubInfo
     * @param foreignKey
     */
    @Insert("insert into club_experience_info(club_name, club_start_time, club_end_time, club_detail,position, foreign_key) values (#{clubInfo.clubName}, #{clubInfo.clubStartTime}, #{clubInfo.clubEndTime}, #{clubInfo.clubDetail},#{clubInfo.position}, #{foreignKey})")
    public void fillInResumeClubInfo(@Param("clubInfo") ClubInfo clubInfo,@Param("foreignKey") Integer foreignKey);

    /**
     * 删除简历社团经历信息
     * @param foreignKey
     */
    @Delete("delete from club_experience_info where foreign_key = #{foreignKey}")
    public void deleteResumeClubInfo(@Param("foreignKey")Integer foreignKey);

    /**
     * 填写简历学生职务信息
     * @param positionInfo
     * @param foreignKey
     */
    @Insert("insert into stu_position_info(stu_position, stu_start_time, stu_end_time, stu_detail,foreign_key) values (#{positionInfo.stuPosition}, #{positionInfo.stuStartTime}, #{positionInfo.stuEndTime}, #{positionInfo.stuDetail}, #{foreignKey})")
    public void fillInResumePositionInfo(@Param("positionInfo") PositionInfo positionInfo,@Param("foreignKey") Integer foreignKey);

    /**
     * 删除简历学生职务信息
     * @param foreignKey
     */
    @Delete("delete from stu_position_info where foreign_key = #{foreignKey}")
    public void deleteResumePositionInfo(@Param("foreignKey")Integer foreignKey);
    /**
     * 填写简历奖学金信息
     * @param scholarshipInfo
     * @param foreignKey
     */
    @Insert("insert into scholarship_info(scholarship, scholarship_time, scholarship_detail, foreign_key) values (#{scholarshipInfo.scholarship}, #{scholarshipInfo.scholarshipTime}, #{scholarshipInfo.scholarshipDetail}, #{foreignKey})")
    public void fillInResumeScholarshipInfo(@Param("scholarshipInfo") ScholarshipInfo scholarshipInfo, @Param("foreignKey") Integer foreignKey);

    /**
     * 删除简历奖学金信息
     * @param foreignKey
     */
    @Delete("delete from scholarship_info where foreign_key = #{foreignKey}")
    public void deleteResumeScholarshipInfo(@Param("foreignKey")Integer foreignKey);

    /**
     * 填写简历社会经历信息
     * @param socialactInfo
     * @param foreignKey
     */
    @Insert("insert into social_act_info(social_act, act_start_time, act_end_time, act_detail, foreign_key) values (#{socialactInfo.socialAct}, #{socialactInfo.socialStartTime}, #{socialactInfo.socialEndTime}, #{socialactInfo.socialDetail}, #{foreignKey})")
    public void fillInResumeSocialActInfo(@Param("socialactInfo") SocialactInfo socialactInfo, @Param("foreignKey") Integer foreignKey);

    /**
     * 删除简历社会经历信息
     * @param foreignKey
     */
    @Delete("delete from social_act_info where foreign_key = #{foreignKey}")
    public void deleteResumeSocialInfo(@Param("foreignKey")Integer foreignKey);
    /**
     * 填写简历单个工作经历
     * @param workExperienceEntity
     * @param foreignKey
     */
    @Insert("insert into work_experience_info(company_name, work_position ,work_start_time, work_end_time, work_detail, foreign_key) values (#{workExperienceEntity.companyName}, #{workExperienceEntity.positionName}, #{workExperienceEntity.workStartTime}, #{workExperienceEntity.workEndTime}, #{workExperienceEntity.workDetail}, #{foreignKey})")
    public void fillInResumeWorkExperienceInfo(@Param("workExperienceEntity") WorkExperienceEntity workExperienceEntity, @Param("foreignKey") Integer foreignKey);

    /**
     * 删除简历工作经历
     * @param foreignKey
     */
    @Delete("delete from work_experience_info where foreign_key = #{foreignKey}")
    public void deleteResumeWorkExperienceInfo(@Param("foreignKey")Integer foreignKey);
    /**
     * 填写简历单个项目经历
     * @param projectInfo
     * @param foreignKey
     */
    @Insert("insert into project_experience_info(project_name, project_position ,project_start_time, project_end_time, project_detail, foreign_key) values (#{projectInfo.projectName}, #{projectInfo.projectPostion}, #{projectInfo.projectStartTime}, #{projectInfo.projectEndTime}, #{projectInfo.projectDetail}, #{foreignKey})")
    public void fillInResumeProjectExperienceInfo(@Param("projectInfo") ProjectInfo projectInfo, @Param("foreignKey") Integer foreignKey);

    /**
     * 删除项目信息
     * @param foreignKey
     */
    @Delete("delete from project_experience_info where foreign_key = #{foreignKey}")
    public void deleteResumeProjectExperienceInfo(@Param("foreignKey")Integer foreignKey);
    /**
     * 保存简历pdf的url
     * @param url
     * @param foreignKey
     */
    @Insert("insert into pdf_url(url, foreign_key) values (#{url}, #{foreignKey})")
    public void saveResumeUrl(@Param("url") String url, @Param("foreignKey") Integer foreignKey);

    /**
     * 删除用户的简历pdf的url
     * @param foreignKey
     */
    @Delete("delete from pdf_url where foreign_key = #{foreignKey}")
    public void deleteResumeUrl(@Param("foreignKey") Integer foreignKey);

    /**
     * 获取简历url
     * @param foreignKey
     * @return
     */
    @Select("select url from pdf_url where foreign_key = #{foreignKey}; ")
    public PdfUrl[] getResumePdfUrl(@Param("foreignKey") Integer foreignKey);
}
