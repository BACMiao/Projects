package com.blog.controller;

import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * Created by Black on 2016/6/5.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping("/add")
    public String add(){
        return "category/add";
    }

    @RequestMapping("/addCategory")
    public String addCategory(Category category) throws Exception {
        categoryService.addCategory(category);
        return "category/success";
    }
}
