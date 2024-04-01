package com.glimmer.rro;

import com.glimmer.dto.ProjectExperienceInfo;
import com.glimmer.dto.WorkExperienceEntity;
import com.glimmer.dto.WorkExperienceInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 机器学习后端返回类
 * 返回能力评价结果
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CapaEvaluaRespond implements Serializable {
    //整体点评
    private String overallReview;
    //基本信息
    private String baseInfo;
    //自我评价
    private String selfEvaluation;
    //工作经历
    private WorkExperience workExperience;
    //在校经历
    private String schoolExperience;
    //项目经历
    private ProjectExperience projectExperience;
}
