package com.glimmer.server;




import com.glimmer.Request.Requirement;

import java.util.List;

public interface RequirementService {

    List<String> sendRequirement(Requirement requirement);
}
