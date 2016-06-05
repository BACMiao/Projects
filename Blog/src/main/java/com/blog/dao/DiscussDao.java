package com.blog.dao;

import com.blog.model.Discuss;
import com.blog.model.DiscussCustom;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Black on 2016/5/28.
 */
@Repository
public interface DiscussDao {
    public List<DiscussCustom> findDiscussUser() throws Exception;
//    public void insertDisscuss(User user) throws Exception;
//    public void deleteUserById(int uid) throws  Exception;
//    public void updateUserById(User user) throws Exception;
}
