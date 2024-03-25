package com.glimmer.controller.interactFront;



import com.glimmer.constant.HttpStatusConstant;
import com.glimmer.entity.User;
import com.glimmer.result.Result;
import com.glimmer.server.LoginService;
import com.glimmer.utils.JwtUtils;
import com.glimmer.vo.StatusVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


// 对于登录和注册的请求

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录账号
     */
    @PostMapping("/login")
    public Result<StatusVo> login(@RequestBody User user){
        log.info("用户登录:{}", user);
        User data = loginService.login(user);

        //登录成功，下发令牌
        if (data != null){
            Map<String, Object> claims = new HashMap<>();

            claims.put("username", user.getUsername());
            claims.put("password", user.getPassword());
            claims.put("phone", user.getPhone());

            String jwt = JwtUtils.generateJwt(claims);
            StatusVo statusVo = StatusVo.builder()
                    .status(1)
                    .message(jwt)
                    .build();
            return Result.success("登录成功",statusVo);
        }

        log.info("用户名或密码错误,登录失败");
        //登录失败
        StatusVo statusVo = StatusVo.builder()
                .status(0)
                .message("用户名或密码错误,登录失败")
                .build();
        return Result.error("用户名或密码错误,登录失败", HttpStatusConstant.BAD_REQUEST,statusVo);
    }

    /**
     * 注册账号
     */
    @PostMapping("/signup")
    public Result signup(@RequestBody User user) {
        log.info("用户注册:{}", user);
        loginService.signup(user);
        StatusVo statusVo = StatusVo.builder()
                .status(1)
                .message("注册成功")
                .build();
        return Result.success("成功",statusVo);
    }
}
