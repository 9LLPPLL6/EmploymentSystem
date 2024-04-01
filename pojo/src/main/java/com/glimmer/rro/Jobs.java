package com.glimmer.rro;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 机器学习返回的多个岗位信息
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Jobs implements Serializable {
    private JobRecommendRespond[] jobs;
}
