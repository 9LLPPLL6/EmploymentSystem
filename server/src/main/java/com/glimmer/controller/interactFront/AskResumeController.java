package com.glimmer.controller.interactFront;


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
        return Result.success("返回历史个人信息成功",askResumeService.AskBaseHistory());
    }

    /**
     * 教育经历查询
     * @return 教育经历
     */
    @GetMapping("/resume/get_education")
    public Result AskResumeEducation(){
        log.info("返回历史教育经历");
        return Result.success("返回历史教育经历成功",askResumeService.AskEducationHistory());
    }

    /**
     * 学校经历查询
     * @return 学校经历
     */
    @GetMapping("/resume/get_school")
    public Result AskResumeSchool(){
        log.info("返回历史学校经历");
        return Result.success("成功",askResumeService.AskSchoolHistory());
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
}
