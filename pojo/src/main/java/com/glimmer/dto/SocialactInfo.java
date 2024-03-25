package com.glimmer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 数据传输类，填写简历社会实践信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SocialactInfo implements Serializable {
    @JsonProperty("social_act")
    private String socialAct;
    @JsonProperty("social_start_time")
    private String socialStartTime;
    @JsonProperty("social_end_time")
    private String socialEndTime;
    @JsonProperty("social_detail")
    private String socialDetail;
}
