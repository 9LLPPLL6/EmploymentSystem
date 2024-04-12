package com.glimmer.server;




import com.glimmer.Request.Requirement;
import com.glimmer.dto.Recommendation;
import com.glimmer.entity.RecommendUser;

import java.util.List;

public interface RequirementService {

    List<Recommendation> sendRequirement(Requirement requirement);
}
