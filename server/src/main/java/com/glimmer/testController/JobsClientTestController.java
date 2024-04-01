package com.glimmer.testController;

import com.glimmer.rro.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@RestController
public class JobsClientTestController {

    @PostMapping("/jobstest")
    public Jobs getEvaluate(MultipartFile resumePdf){
        log.info("用户请求岗位推荐TEST");

        if (resumePdf==null){
            return null;
        }

        JobRecommendRespond jobRecommendRespond = JobRecommendRespond.builder()
                .positionName("positionName")
                .base("base")
                .educationalRequirements("educationalRequirements")
                .build();

        JobRecommendRespond[] jobRecommendResponds = new JobRecommendRespond[]{jobRecommendRespond};

        Jobs jobs =Jobs.builder()
                .jobs(jobRecommendResponds)
                .build();

        return jobs;
    }
}
