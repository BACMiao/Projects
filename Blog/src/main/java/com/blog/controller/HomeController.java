package com.blog.controller;

import com.blog.model.Article;
import com.blog.model.ArticleCustom;
import com.blog.service.ArticleService;
import com.blog.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/")
    public String index(Model model) throws Exception {
        List<ArticleCustom> articles = articleService.selectAllArticle();
        System.out.println(articles);
        model.addAttribute("articles", articles);
        return "index";
    }

}
