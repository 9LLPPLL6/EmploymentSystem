package com.glimmer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 数据库pdf_url实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PdfUrl {
    private Integer id;
    private String url;
    private Integer foreignKey;
}
