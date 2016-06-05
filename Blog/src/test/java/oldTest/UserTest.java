package oldTest;

import com.blog.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Black on 2016/5/22.
 * mybatis和spring整合后，该测试用例废弃
 */
public class UserTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws Exception {
        //为什么不让SqlSession 在before中创建，因为那样将使线程不安全
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //第一个参数：namespace+"."+statement的id
        User user = sqlSession.selectOne("com.blog.dao.UserDao.findUserById", 2);
        System.out.println(user.getUsername());
        sqlSession.close();
    }

    @Test
    public void testFindUserByName() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("com.blog.dao.UserDao.findUserByName", "陈");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void testInsertUser() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123");
        user.setEmail("123456@qq.com");
        user.setSex(1);
        sqlSession.insert("com.blog.dao.UserDao.insertUser", user);
        System.out.println(user.getUid());
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("com.blog.dao.UserDao.deleteUserById", 13);
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testUpdateUserById() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUid(2);
        user.setUsername("陈淼");
        user.setPassword("00000");
        user.setEmail("123456789@qq.com");
        user.setSex(1);
        sqlSession.update("com.blog.dao.UserDao.updateUserById", user);
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @After
    public void after() throws Exception {
    }
}
