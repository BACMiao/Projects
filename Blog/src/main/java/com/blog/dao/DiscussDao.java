package com.blog.dao;

import com.blog.model.Discuss;
import com.blog.model.DiscussCustom;
import com.blog.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Black on 2016/5/28.
 */
@Repository
public interface DiscussDao {
    public List<DiscussCustom> findDiscussUser() throws Exception;
    public void insertDiscuss(Discuss discuss) throws Exception;
    public void deleteDiscussById(int did) throws  Exception;
}
