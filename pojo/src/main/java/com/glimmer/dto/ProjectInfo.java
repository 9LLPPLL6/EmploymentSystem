package com.glimmer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 封装单个项目经历信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProjectInfo implements Serializable {
    @JsonProperty("project_name")
    private String projectName;
    @JsonProperty("project_postion")
    private String projectPostion;
    @JsonProperty("project_start_time")
    private String projectStartTime;
    @JsonProperty("project_end_time")
    private String projectEndTime;
    @JsonProperty("project_detail")
    private String projectDetail;

}
