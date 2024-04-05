package com.glimmer;

import com.glimmer.entity.User;
import com.glimmer.mapper.IdMapper;
import com.glimmer.utils.IdUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class test {
    @Autowired
    private IdUtils idUtils;
    @Autowired
    private IdMapper idMapper;
    @Test
    public void testId(){
        System.out.println(idUtils.getId(new User()).getId());
    }
}
