package com.glimmer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类，奖学金信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScholarshipInfo implements Serializable {
    private Integer id;
    private String scholarship;
    @JsonProperty("scholarship_time")
    private String scholarshipTime;
    @JsonProperty("scholarship_detail")
    private String scholarshipDetail;
    private Integer foreignKey;
}
