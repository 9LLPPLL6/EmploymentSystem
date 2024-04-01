package com.glimmer.testController;

import com.glimmer.result.Result;
import com.glimmer.rro.CapaEvaluaRespond;
import com.glimmer.rro.MlReProjectInfo;
import com.glimmer.rro.ProjectExperience;
import com.glimmer.rro.WorkExperience;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
public class CapaClientTestController {


    @PostMapping("/evaluatetest")
    public CapaEvaluaRespond getEvaluate(MultipartFile resumePdf,String desiredPosition){
        log.info("用户请求能力评价TEST");

        if (resumePdf==null||desiredPosition==null){
            return null;
        }

        WorkExperience workExperience = WorkExperience.builder()
                .suggest("suggest")
                .postoptimality("优化后")
                .build();

        ProjectExperience projectExperience = ProjectExperience.builder()
                .suggest("prosuggest")
                .example(new MlReProjectInfo[]{})
                .build();

        CapaEvaluaRespond capaEvaluaRespond = CapaEvaluaRespond.builder()
                .overallReview("整体点评")
                .baseInfo("baseinfo")
                .selfEvaluation("selfEva")
                .schoolExperience("schooleExper")
                .workExperience(workExperience)
                .projectExperience(projectExperience)
                .build();

        return capaEvaluaRespond;
    }
}
