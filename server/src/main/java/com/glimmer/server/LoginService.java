package com.glimmer.server;


import com.glimmer.entity.User;

public interface LoginService {

    /**
    * 注册用户信息，
    * 并将其加入数据库。
    * */
    User login(User user);

    /**
     * 接受用户名和密码，
     * 将其与数据库中的数据匹配，
     * 匹配成功返回相应信息。
     */
    void signup(User user);
}
