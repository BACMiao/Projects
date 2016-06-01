package com.blog.serviceImpl;


import com.blog.dao.UserDao;
import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * Created by Black on 2016/5/31.
 */
@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Override
    public User findUserById(int uid) throws Exception {
        return userDao.findUserById(uid);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
