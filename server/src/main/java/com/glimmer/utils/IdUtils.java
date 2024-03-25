package com.glimmer.utils;

import com.glimmer.mapper.IdMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class IdUtils {

    @Autowired
    private IdMapper idMapper;
    private static final String signKey = "EmploymentSystem";

    public Integer getId() {

        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes()))
                .getRequest();
        String token = request.getHeader("token");
        Jws<Claims> claimsJwts = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(token);

        Claims claims = claimsJwts.getBody();
        String username = (String) claims.get("username");
        String password = (String) claims.get("password");

        return idMapper.selectId(username,password);
//        String username = "tom";
//        String password = "123456";
//
//        return idMapper.selectId(username, password);
    }

}
