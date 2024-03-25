package com.glimmer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 填写简历基本信息返回前端的视图模型
 * 1表示成功，0表示失败
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StatusVo implements Serializable {
    private String message;
    private Integer status;
}
