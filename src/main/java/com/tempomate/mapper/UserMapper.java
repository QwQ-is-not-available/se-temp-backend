package com.tempomate.mapper;

import com.tempomate.pojo.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user")  //用来测试 实际不使用 Used for testing, not actually used
    public List<User> getUserList();

    @Select("SELECT token FROM user WHERE user_id = #{userId}")  //性能测试用的，需要数据库手动写入token
    public String getUserToken(String userId);

    @Insert("insert into user(user_id, nickname, password, token) " +
            "values (#{userId},#{nickname},#{password},#{token});")
    public void insertUser(User user);


    @Select("select count(*) from user where user_id=#{userId} and password=#{password}")
    public Integer login(User user);

    @Update("update user set nickname=#{nickname} where user_id=#{userId}")
    public Integer change_nickname(User user);

    @Update("update user set push_setting=#{pushSetting} where id=#{id}")
    public Integer push_setting(User user);

}
