package mapperTest;

import com.blog.dao.DiscussDao;
import com.blog.model.Discuss;
import com.blog.util.UUIDGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 *
 * Created by Black on 2016/6/5.
 */
public class DiscussMapperTest {

private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    }

    @Test
    public void testInsertDiscuss() throws Exception{
        DiscussDao discussDao = (DiscussDao) applicationContext.getBean("discussDao");
        Discuss discuss = new Discuss();
        discuss.setCreateTime(new Date());
        discuss.setArticleId(1);
        discuss.setMessage("测试测试2");
        discuss.setUserId(2);
        discuss.setOwnId(UUIDGenerator.getUUID());
        discussDao.insertDiscuss(discuss);
    }

    @Test
    public void testUpdateAdminById() throws Exception{
        DiscussDao discussDao = (DiscussDao) applicationContext.getBean("discussDao");
        discussDao.deleteDiscussById(2);
    }

    @Test
    public void testFindDiscussUser() throws Exception{
        DiscussDao discussDao = (DiscussDao) applicationContext.getBean("discussDao");
        System.out.println(discussDao.findDiscussUser(3));
    }

    @Test
    public void testFindDiscussById() throws Exception{
        DiscussDao discussDao = (DiscussDao) applicationContext.getBean("discussDao");
        System.out.println(discussDao.findDiscussById(5));
    }

    @After
    public void after() throws Exception {

    }

}
