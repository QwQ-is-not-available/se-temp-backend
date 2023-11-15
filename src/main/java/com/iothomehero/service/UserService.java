package com.iothomehero.service;

import com.iothomehero.pojo.entity.User;

public interface UserService {
    /**
     * new user
     * @param user
     */
    public void userSignup(User user);
    public Integer login(User user);
    public Integer change_nickname(User user);
}
