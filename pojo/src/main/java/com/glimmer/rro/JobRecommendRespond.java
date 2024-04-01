package com.glimmer.rro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 机器学习后端返回推荐职位
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobRecommendRespond implements Serializable {
    //岗位名称
    private String positionName;
    //地点
    private String base;
    //学历要求
    private String educationalRequirements;
    //工资
    private String salary;
    //领域
    private String field;
    //公司名称
    private String companyName;
    //公司图标网络链接
    private String companyLogoUrl;
    //具体信息链接
    private String detailUrl;

}
