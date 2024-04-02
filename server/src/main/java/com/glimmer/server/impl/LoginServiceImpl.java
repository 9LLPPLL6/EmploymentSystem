package com.glimmer.server.impl;


import com.glimmer.entity.User;
import com.glimmer.exception.LoginException;
import com.glimmer.mapper.LoginMapper;
import com.glimmer.server.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.C;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;



@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public User login(User user) {
        return loginMapper.login(user);
    }

    @Override
    public void signup(User user) {

        if (user.getUsername() == null
                || user.getPassword() == null
                || user.getPhone() == null) {
            throw new LoginException("注册信息不得为空");
        }

        loginMapper.signup(user);
    }

}
