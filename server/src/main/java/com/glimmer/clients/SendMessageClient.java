package com.glimmer.clients;

import com.dtflys.forest.annotation.*;


import com.glimmer.Request.Requirement;
import com.glimmer.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
@Component
public interface SendMessageClient {

    /**
     * 上传pdf文件，HR模块，根据职位要求和上传简历，返回推荐人员列表
     * @param multipartFile pdf文件
     * @return 推荐结果
     */
    @BodyType("multipart")
    @Post(
            url = "服务端",
            contentType = "application/pdf"
    )
    String sendPDF(@Body MultipartFile multipartFile);

    /**
     * 发送hr的要求
     * @param requirement 以json形式发送出去
     * @return 推荐的人员名单
     */

    @Post(url = "http://113.54.236.190:5000/hr")
    User sendRequirement(@JSONBody Requirement requirement);

}
