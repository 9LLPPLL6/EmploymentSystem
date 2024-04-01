package com.glimmer.server;

import com.glimmer.rro.JobRecommendRespond;
import com.glimmer.rro.Jobs;

import java.util.List;

/**
 * 岗位推荐结果
 */
public interface JobCommandService {
    public Jobs getJobRecon();
}
