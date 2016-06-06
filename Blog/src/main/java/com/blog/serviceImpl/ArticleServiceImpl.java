package com.blog.serviceImpl;

import com.blog.dao.ArticleDao;
import com.blog.model.Article;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
