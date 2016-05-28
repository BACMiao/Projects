package com.blog.dao;

import com.blog.model.DiscussCustom;

import java.util.List;

/**
 * Created by Black on 2016/5/28.
 */
public interface DiscussDao {
    public List<DiscussCustom> findDiscussUser() throws Exception;
}
