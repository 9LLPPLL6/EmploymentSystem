package com.glimmer.server;




import com.glimmer.Request.Requirement;
import com.glimmer.entity.RecommendUser;

import java.util.List;

public interface RequirementService {

    RecommendUser sendRequirement(Requirement requirement);
}
