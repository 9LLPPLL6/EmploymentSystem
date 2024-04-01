package com.glimmer.clients;

import com.glimmer.rro.JobRecommendRespond;
import com.glimmer.rro.Jobs;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 岗位推荐
 * 向机器学习后端发送简历，系统自动分析简历内容，生成推荐职位
 * 返回推荐职位
 */
@FeignClient("jobRecommendation")
public interface JobRecommendationClient {

//    //向机器学习后端上传简历
//    @GetMapping("/")
//    public Jobs getJobRecommend(@Param("resumePdf")MultipartFile resumePdf);
}
