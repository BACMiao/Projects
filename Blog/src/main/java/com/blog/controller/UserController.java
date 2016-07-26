package com.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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
        return "user/userRegister";
    }

    @RequestMapping("/saveUser")
    public String saveUser(User user)throws Exception{
        //验证码
        //..
        userService.saveUser(user);
        return "user/success";
    }

    @RequestMapping("/login")
    public String login(){
        return "user/userLogin";
    }

    @RequestMapping(value = "/exist", produces = "text/html;charset=UTF-8")
    public @ResponseBody String existUser(User user, HttpSession session) throws Exception{
        //验证码
        //..
        JSONObject userLogin = new JSONObject();
        boolean result = userService.existUser(user);
        userLogin.put("result", result);
        if (result){
            user = userService.findUserByName(user.getUsername());
            session.setAttribute("loginUsername", user.getUsername());
            return userLogin.toJSONString();
        }else {
            return userLogin.toJSONString();
        }
    }

    @RequestMapping("/editUser")
    public String editUser(@RequestParam(value = "username", required = true) String username, Model model) throws Exception{
        User user = userService.findUserByName(username);
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
