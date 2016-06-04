package com.blog.controller;

import com.blog.model.Admin;
import com.blog.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by Black on 2016/6/4.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    AdminService adminService;

    @RequestMapping("/login")
    public String login(){
        return "admin/adminLogin";
    }

    @RequestMapping("/exist")
    public String existAdmin(Admin admin) throws Exception{
        if (adminService.existAdmin(admin)){
            return "admin/success";
        }else {
            return "admin/failure";
        }
    }

}
