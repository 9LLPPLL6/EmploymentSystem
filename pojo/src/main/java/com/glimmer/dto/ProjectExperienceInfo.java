package com.glimmer.dto;

import com.glimmer.rro.MlReProjectInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类，项目经历类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectExperienceInfo implements Serializable {
    private ProjectInfo[] experience;
}
