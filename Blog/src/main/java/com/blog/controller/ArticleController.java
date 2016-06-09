package com.blog.controller;

import com.alibaba.fastjson.JSONObject;
import com.blog.model.Article;
import com.blog.model.DiscussCustom;
import com.blog.service.ArticleService;
import com.blog.service.DiscussService;
import com.blog.util.TimeUtil;
import com.blog.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * Created by Black on 2016/6/6.
 */
@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private DiscussService discussService;

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

    @RequestMapping("/viewArticle")
    public String viewArticle(@RequestParam(value = "id", required = true) Integer id,
                              Model model) throws Exception {
        Article article = articleService.selectArticleById(id);
        List<List> lists = discussService.getAllDiscuss(id);
        model.addAttribute("discuss", lists.get(0));
        model.addAttribute("reply", lists.get(1));
        model.addAttribute("article", article);
        return "article/viewArticle";
    }

    @RequestMapping(value="/json", produces = "text/html;charset=UTF-8")
    public @ResponseBody String jsonArticle(@RequestParam(value = "id", required = true)Integer id,
                                         HttpServletRequest request) throws Exception {
        String msg = articleService.getArticle(id, request);
        JSONObject article = new JSONObject();
        article.put("msg", msg);
        System.out.println(article.toString());
        return article.toJSONString();
    }
}
