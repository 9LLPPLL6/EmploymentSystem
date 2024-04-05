package com.glimmer.server.impl;


import com.glimmer.Request.Requirement;
import com.glimmer.clients.SendMessageClient;
import com.glimmer.dto.AllRecommendation;
import com.glimmer.dto.BaseInfo;
import com.glimmer.dto.EducationInfo;
import com.glimmer.dto.Recommendation;
import com.glimmer.entity.RecommendUser;
import com.glimmer.entity.User;
import com.glimmer.exception.BaseException;
import com.glimmer.mapper.AskMapper;
import com.glimmer.mapper.IdMapper;
import com.glimmer.server.RequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequirementServiceImpl implements RequirementService {

    @Autowired
    private SendMessageClient sendMessageClient;
    @Autowired
    private IdMapper idMapper;
    @Autowired
    private AskMapper askMapper;

    @Override
    public RecommendUser sendRequirement(Requirement requirement){

        List<Recommendation> recommendationList = null;
        RecommendUser recommendUser = sendMessageClient.sendRequirement(requirement);
        for(String username:recommendUser.getUsername()){
            User user = idMapper.selectUser(username);
            BaseInfo baseInfo = askMapper.FindBaseHistory(user.getId());
            EducationInfo educationInfo = askMapper.FindEducationHistory(user.getId());
            Integer numWork = askMapper.FindWorkHistory(user.getId()).getExperience().length;
            Integer numProject = askMapper.FindProjectHistory(user.getId()).getExperience().length;
            Recommendation recommendation = new Recommendation(username,user.getPhone(),baseInfo.getIdentity(),educationInfo.getSchool(),educationInfo.getMajor(),numWork,numProject,educationInfo.getNature());
            try {
                recommendationList.add(recommendation);
            } catch (Exception e ) {
                throw new BaseException("推荐出错");
            }
        }

        return null;
    }
}
