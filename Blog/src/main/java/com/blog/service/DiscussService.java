package com.blog.service;

import com.blog.model.Discuss;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by Black on 2016/6/8.
 */
public interface DiscussService {
    public void addDiscuss(Discuss discuss, HttpSession session, Integer articleId) throws Exception;
}
