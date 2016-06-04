package com.blog.model;

import java.util.Date;

/**
 *
 * Created by Black on 2016/6/4.
 */
public class Article {
    private int id;
    private Date createTime;
    private String articlePath;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getArticlePath() {
        return articlePath;
    }

    public void setArticlePath(String articlePath) {
        this.articlePath = articlePath;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", createTime=" + createTime +
                ", articlePath='" + articlePath + '\'' +
                ", categoryId=" + categoryId +
                '}';
    }
}
