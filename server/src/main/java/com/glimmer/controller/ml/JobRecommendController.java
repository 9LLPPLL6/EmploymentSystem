package com.glimmer.controller.ml;

import com.glimmer.exception.EnvirVarException;
import com.glimmer.exception.JobRecomException;
import com.glimmer.result.Result;
import com.glimmer.rro.JobRecommendRespond;
import com.glimmer.rro.Jobs;
import com.glimmer.server.impl.JobCommendServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 推荐岗位controller层
 */
@RestController
@Slf4j
public class JobRecommendController {
    @Autowired
    private JobCommendServiceImpl jobCommendService;
    @PostMapping("/commend")
    public Result<Jobs> getJobcommend(){
        log.info("用户岗位推荐");

        Jobs jobs = jobCommendService.getJobRecon();

        if (jobs==null){
            throw new JobRecomException("该用户没有上传简历");
        }

        return Result.success("成功",jobs);
    }

}
