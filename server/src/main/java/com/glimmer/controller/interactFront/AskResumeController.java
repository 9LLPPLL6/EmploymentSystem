package com.glimmer.controller.interactFront;


import com.glimmer.dto.*;
import com.glimmer.result.Result;
import com.glimmer.server.AskResumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 历史记录查询
 */
@Slf4j
@RestController
public class AskResumeController {


    @Autowired
    private AskResumeService askResumeService;

    /**
     * 个人信息查询
     * @return 个人基本信息
     */
    @GetMapping("/resume/get_base")
    public Result AskResumeBase(){
        log.info("返回历史个人信息");
        return Result.success("成功",askResumeService.AskBaseHistory());
    }

    /**
     * 教育经历查询
     * @return 教育经历
     */
    @GetMapping("/resume/get_education")
    public Result AskResumeEducation(){
        log.info("返回历史教育经历");
        return Result.success("成功",askResumeService.AskEducationHistory());
    }

    /**
     * 社团经历查询
     * @return 学校经历
     */
    @GetMapping("/resume/get_club")
    public Result AskResumeClub(){
        log.info("返回历史社团经历");
        return Result.success("成功",askResumeService.AskClubHistory());
    }

    /**
     * 学生职务查询
     * @return 学生职务经历
     */
    @GetMapping("/resume/get_position")
    public Result AskResumePosition(){
        log.info("返回历史学生职务经历");
        return Result.success("成功",askResumeService.AskPositionHistory());
    }

    /**
     * 奖学金查询
     * @return 奖学金
     */
    @GetMapping("/resume/get_scholarship")
    public Result AskResumeScholarship(){
        log.info("返回历史奖学金信息");
        return Result.success("成功",askResumeService.AskScholarshipHistory());
    }

    /**
     * 社会实践经历查询
     * @return 社会实践经历
     */
    @GetMapping("/resume/get_socialact")
    public Result AskResumeSocialact(){
        log.info("返回历史社会实践经历");
        return Result.success("成功",askResumeService.AskSocialActHistory());
    }


    /**
     * 工作经历查询
     * @return 工作经历
     */
    @GetMapping("/resume/get_work")
    public Result AskResumeWork() {
        log.info("返回历史工作经历");
        return Result.success("成功",askResumeService.AskWorkHistory());
    }

    /**
     * 项目信息查询
     * @return 项目信息
     */
    @GetMapping("/resume/get_project")
    public Result AskResumeProject() {
        log.info("返回历史项目经历");
        return Result.success("成功",askResumeService.AskProjectHistory());
    }

    /**
     * 返回最新的个人基本信息
     * @return 最新的个人基本信息
     */
    @GetMapping("/resume/latest_base")
    public Result<BaseInfo> AskLatestBase(Integer id) {
        log.info("返回个人基本信息");
        return Result.success("成功",askResumeService.AskLatestBaseHistory(id));
    }

    /**
     * 返回最新的教育信息
     * @return 最新的教育信息
     */
    @GetMapping("/resume/latest_education")
    public Result<EducationInfo> AskLatestEducation(Integer id) {
        log.info("返回最新教育信息");
        return Result.success("成功",askResumeService.AskLatestEducationHistory(id));
    }

    /**
     * 返回最新的社团信息
     * @return 最新的社团信息
     */
    @GetMapping("/resume/latest_club")
    public Result<ClubInfo> AskLatestClub(Integer id) {
        log.info("返回最新社团信息");
        return Result.success("成功",askResumeService.AskLatestClubHistory(id));
    }

    /**
     * 返回最新的学生职位信息
     * @return 最新的学生职位信息
     */
    @GetMapping("/resume/latest_position")
    public Result<PositionInfo> AskLatestPosition(Integer id) {
        log.info("返回最新个人基本信息");
        return Result.success("成功",askResumeService.AskLatestPositionHistory(id));
    }

    /**
     * 返回最新的社会实践信息
     * @return 最新的奖学金信息
     */
    @GetMapping("/resume/latest_scholarship")
    public Result<ScholarshipInfo> AskLatestScholarship(Integer id) {
        log.info("返回最新奖学金信息");
        return Result.success("成功",askResumeService.AskLatestScholarshipHistory(id));
    }

    /**
     * 返回最新的社会实践信息
     *
     * @return 最新的社会实践信息
     */
    @GetMapping("/resume/latest_socialact")
    public Result<SocialactInfo> AskLatestSocialAct(Integer id) {
        log.info("返回最新社会实践信息");
        return Result.success("成功",askResumeService.AskLatestSocialactHistory(id));
    }

    /**
     * 返回最新的工作信息
     *
     * @return 最新的工作信息
     */
    @GetMapping("/resume/latest_work")
    public Result<WorkExperienceInfo> AskLatestWork(Integer id) {
        log.info("返回最新个人基本信息");
        return Result.success("成功",askResumeService.AskLatestWorkHistory(id));
    }

    /**
     * 返回最新的项目信息
     *
     * @return 最新的项目信息
     */
    @GetMapping("/resume/latest_project")
    public Result<PositionInfo> AskLatestProject(Integer id) {
        log.info("返回最新个人基本信息");
        return Result.success("成功",askResumeService.AskLatestProjectHistory(id));
    }

}
