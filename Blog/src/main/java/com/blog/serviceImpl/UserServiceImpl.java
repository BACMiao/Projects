package com.blog.serviceImpl;

import com.blog.dao.UserDao;
import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by Black on 2016/5/31.
 */
@Service
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Override
    public User findUserById(Integer uid) throws Exception {
        return userDao.findUserById(uid);
    }

    @Override
    public void updateUserById(Integer uid, User user) throws Exception {
        user.setUid(uid);
        userDao.updateUserById(user);
    }

    @Override
    public void saveUser(User user) throws Exception {
        userDao.insertUser(user);
    }

    @Override
    public boolean existUser(User user) throws Exception {
        if (user.getUsername()!= null && user.getUsername()!= " "){
            User user1 = userDao.findUserByName(user.getUsername());
            if (user1!=null){
                if (user1.getPassword().equals(user.getPassword())){
                    return true;
                }
            }
        }
        return false;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
