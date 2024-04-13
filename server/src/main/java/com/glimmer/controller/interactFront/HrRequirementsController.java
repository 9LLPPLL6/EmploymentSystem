package com.glimmer.controller.interactFront;


import cn.hutool.json.JSONUtil;
import com.glimmer.Request.Requirement;
import com.glimmer.dto.OfficerInfo;
import com.glimmer.dto.Recommendation;
import com.glimmer.entity.RecommendUser;
import com.glimmer.result.Result;
import com.glimmer.server.RequirementService;
import com.glimmer.vo.StatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HrRequirementsController {

    @Autowired
    private RequirementService requirementService;

    @PostMapping("/requirement")
    Result<StatusVo> UpLoadRequirement(@RequestBody Requirement requirement){
        List<Recommendation> recommendation = requirementService.sendRequirement(requirement);
        if (recommendation == null){
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message("没有合适的推荐")
                    .build();
            return Result.error("失败",404,statusVo);
        }

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message(recommendation.toString())
                .build();
        return Result.success("成功",statusVo);
    }

    @PostMapping("/req")
    List<OfficerInfo> UpLoad(@RequestBody Requirement requirement){
        List<OfficerInfo> officerInfos = new ArrayList<>();
        officerInfos.add(new OfficerInfo("李俊霖","机器学习工程师","掌握python，熟悉pytorch，有CVPR paper，曾获得ACM金牌","30-60k*15薪","1234567890"));
        officerInfos.add(new OfficerInfo("张三","机器学习工程师","熟悉pytorch，掌握python，有ACL paper，熟悉NLP","30-60k*15薪","1982349987"));
        officerInfos.add(new OfficerInfo("李四","机器学习工程师","掌握C++，掌握python，熟悉pytorch，有IJCAI paper","20-60k*15薪","1789283445"));
        officerInfos.add(new OfficerInfo("李和","机器学习工程师","掌握python，熟悉TensorFlow，熟悉pytorch，有AAAI paper","25-50k*15薪","1223898767"));
        officerInfos.add(new OfficerInfo("王中","机器学习工程师","熟悉pytorch，熟悉Linux，掌握python，有SIGIR paper","20-45k*15薪","1987272777"));
        officerInfos.add(new OfficerInfo("郑同","机器学习工程师","开源贡献者，github源码者，掌握python，熟悉golang，有EMNLP paper，熟悉pytorch，","25-45k*15薪","12029292922"));

        return officerInfos;
    }
}
