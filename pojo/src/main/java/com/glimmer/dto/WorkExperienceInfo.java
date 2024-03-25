package com.glimmer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类，简历工作经历信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceInfo implements Serializable {
    private WorkExperienceEntity[] experience;
}
