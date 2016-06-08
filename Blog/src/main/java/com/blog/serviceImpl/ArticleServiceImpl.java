package com.blog.serviceImpl;

import com.blog.dao.ArticleDao;
import com.blog.model.Article;
import com.blog.service.ArticleService;
import com.blog.util.MarkdownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * Created by Black on 2016/6/6.
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    @Override
    public boolean existArticle(String title) throws Exception {
        Article article = articleDao.findArticleByTitle(title);
        if (article!=null && article.getTitle()!=""){
            return true;
        }
        return false;
    }

    @Override
    public String getArticle(Integer id, HttpServletRequest request) throws Exception {
        Article article = articleDao.findArticleById(id);
        //数据库的路径
        String Path = article.getArticlePath();
        String realPathDir = request.getSession().getServletContext().getRealPath("/");
        String path = "";
        for (String s: realPathDir.split("\\\\")) {
            if (s.equalsIgnoreCase("target"))
            {
                break;
            }
            else {
                s = s + "\\";
            }
            path += s;
        }
        //真实文件路径
        String articlePath = path + "src\\main\\webapp\\" + Path;
        System.out.println(articlePath);
        String blog = MarkdownUtil.read(articlePath);
        return blog;
    }

    @Override
    public List<Article> selectAllArticle() throws Exception {
        return articleDao.findAllArticle();
    }

    @Override
    public void addArticle(Article article) throws Exception {
        if (existArticle(article.getTitle())) {
            System.out.println("文件存在");
        }
        else {
            System.out.println("上传成功");
            articleDao.insertArticle(article);
        }
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}
