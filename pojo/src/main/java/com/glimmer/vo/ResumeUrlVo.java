package com.glimmer.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
/**
 * 获取简历pdf的url返回前端的视图模型
 * 1表示成功，0表示失败
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResumeUrlVo implements Serializable {
    private String url;
    private String message;
    private Integer status;
}
