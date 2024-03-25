package com.glimmer.config;

import com.aliyun.oss.OSSException;
import com.aliyun.oss.common.auth.CredentialsProviderFactory;
import com.aliyun.oss.common.auth.STSAssumeRoleSessionCredentialsProvider;
import com.aliyuncs.exceptions.ClientException;

/**
 * 配置Oss访问凭证
 */
public class OssConfig {
    // 授权STSAssumeRole访问的Region。
    String region = "cn-chengdu";
    // 从环境变量中获取RAM用户的访问密钥（AccessKey ID和AccessKey Secret）。
    String accessKeyId = System.getenv("OSS_ACCESS_KEY_ID");
    String accessKeySecret = System.getenv("OSS_ACCESS_KEY_SECRET");
    // 从环境变量中获取RAM角色的RamRoleArn。
    String roleArn = System.getenv("OSS_STS_ROLE_ARN");

    // 使用环境变量中获取的RAM用户的访问密钥和RAM角色的RamRoleArn配置访问凭证。
    STSAssumeRoleSessionCredentialsProvider credentialsProvider;

    {
        try {
            credentialsProvider = CredentialsProviderFactory
                    .newSTSAssumeRoleSessionCredentialsProvider(
                            region,
                            accessKeyId,
                            accessKeySecret,
                            roleArn
                    );
        } catch (ClientException e) {
            throw new OSSException(e.getMessage());
        }
    }
}
