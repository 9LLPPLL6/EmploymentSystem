package com.glimmer.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.EnvironmentVariableCredentialsProvider;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.aliyuncs.exceptions.ClientException;
import com.glimmer.constant.OssConstant;
import com.glimmer.exception.EnvirVarException;
import com.glimmer.exception.FileIOException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Slf4j
public class UploadFile {

    /**
     * 上传PDF文件到阿里云Oss
     *
     * @param multipartFile
     * @return
     */
    public static String uploadFile(MultipartFile multipartFile) {
        String endpoint = OssConstant.ENDPOINT;
        String bucketName = OssConstant.BUCKETNAME;

        //避免文件覆盖
        String originFileName = multipartFile.getOriginalFilename();
        String fileName = UUID.randomUUID().toString() + originFileName.substring(originFileName.indexOf("."));

        // 填写Object完整路径，完整路径中不能包含Bucket名称，例如exampledir/exampleobject.txt。
        //resume:bucket文件夹名字
        String objectName = "resume" + "/" + fileName;

        //文件保存路径
        String url = null;

        OSS ossClient = null;
        try {
            // 从环境变量中获取访问凭证。运行本代码示例之前，请确保已设置环境变量OSS_ACCESS_KEY_ID和OSS_ACCESS_KEY_SECRET。
            EnvironmentVariableCredentialsProvider credentialsProvider = CredentialsProviderFactory.newEnvironmentVariableCredentialsProvider();

            // 创建OSSClient实例。
            ossClient = new OSSClientBuilder().build(endpoint, credentialsProvider);

            InputStream inputStream = multipartFile.getInputStream();
            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);

            //文件访问路径
            url = "https://" + OssConstant.BUCKETNAME + '.' + OssConstant.ENDPOINT + '/' + objectName;
            log.info("url:"+url);
        } catch (ClientException e) {
            throw new EnvirVarException(e.getMessage());
        } catch (IOException e) {
            throw new FileIOException(e.getMessage());
        } finally {
            if (ossClient != null) {
                ossClient.shutdown();
            }
            return url;
        }
    }

}
