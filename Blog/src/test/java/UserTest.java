import com.blog.model.User;
import com.mysql.cj.api.Session;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

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
        User user = sqlSession.selectOne("User.findUserById", 1);
        System.out.println(user);
        sqlSession.close();
    }

    @After
    public void after() throws Exception {
    }

}
