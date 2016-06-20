package com.blog.controller;

import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by Black on 2016/6/1.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/register")
    public String register()
    {
        return "user/saveUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user)throws Exception{
        userService.saveUser(user);
        return "user/success";
    }

    @RequestMapping("/login")
    public String login(){
        return "user/userLogin";
    }

    @RequestMapping("/exist")
    public String existUser(User user, HttpSession session) throws Exception{
        if (userService.existUser(user)){
            user = userService.findUserByName(user.getUsername());
            session.setAttribute("loginUsername", user.getUsername());
            return "user/success";
        }else {
            return "user/failure";
        }
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam(value = "uid", required = true) Integer uid, Model model) throws Exception{
        User user = userService.findUserById(uid);
        model.addAttribute("user", user);
        System.out.println(user);
        return "user/editUser";
    }

    @RequestMapping("/updateUser")
    public String updateUser(Integer uid, User user)throws Exception{
        userService.updateUserById(uid, user);
        return "user/editUser";
    }

    @RequestMapping("/userLogout")
    public String userLogout(HttpSession session){
        if (session.getAttribute("loginUsername")!=null){
            session.removeAttribute("loginUsername");
        }
        return "redirect:/";
    }
}
