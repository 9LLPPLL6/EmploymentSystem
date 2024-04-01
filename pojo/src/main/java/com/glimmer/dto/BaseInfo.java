package com.glimmer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类，简历的基本信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseInfo implements Serializable {
    private Integer id;
    private Integer gender;
    private String phone;
    private String email;
    private String identity;
}
