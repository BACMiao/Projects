package com.blog.service;

import com.blog.model.User;

/**
 *
 * Created by Black on 2016/6/1.
 */

public interface UserService {
    public User findUserById(Integer uid) throws Exception;
    public void updateUserById(Integer uid, User user) throws Exception;
}