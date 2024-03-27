package com.glimmer.server.impl;

import com.glimmer.dto.*;
import com.glimmer.entity.PdfUrl;
import com.glimmer.exception.*;
import com.glimmer.mapper.FillInResumeMapper;
import com.glimmer.server.FillInResumeService;
import com.glimmer.utils.DeleteResumePdf;
import com.glimmer.utils.IdUtils;
import com.glimmer.utils.UploadFile;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

/**
 * 填写简历信息的服务层类
 */
@Slf4j
@Service
public class FillInResumeServiceImpl implements FillInResumeService {
    @Autowired
    private FillInResumeMapper fillInResumeMapper;
    @Autowired
    private IdUtils idUtils;


    //填写简历基本信息service
    @Transactional
    public void FillInResumeBaseInfo(BaseInfo baseInfo) {
        log.info("填写简历基本信息service");
        //判断填写的信息是否为空
        if (baseInfo.getEmail() == null
                || baseInfo.getGender() == null
                || baseInfo.getPhone() == null
                || baseInfo.getIdentity() == null) {
            throw new ResumeBaseInfoFillException("简历基本信息添加失败");
        }

        //删除之前的信息
        fillInResumeMapper.deleteResumeBaseInfo(idUtils.getId());

        //在数据库插入数据
        fillInResumeMapper.fillInResumeBaseInfo(baseInfo, idUtils.getId());
    }

    //填写简历教育信息service
    @Override
    public void FillInResumeEducationInfo(EducationInfo educationInfo) {
        log.info("填写简历教育信息service");
        //判断信息是否为null
        if (educationInfo.getDegree() == null
                || educationInfo.getMajor() == null
                || educationInfo.getSchool() == null) {
            throw new ResumeEducationInfoFillException("简历教育信息填写异常，有信息为null");
        }

        fillInResumeMapper.fillInResumeEducationInfo(educationInfo, idUtils.getId());
    }

    //填写简历社团在校信息service
    @Override
    public void FillInResumeClubInfo(ClubInfo clubInfo) {
        log.info("填写简历社团在校信息service");

        if (clubInfo.getClubName() == null
                || clubInfo.getClubStartTime() == null
                || clubInfo.getClubEndTime() == null
                || clubInfo.getClubDetail() == null) {
            throw new ResumeClubInfoFillException("简历社团在校信息填写异常，有信息为null");
        }

        fillInResumeMapper.fillInResumeClubInfo(clubInfo, idUtils.getId());
    }

    //填写简历学生职务信息service
    @Override
    public void FillInResumePositionInfo(PositionInfo positionInfo) {
        log.info("填写简历学生职务信息service");

        if (positionInfo.getStuPosition() == null
                || positionInfo.getStuStartTime() == null
                || positionInfo.getStuEndTime() == null
                || positionInfo.getStuDetail() == null) {
            throw new ResumePositionInfoFillException("简历学生职务信息填写异常，有信息为null");
        }

        fillInResumeMapper.fillInResumePositionInfo(positionInfo, idUtils.getId());
    }

    //填写简历奖学金信息service
    @Override
    public void FillInResumeScholarshipInfo(ScholarshipInfo scholarshipInfo) {
        log.info("填写简历奖学金信息service");

        if (scholarshipInfo.getScholarship() == null
                || scholarshipInfo.getScholarshipTime() == null
                || scholarshipInfo.getScholarshipDetail() == null) {
            throw new ResumeScholarshipInfoException("简历奖学金信息填写异常，有信息为null");
        }

        fillInResumeMapper.fillInResumeScholarshipInfo(scholarshipInfo, idUtils.getId());
    }

    //填写简历社会实践信息service
    @Override
    public void FillInResumeSocialActInfo(SocialactInfo socialactInfo) {
        log.info("填写简历社会实践信息service");

        if (socialactInfo.getSocialAct() == null
                || socialactInfo.getSocialStartTime() == null
                || socialactInfo.getSocialEndTime() == null
                || socialactInfo.getSocialDetail() == null) {
            throw new ResumeSocialActException("简历社会实践信息填写异常，有信息为null");
        }

        fillInResumeMapper.fillInResumeSocialActInfo(socialactInfo, idUtils.getId());
    }

    //填写简历工作经历信息service
    @Override
    public void FillInResumeWorkExperienceInfo(WorkExperienceInfo workExperienceInfo) {
        log.info("填写简历工作经历信息service");

        WorkExperienceEntity workExperienceEntity = null;
        WorkExperienceEntity[] experience = workExperienceInfo.getExperience();
        Integer foreignKey = idUtils.getId();

        for (int i = 0; i < experience.length; i++) {
            workExperienceEntity = experience[i];

            if (workExperienceEntity.getCompanyName() == null
                    || workExperienceEntity.getPositionName() == null
                    || workExperienceEntity.getWorkStartTime() == null
                    ||workExperienceEntity.getWorkEndTime()==null
                    || workExperienceEntity.getWorkDetail() == null) {
                throw new ResumeWorkExperienceException("工作经历信息为null");
            }

            fillInResumeMapper.fillInResumeWorkExperienceInfo(workExperienceEntity, foreignKey);
        }
    }

    //填写简历项目经历信息service
    @Override
    public void FillInResumeProjectExperienceInfo(ProjectExperienceInfo projectExperienceInfo) {
        log.info("填写简历项目经历信息service");

        ProjectInfo projectInfo = null;
        ProjectInfo[] experience = projectExperienceInfo.getExperience();
        Integer foreignKey = idUtils.getId();

        for (int i = 0; i < experience.length; i++) {
            projectInfo = experience[i];

            if (projectInfo.getProjectName() == null
                    || projectInfo.getProjectPostion() == null
                    || projectInfo.getProjectStartTime() == null
                    || projectInfo.getProjectDetail() == null) {
                throw new ResumeProjectExperienceException("项目经历信息为null");
            }

            fillInResumeMapper.fillInResumeProjectExperienceInfo(projectInfo, foreignKey);
        }
    }

    //上传简历PDF
    @Override
    @Transactional
    public void UploadPdf(MultipartFile multipartFile) {
        log.info("上传简历PDF service");

        String pdfUrl = UploadFile.uploadFile(multipartFile);
        if (pdfUrl == null) {
            throw new PdfNullException("简历PDF的URL为null");
        } else {
            //将远端oss的pdf文件删除
            PdfUrl[] pdfUrls = fillInResumeMapper.getResumePdfUrl(idUtils.getId());
            for (int i = 0; i < pdfUrls.length; i++) {
                String url = pdfUrls[i].getUrl();
                DeleteResumePdf.deletePdf(url);
            }
            //删除数据库的相关信息
            fillInResumeMapper.deleteResumeUrl(idUtils.getId());
            //插入新信息
            fillInResumeMapper.saveResumeUrl(pdfUrl, idUtils.getId());

        }
    }

    //获取简历url
    @Override
    public String GetResumePdfUrl() {
        String url = null;

        PdfUrl[] pdfUrls = fillInResumeMapper.getResumePdfUrl(idUtils.getId());

        //获取最新的pdf的url
        url = pdfUrls[pdfUrls.length-1].getUrl();

        if (url==null){
            throw new GeturlException("url为null");
        }else {
            return url;
        }
    }
}
