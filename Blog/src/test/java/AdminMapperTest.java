import com.blog.dao.AdminDao;
import com.blog.model.Admin;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Created by Black on 2016/6/5.
 */
public class AdminMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    }

    @Test
    public void testFindAdminByList() throws Exception{
        AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
        Admin admin = new Admin();
        admin.setUsername("cm");
        admin.setPassword("345335911");
        System.out.println(adminDao.findAdminByList(admin));
    }

    @Test
    public void testUpdateAdminById() throws Exception{
        AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
        Admin admin = new Admin();
        admin.setAid(1);
        admin.setUsername("cm");
        admin.setPassword("000000");
        adminDao.updateAdminById(admin);
    }

    @After
    public void after() throws Exception {
    }
}
