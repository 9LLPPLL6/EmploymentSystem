package com.glimmer.rro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 能力评价模块机器学习返回的项目经历
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProjectExperience implements Serializable {
    //建议
    private String suggest;
    //示例
    private MlReProjectInfo[] example;
}
