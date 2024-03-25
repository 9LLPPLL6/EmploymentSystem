package com.glimmer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 工作经历数组元素
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperienceEntity implements Serializable {
    @JsonProperty("company_name")
    private String companyName;
    @JsonProperty("position_name")
    private String positionName;
    @JsonProperty("work_start_time")
    private String workStartTime;
    @JsonProperty("work_end_time")
    private String workEndTime;
    @JsonProperty("work_detail")
    private String workDetail;

}
