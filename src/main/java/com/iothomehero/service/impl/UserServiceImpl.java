package com.iothomehero.service.impl;

import com.iothomehero.mapper.UserMapper;
import com.iothomehero.pojo.entity.User;
import com.iothomehero.service.UserService;
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

}
