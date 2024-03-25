package com.glimmer.mapper;


import com.glimmer.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {

    /**
     *查询数据库
     */
    @Select("select * from users where username = #{username} and password = #{password}")
    User login(User user);

    /**
     * 将用户信息、密码以及电话号码插入数据库
     */
    @Insert("insert into users (username,password,phone) values (#{username},#{password},#{phone})")
    void signup(User user);

}
