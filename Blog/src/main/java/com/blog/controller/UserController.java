package com.blog.controller;

import com.blog.dao.UserDao;
import com.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Black on 2016/6/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {
//
//    @Autowired
//    private UserDao userDao;
//    @RequestMapping("/")
//    public String findUser() throws Exception {
//        User user = userDao.findUserById(1);
//        System.out.println(user);
//        return "findUser";
//    }
}
