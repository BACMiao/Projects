package shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 *
 * Created by Black on 2016/7/26.
 */
public class AuthorizationTest extends BaseJunit4Test{

    @Before
    public void before() throws Exception {
    }

    @Test
    public void testAuthorization(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-permission.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println(subject.isAuthenticated());

        //基于角色授权，hasRole传入角色标识
        System.out.println(subject.hasRole("role1"));
        System.out.println(subject.hasAllRoles(Arrays.asList("role1", "role2")));

        //基于资源授权，isPermitted传入权限标识
        System.out.println(subject.isPermitted("user:create"));
        System.out.println(subject.isPermittedAll("user:create","user:update"));
        subject.logout();
    }

    @Test
    public void testAuthorizationCustomRealm(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("陈淼","111111");
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        System.out.println(subject.isAuthenticated());

        //基于资源授权，isPermitted传入权限标识
        System.out.println(subject.isPermitted("user:create"));
        System.out.println(subject.isPermittedAll("user:create","article:add"));
    }


    @After
    public void after() throws Exception {
    }
}
