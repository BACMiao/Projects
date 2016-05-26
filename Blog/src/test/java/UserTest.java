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
 */
public class UserTest {
    @Before
    public void before() throws Exception {
    }

    @Test
    public void findUserById() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = sqlSession.selectOne("user.findUserById", 1);
        System.out.println(user.getUsername());
        sqlSession.close();
    }

    @Test
    public void findUserByName() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> list = sqlSession.selectList("user.findUserByName", "陈");
        System.out.println(list);
        sqlSession.close();
    }

    @Test
    public void insertUser() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUsername("陈鑫");
        user.setPassword("123");
        user.setEmail("123456@qq.com");
        user.setSex(1);
        sqlSession.insert("user.insertUser", user);
        System.out.println(user.getUid());
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUserById() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("user.deleteUserById", 11);
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void updateUserById() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        User user = new User();
        user.setUid(2);
        user.setUsername("陈淼");
        user.setPassword("00000");
        user.setEmail("123456789@qq.com");
        user.setSex(1);
        sqlSession.update("user.updateUserById", user);
        //执行提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @After
    public void after() throws Exception {
    }

}
