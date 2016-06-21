package springTest;

import com.blog.model.Admin;
import com.blog.service.AdminService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * Created by Black on 2016/6/21.
 */
public class AdminServiceTest extends BaseJunit4Test {

    @Autowired
    private AdminService adminService;

    @Before
    public void before() throws Exception {
    }

    @Test
    public void testInjections(){
        Assert.assertNotNull(adminService);
    }

    @Test
    public void testUpdateAdminById() throws Exception{
        Admin admin = new Admin();
        admin.setUsername("cm");
        admin.setPassword("123456");
        adminService.updateAdminById(1, admin);
    }

    @Test
    public void testExistAdmin() throws Exception{
        Admin admin = new Admin();
        admin.setUsername("cm");
        admin.setPassword("000000");
        Assert.assertTrue(adminService.existAdmin(admin));
    }

    @After
    public void after() throws Exception {
    }
}
