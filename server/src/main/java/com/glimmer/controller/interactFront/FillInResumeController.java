package com.glimmer.controller.interactFront;

import com.glimmer.dto.*;
import com.glimmer.entity.User;
import com.glimmer.result.Result;
import com.glimmer.server.impl.FillInResumeServiceImpl;
import com.glimmer.utils.IdUtils;
import com.glimmer.vo.ResumeUrlVo;
import com.glimmer.vo.StatusVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * 响应与简历相关的请求
 */
@Slf4j
@RestController
@RequestMapping("/resume")
public class FillInResumeController {
    @Autowired
    private FillInResumeServiceImpl fillInResumeService;

    @Autowired
    private IdUtils idUtils;

    /**
     * 用户填写简历学生职务信息的接口
     *
     * @param baseInfo
     * @return
     */
    @PostMapping("base_info")
    public Result<StatusVo> FillInResumePositionInfo(@RequestBody BaseInfo baseInfo) {
        log.info("填写简历基本信息:{}",baseInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("简历基本信息填写成功")
//                .build();
//        try {
//            Thread.sleep(100);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumeBaseInfo(baseInfo,idUtils.getId(new User()).getId());

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("简历基本信息填写成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 填写简历教育背景
     * @return
     */
    @PostMapping("education")
    public Result<StatusVo> FillInResumeEducationInfo(@RequestBody EducationInfo educationInfo){
        log.info("填写简历教育信息:{}",educationInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("填写简历教育信息成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumeEducationInfo(educationInfo,idUtils.getId(new User()).getId());

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("简历教育信息填写成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 填写简历社团信息
     * @param clubInfo
     * @return
     */
    @PostMapping("club")
    public Result<StatusVo> FillInResumeClubInfo(@RequestBody ClubInfo clubInfo){
        log.info("填写简历社团在校信息:{}",clubInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("填写简历社团在校信息成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumeClubInfo(clubInfo,idUtils.getId(new User()).getId());

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("简历社团信息填写成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 填写简历学生职务信息
     * @param positionInfo
     * @return
     */
    @PostMapping("position")
    public Result<StatusVo> FillInResumePositionInfo(@RequestBody PositionInfo positionInfo){
        log.info("填写简历学生职务信息:{}",positionInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("填写简历学生职务信息成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumePositionInfo(positionInfo,idUtils.getId(new User()).getId());

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("简历学生职务填写成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 填写简历奖学金信息
     * @param scholarshipInfo
     * @return
     */
    @PostMapping("scholarship")
    public Result<StatusVo> FillInResumeClubInfo(@RequestBody ScholarshipInfo scholarshipInfo){
        log.info("填写简历奖学金信息:{}",scholarshipInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("填写简历奖学金信息成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumeScholarshipInfo(scholarshipInfo,idUtils.getId(new User()).getId());


        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("简历奖学金信息填写成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 填写简历社会实践信息
     * @param socialactInfo
     * @return
     */
    @PostMapping("socialact")
    public Result<StatusVo> FillInResumeClubInfo(@RequestBody SocialactInfo socialactInfo){
        log.info("填写简历社会实践信息:{}",socialactInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("填写简历社会实践信息成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumeSocialActInfo(socialactInfo,idUtils.getId(new User()).getId());

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("简历学生社会实践填写成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 填写简历工作经历信息
     * @param workExperienceInfo
     * @return
     */
    @PostMapping("workExperience")
    public Result<StatusVo> FillInResumeWorkExperienceInfo(@RequestBody WorkExperienceInfo workExperienceInfo){
        log.info("填写简历工作经历信息:{}",workExperienceInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("填写简历工作经历信息成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumeWorkExperienceInfo(workExperienceInfo,idUtils.getId(new User()).getId());

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("填写简历工作经历信息成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 填写简历项目经历
     * @param projectExperienceInfo
     * @return
     */
    @PostMapping("projectExperience")
    public Result<StatusVo> FillInResumeWorkExperienceInfo(@RequestBody ProjectExperienceInfo projectExperienceInfo){
        log.info("填写简历项目经历信息:{}",projectExperienceInfo);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("填写简历项目经历信息成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.FillInResumeProjectExperienceInfo(projectExperienceInfo,idUtils.getId(new User()).getId());

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("填写简历项目经历信息成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 上传简历PDF
     * @param multipartFile
     * @return
     */
    @PostMapping("pdf")
    public Result<StatusVo> FillInResumePdf(@RequestParam("resume")MultipartFile multipartFile){
        log.info("上传简历pdf",multipartFile);

//        //跑测试
//        StatusVo statusVo = StatusVo.builder()
//                .status(1)
//                .message("上传简历pdf成功")
//                .build();
//        return Result.success("成功",statusVo);

        fillInResumeService.UploadPdf(multipartFile);

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("上传简历PDF成功")
                .build();
        return Result.success("成功",statusVo);
    }

    /**
     * 获取简历url
     * @return
     */
    @GetMapping("url")
    public Result<ResumeUrlVo> GetResumePdfUrl(){
        log.info("获取简历pdf的url");

//        //跑测试
//        String url = "url";
//
//        ResumeUrlVo resumeUrlVo = ResumeUrlVo.builder()
//                .status(1)
//                .message("获取简历PDF的url成功")
//                .url(url)
//                .build();
//        return Result.success("成功",resumeUrlVo);

        String url = fillInResumeService.GetResumePdfUrl();

        ResumeUrlVo resumeUrlVo = ResumeUrlVo.builder()
                .status(1)
                .message("获取简历PDF的url成功")
                .url(url)
                .build();
        return Result.success("成功",resumeUrlVo);
    }
}
