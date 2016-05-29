import com.blog.dao.UserDao;
import com.blog.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 *
 * Created by Black on 2016/5/26.
 * mybatis和spring整合后，该测试用例废弃
 */
public class UserDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void testFindUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = userDao.findUserById(2);
        System.out.println(user);
        sqlSession.close();
    }

    @Test
    public void testFindUserByName() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> list = userDao.findUserByName("陈");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void findUserByList() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        User user = new User();
        user.setSex(1);
//        user.setUsername("陈");
        List<User> users = userDao.findUserByList(user);
        System.out.println(users);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("李四");
        user.setPassword("123");
        user.setEmail("123456@qq.com");
        user.setSex(1);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.insertUser(user);
        System.out.println(user.getUid());
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.deleteUserById(14);
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUserById() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUid(2);
        user.setUsername("陈淼");
        user.setPassword("00000");
        user.setEmail("100000@qq.com");
        user.setSex(1);
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userDao.updateUserById(user);
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @After
    public void after() throws Exception {
    }
}
