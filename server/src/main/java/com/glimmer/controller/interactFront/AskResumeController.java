package com.glimmer.controller.interactFront;


import com.glimmer.dto.*;
import com.glimmer.entity.User;
import com.glimmer.result.Result;
import com.glimmer.server.AskResumeService;
import com.glimmer.utils.IdUtils;
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

    @Autowired
    private IdUtils idUtils;

    /**
     * 个人信息查询
     * @return 个人基本信息
     */
    @GetMapping("/resume/get_base")
    public Result AskResumeBase(){
        log.info("返回历史个人信息");
        return Result.success("成功",askResumeService.AskBaseHistory(idUtils.getId(new User()).getId()));
    }

    /**
     * 教育经历查询
     * @return 教育经历
     */
    @GetMapping("/resume/get_education")
    public Result AskResumeEducation(){
        log.info("返回历史教育经历");
        return Result.success("成功",askResumeService.AskEducationHistory(idUtils.getId(new User()).getId()));
    }

    /**
     * 社团经历查询
     * @return 学校经历
     */
    @GetMapping("/resume/get_club")
    public Result AskResumeClub(){
        log.info("返回历史社团经历");
        return Result.success("成功",askResumeService.AskClubHistory(idUtils.getId(new User()).getId()));
    }

    /**
     * 学生职务查询
     * @return 学生职务经历
     */
    @GetMapping("/resume/get_position")
    public Result AskResumePosition(){
        log.info("返回历史学生职务经历");
        return Result.success("成功",askResumeService.AskPositionHistory(idUtils.getId(new User()).getId()));
    }

    /**
     * 奖学金查询
     * @return 奖学金
     */
    @GetMapping("/resume/get_scholarship")
    public Result AskResumeScholarship(){
        log.info("返回历史奖学金信息");
        return Result.success("成功",askResumeService.AskScholarshipHistory(idUtils.getId(new User()).getId()));
    }

    /**
     * 社会实践经历查询
     * @return 社会实践经历
     */
    @GetMapping("/resume/get_socialact")
    public Result AskResumeSocialact(){
        log.info("返回历史社会实践经历");
        return Result.success("成功",askResumeService.AskSocialActHistory(idUtils.getId(new User()).getId()));
    }


    /**
     * 工作经历查询
     * @return 工作经历
     */
    @GetMapping("/resume/get_work")
    public Result AskResumeWork() {
        log.info("返回历史工作经历");
        return Result.success("成功",askResumeService.AskWorkHistory(idUtils.getId(new User()).getId()));
    }

    /**
     * 项目信息查询
     * @return 项目信息
     */
    @GetMapping("/resume/get_project")
    public Result AskResumeProject() {
        log.info("返回历史项目经历");
        return Result.success("成功",askResumeService.AskProjectHistory(idUtils.getId(new User()).getId()));
    }

    /**
     * 查询个人基本信息
     * @return 个人基本信息
     */
    @GetMapping("/resume/find_base")
    public Result<BaseInfo> FindBase(Integer id) {
        log.info("返回个人基本信息");
        return Result.success("成功",askResumeService.AskLatestBaseHistory(id));
    }

    /**
     * 查询教育信息
     * @return 教育信息
     */
    @GetMapping("/resume/find_education")
    public Result<EducationInfo> FindEducation(Integer id) {
        log.info("返回教育信息");
        return Result.success("成功",askResumeService.FindEducationHistory(id));
    }

    /**
     * 查询社团信息
     * @return 社团信息
     */
    @GetMapping("/resume/find_club")
    public Result<ClubInfo> FindClub(Integer id) {
        log.info("返回社团信息");
        return Result.success("成功",askResumeService.FindClubHistory(id));
    }

    /**
     * 查询学生职位信息
     * @return 学生职位信息
     */
    @GetMapping("/resume/find_position")
    public Result<PositionInfo> FindPosition(Integer id) {
        log.info("返回个人职位信息");
        return Result.success("成功",askResumeService.FindPositionHistory(id));
    }

    /**
     * 查询奖学金信息
     * @return 奖学金信息
     */
    @GetMapping("/resume/find_scholarship")
    public Result<ScholarshipInfo> FindScholarship(Integer id) {
        log.info("返回奖学金信息");
        return Result.success("成功",askResumeService.FindScholarshipHistory(id));
    }

    /**
     * 查询社会实践信息
     * @return 查询社会实践信息
     */
    @GetMapping("/resume/find_socialact")
    public Result<SocialactInfo> FindSocialAct(Integer id) {
        log.info("返回社会实践信息");
        return Result.success("成功",askResumeService.FindSocialactHistory(id));
    }

    /**
     * 查询工作信息
     * @return 工作信息
     */
    @GetMapping("/resume/find_work")
    public Result<WorkExperienceInfo> FindWork(Integer id) {
        log.info("返回工作信息");
        return Result.success("成功",askResumeService.FindWorkHistory(id));
    }

    /**
     * 查询项目信息
     * @return 项目信息
     */
    @GetMapping("/resume/find_project")
    public Result<ProjectExperienceInfo> FindProject(Integer id) {
        log.info("返回项目信息");
        return Result.success("成功",askResumeService.FindProjectHistory(id));
    }

}
