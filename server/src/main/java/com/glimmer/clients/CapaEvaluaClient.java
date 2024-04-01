package com.glimmer.clients;

import com.dtflys.forest.annotation.Body;
import com.dtflys.forest.annotation.Post;
import com.dtflys.forest.annotation.PostRequest;
import com.dtflys.forest.annotation.Request;
import com.glimmer.rro.CapaEvaluaRespond;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 能力评价
 * 向机器学习后端上传个人简历，明确期待职位
 * 返回契合度，差异性，建议
 */
//@FeignClient("capabilityEvaluationServer")
@Component
public interface CapaEvaluaClient {

    //向机器学习后端上传简历
//    @PostMapping("/evaluatetest")
//    @Headers("Content-Type: multipart/form-data")
//    public CapaEvaluaRespond postResumePdf(@RequestParam("resumePdf")MultipartFile resumePdf, @RequestParam("desiredPosition")String desiredPosition);
    //public CapaEvaluaRespond postResumePdf(@RequestParam("resumePdf") MultipartFile resumePdf, @RequestParam("desiredPosition") String desiredPosition);

//    @Post(
//            url = "http://localhost:15213/evaluatetest",
//            headers = {
//                    "Content-Type: multipart/form-data",
//            },
//            dataType = "json"
//    )
//    public CapaEvaluaRespond postResumePdf(@Body("resumePdf") MultipartFile resumePdf, @Body("desiredPosition") String desiredPosition);
}
