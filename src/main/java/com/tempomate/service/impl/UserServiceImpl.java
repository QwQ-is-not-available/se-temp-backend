package com.tempomate.service.impl;

import com.tempomate.mapper.UserMapper;
import com.tempomate.pojo.entity.User;
import com.tempomate.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void userSignup(User user) {
        userMapper.insertUser(user);
    }

    @Override
    public Integer login(User user) {
        return userMapper.login(user);
    }

    @Override
    public Integer change_nickname(User user) {
        return userMapper.change_nickname(user);
    }

    @Override
    public Integer push_setting(User user) { return userMapper.push_setting(user);}

}
