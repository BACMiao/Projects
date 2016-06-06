package com.blog.controller;

import com.blog.model.Article;
import com.blog.service.ArticleService;
import com.blog.util.TimeUtil;
import com.blog.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 *
 * Created by Black on 2016/6/6.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/add")
    public String add(){
        return "article/add";
    }

    @RequestMapping("/addCategory")
    public String addCategory(@RequestParam("file") CommonsMultipartFile file,
                              Article article, HttpServletRequest request) throws Exception {
        article.setCreateTime(TimeUtil.addTime());
        article.setArticlePath(UploadUtil.upload(file, article, request));
        articleService.addArticle(article);
        return "article/success";
    }
}