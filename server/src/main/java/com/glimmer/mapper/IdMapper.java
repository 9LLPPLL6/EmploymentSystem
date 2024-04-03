package com.glimmer.mapper;

import com.glimmer.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;

@Mapper
public interface IdMapper {
    @Select("select id from employment_system.users where username = #{username} and password = #{password}")
    Integer selectId(User user);
}
