package com.glimmer.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装一个HR模块的推荐人员
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficerInfo implements Serializable {
    private String name;
    private String position;
    private String ability;
    private String salary;
    private String phone;
}
