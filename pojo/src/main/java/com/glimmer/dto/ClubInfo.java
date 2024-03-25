package com.glimmer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类，社团信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClubInfo implements Serializable {
    @JsonProperty("club_name")//将前端的下划线转为驼峰
    private String clubName;
    @JsonProperty("club_start_time")
    private String clubStartTime;
    @JsonProperty("club_end_time")
    private String clubEndTime;
    @JsonProperty("club_detail")
    private String clubDetail;
}
