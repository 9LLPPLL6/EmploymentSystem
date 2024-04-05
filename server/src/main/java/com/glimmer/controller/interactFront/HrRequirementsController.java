package com.glimmer.controller.interactFront;


import com.glimmer.Request.Requirement;
import com.glimmer.dto.Recommendation;
import com.glimmer.result.Result;
import com.glimmer.server.RequirementService;
import com.glimmer.vo.StatusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HrRequirementsController {

    @Autowired
    private RequirementService requirementService;
    @PostMapping("/requirement")
    Result<StatusVo> UpLoadRequirement(@RequestBody Requirement requirement){
        List<Recommendation> recommendationList = requirementService.sendRequirement(requirement);
        if (recommendationList == null){
            StatusVo statusVo = StatusVo.builder()
                    .status(0)
                    .message("没有合适的推荐")
                    .build();
            return Result.error("失败",404,statusVo);
        }

        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message(recommendationList.toString())
                .build();
        return Result.success("成功",statusVo);
    }
}
