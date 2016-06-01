package com.blog.service;

import com.blog.model.User;

/**
 * Created by Black on 2016/6/1.
 */
public interface UserService {
    public User findUserById(int uid) throws Exception;
}
