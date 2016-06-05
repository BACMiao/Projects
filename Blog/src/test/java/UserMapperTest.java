import com.blog.dao.UserDao;
import com.blog.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by Black on 2016/5/29.
 *
 */
public class UserMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    }

    @Test
    public void testFindUserById() throws Exception{
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserById(5);
        System.out.println(user);
    }

    @After
    public void after() throws Exception {
    }
}
