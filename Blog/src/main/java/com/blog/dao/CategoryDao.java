package com.blog.dao;

import com.blog.model.Category;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by Black on 2016/6/5.
 */
@Repository
public interface CategoryDao {
    public Category findCategoryByName(String categoryName) throws Exception;
    public void insertCategory(Category category) throws Exception;
    public void deleteCategoryById(int cid) throws  Exception;
    public void updateCategoryById(Category category) throws Exception;
}
