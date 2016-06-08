package com.blog.serviceImpl;

import com.blog.dao.DiscussDao;
import com.blog.model.Discuss;
import com.blog.service.DiscussService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * Created by Black on 2016/6/8.
 */

@Service
public class DiscussServiceImpl implements DiscussService {

    DiscussDao discussDao;

    @Override
    public void addDiscuss(Discuss discuss) throws Exception {
        discussDao.insertDiscuss(discuss);

    }

    public DiscussDao getDiscussDao() {
        return discussDao;
    }

    @Autowired
    public void setDiscussDao(DiscussDao discussDao) {
        this.discussDao = discussDao;
    }
}
