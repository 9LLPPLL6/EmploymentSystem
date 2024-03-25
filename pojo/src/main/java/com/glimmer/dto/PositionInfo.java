package com.glimmer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类学生职务信息
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionInfo implements Serializable {
    @JsonProperty("stu_position")
    private String stuPosition;
    @JsonProperty("stu_start_time")
    private String stuStartTime;
    @JsonProperty("stu_end_time")
    private String stuEndTime;
    @JsonProperty("stu_detail")
    private String stuDetail;
}
