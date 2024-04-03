package com.glimmer.server;

import com.glimmer.dto.*;
import org.springframework.web.multipart.MultipartFile;

public interface FillInResumeService {
    //填写简历基本信息
    BaseInfo FillInResumeBaseInfo(BaseInfo baseInfo, Integer id);

    //填写简历教育信息
    EducationInfo FillInResumeEducationInfo(EducationInfo educationInfo, Integer id);

    //填写简历社团在校信息
    ClubInfo FillInResumeClubInfo(ClubInfo clubInfo, Integer id);

    //填写简历学生职务信息
    PositionInfo FillInResumePositionInfo(PositionInfo positionInfo, Integer id);

    //填写简历奖学金信息
    ScholarshipInfo FillInResumeScholarshipInfo(ScholarshipInfo scholarshipInfo, Integer id);

    //填写简历社会实践信息
    SocialactInfo FillInResumeSocialActInfo(SocialactInfo socialactInfo, Integer id);

    //填写简历工作经历信息
    void FillInResumeWorkExperienceInfo(WorkExperienceInfo workExperienceInfo,Integer foreignKey);

    //填写简历项目经历信息
    public void FillInResumeProjectExperienceInfo(ProjectExperienceInfo projectExperienceInfo,Integer foreignKey);

    //上传简历pdf
    public void UploadPdf(MultipartFile multipartFile);

    //获取简历PDF的URL
    public String GetResumePdfUrl();

}
