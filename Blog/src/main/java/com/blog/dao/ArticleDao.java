package com.blog.dao;

import com.blog.model.Article;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * Created by Black on 2016/6/4.
 */
@Repository
public interface ArticleDao {
    public Article findArticleById(int id) throws Exception;
    public Article findArticleByTitle(String title) throws Exception;
    public List<Article> findArticleByList(Article article) throws Exception;
    public void insertArticle(Article article) throws Exception;
    public void deleteArticleById(int id) throws  Exception;
    public void updateArticleById(Article article) throws Exception;
}