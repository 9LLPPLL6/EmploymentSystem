package com.glimmer.rro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装机器学习在能力评价模块返回的项目经历的示例信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MlReProjectInfo implements Serializable {
    //项目名称
    private String projectName;
    //开始时间
    private String startTime;
    //结束时间
    private String endTime;
    //描述
    private String description;
}
