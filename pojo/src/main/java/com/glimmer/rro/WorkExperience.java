package com.glimmer.rro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 机器学习在能力评价模块返回的工作经历建议
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkExperience implements Serializable {
    //建议
    private String suggest;
    //优化后
    private String postoptimality;
}
