import com.blog.dao.DiscussDao;
import com.blog.dao.UserDao;
import com.blog.model.DiscussCustom;
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
 * Created by Black on 2016/5/28.
 */
public class DiscussDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void before() throws Exception {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    @Test
    public void findDiscussUser() throws Exception {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DiscussDao discussDao = sqlSession.getMapper(DiscussDao.class);
        List<DiscussCustom> list = discussDao.findDiscussUser();
        System.out.println(list);
        sqlSession.close();
    }

    @After
    public void after() throws Exception {
    }
}
