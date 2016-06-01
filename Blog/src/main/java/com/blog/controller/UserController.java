package com.blog.controller;

import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * Created by Black on 2016/6/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/editUser")
    public String editUser(@RequestParam(value = "uid", required = true) Integer uid) throws Exception{
        User user = userService.findUserById(uid);
        System.out.println(user);
        return "user/editUser";
    }
}
