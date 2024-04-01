package com.glimmer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类，教育信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationInfo implements Serializable {
    private Integer id;
    private String school;
    private String major;
    private String degree;
    private String grade;
    private String rank;
    private String nature;
}
