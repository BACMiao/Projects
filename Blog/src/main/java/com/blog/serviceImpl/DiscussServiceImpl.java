package com.blog.serviceImpl;

import com.blog.dao.DiscussDao;
import com.blog.model.Discuss;
import com.blog.model.DiscussCustom;
import com.blog.model.User;
import com.blog.service.DiscussService;
import com.blog.util.TimeUtil;
import com.blog.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * Created by Black on 2016/6/8.
 */

@Service
public class DiscussServiceImpl implements DiscussService {

    DiscussDao discussDao;

    @Override
    public void addDiscuss(Discuss discuss, HttpSession session, Integer articleId) throws Exception {
        User user = (User) session.getAttribute("user");
        System.out.println(user.getUid());
        discuss.setUserId(user.getUid());
        discuss.setArticleId(articleId);
        discuss.setCreateTime(TimeUtil.addTime());
        discuss.setOwnId(UUIDGenerator.getUUID());
        discussDao.insertDiscuss(discuss);

    }

    @Override
    public List<DiscussCustom> getAllDiscuss(Integer articleId) throws Exception {
        List<DiscussCustom> list = discussDao.findDiscussUser(articleId);
        return list;
    }

    public DiscussDao getDiscussDao() {
        return discussDao;
    }

    @Autowired
    public void setDiscussDao(DiscussDao discussDao) {
        this.discussDao = discussDao;
    }
}
