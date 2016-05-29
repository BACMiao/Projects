import com.blog.dao.UserDao;
import com.blog.model.User;
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
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    }

    @Test
    public void testFindUserById() throws Exception{
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        User user = userDao.findUserById(2);
        System.out.println(user);
    }
}
