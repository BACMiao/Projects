package com.blog.dao;

import com.blog.model.User;

import java.util.List;

/**
 * Created by Black on 2016/5/21.
 **/
public interface UserDao {
    public User findUserById(int uid) throws Exception;
    public List<User> findUserByName(String username) throws Exception;
    public List<User> findUserByList(User user) throws Exception;
    public void insertUser(User user) throws Exception;
    public void deleteUserById(int uid) throws  Exception;
    public User updateUserById(User user) throws Exception;
}
