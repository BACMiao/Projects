package com.blog.service;

import com.blog.model.Category;

/**
 * Created by Black on 2016/6/5.
 */
public interface CategoryService {
    public boolean existCategory(String categoryName) throws Exception;
    public void addCategory(Category category) throws Exception;
    public void deleteCategory(Integer cid) throws Exception;
    public void updateCategory(Integer cid, Category category) throws Exception;
}
