package com.glimmer.server;

import com.glimmer.dto.*;
import org.springframework.web.multipart.MultipartFile;

public interface FillInResumeService {
    //填写简历基本信息
    public BaseInfo FillInResumeBaseInfo(BaseInfo baseInfo);

    //填写简历教育信息
    public EducationInfo FillInResumeEducationInfo(EducationInfo educationInfo);

    //填写简历社团在校信息
    public ClubInfo FillInResumeClubInfo(ClubInfo clubInfo);

    //填写简历学生职务信息
    public PositionInfo FillInResumePositionInfo(PositionInfo positionInfo);

    //填写简历奖学金信息
    public ScholarshipInfo FillInResumeScholarshipInfo(ScholarshipInfo scholarshipInfo);

    //填写简历社会实践信息
    public SocialactInfo FillInResumeSocialActInfo(SocialactInfo socialactInfo);

    //填写简历工作经历信息
    public void FillInResumeWorkExperienceInfo(WorkExperienceInfo workExperienceInfo);

    //填写简历项目经历信息
    public void FillInResumeProjectExperienceInfo(ProjectExperienceInfo projectExperienceInfo);

    //上传简历pdf
    public void UploadPdf(MultipartFile multipartFile);

    //获取简历PDF的URL
    public String GetResumePdfUrl();

}
