package com.glimmer.server.impl;


import cn.hutool.json.JSONUtil;
import com.glimmer.Request.Requirement;
import com.glimmer.clients.SendMessageClient;
import com.glimmer.entity.RecommendUser;
import com.glimmer.server.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private SendMessageClient sendMessageClient;

    @Override
    public RecommendUser sendRequirement(Requirement requirement) {

        String message = sendMessageClient.sendRequirement(requirement);
        RecommendUser recommendUser = JSONUtil.toBean(message,RecommendUser.class);
        return recommendUser;
    }
}
