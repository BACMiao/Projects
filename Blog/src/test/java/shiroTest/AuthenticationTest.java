package shiroTest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * Created by Black on 2016/7/26.
 */
public class AuthenticationTest  extends BaseJunit4Test{

    @Before
    public void before() throws Exception {
    }

    //用户登录和退出
    @Test
    public void testLoginAndLogout(){
        //创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //将securityManager设置到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //从SecurityUtils里边创建一个Subject
        Subject subject = SecurityUtils.getSubject();
        //在认证提交前需要准备token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken("cm","000");
        //执行认证提交
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }

    @Test
    public void testCustomRealm(){
        //创建securityManager工厂
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-realm.ini");
        //创建SecurityManager
        SecurityManager securityManager = factory.getInstance();
        //将securityManager设置到当前运行环境中
        SecurityUtils.setSecurityManager(securityManager);
        //从SecurityUtils里边创建一个Subject
        Subject subject = SecurityUtils.getSubject();
        //在认证提交前需要准备token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken("陈淼","111111");
        //执行认证提交
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(true, subject.isAuthenticated());
        subject.logout();
    }


    @After
    public void after() throws Exception {
    }
}
