package com.glimmer.server.impl;


import com.glimmer.Request.Requirement;
import com.glimmer.clients.SendMessageClient;
import com.glimmer.server.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private SendMessageClient sendMessageClient;

    @Override
    public List<String> sendRequirement(Requirement requirement) {

        return sendMessageClient.sendRequirement(requirement);
    }
}
