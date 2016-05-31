package com.blog.daoImpl;


import com.blog.dao.UserDao;
import com.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Black on 2016/5/31.
 */
public class UserDaoImpl implements UserDao{
    @Autowired
    private UserDao userDao;

    @Override
    public User findUserById(int uid) throws Exception {
        return userDao.findUserById(uid);
    }

    @Override
    public List<User> findUserByName(String username) throws Exception {
        return null;
    }

    @Override
    public List<User> findUserByList(User user) throws Exception {
        return null;
    }

    @Override
    public void insertUser(User user) throws Exception {

    }

    @Override
    public void deleteUserById(int uid) throws Exception {

    }

    @Override
    public void updateUserById(User user) throws Exception {

    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
