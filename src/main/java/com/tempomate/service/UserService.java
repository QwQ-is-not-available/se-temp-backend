package com.tempomate.service;

import com.tempomate.pojo.entity.User;

public interface UserService {
    /**
     * new user
     * @param user
     */
    public void userSignup(User user);
    public Integer login(User user);
    public Integer change_nickname(User user);
    public Integer push_setting(User user);
}
