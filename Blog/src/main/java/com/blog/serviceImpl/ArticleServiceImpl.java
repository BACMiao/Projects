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
    public void addArticle(Article article) throws Exception {
        articleDao.insertArticle(article);
    }

    public ArticleDao getArticleDao() {
        return articleDao;
    }

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
}
