package com.glimmer.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IdMapper {
    @Select("select id from employment_system.users where username = #{username} and password = #{password}")
    public Integer selectId(@Param("username") String username, @Param("password") String password);
}
