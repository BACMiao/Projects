package shiroTest;

import com.blog.dao.UserDao;
import com.blog.model.User;
import com.blog.util.MD5;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Key;

/**
 * Created by Black on 2016/7/22.
 */
public class passwordTest extends BaseJunit4Test{
    @Autowired
    private UserDao userDao;

    @Before
    public void before() throws Exception {

    }

    @Test
    public void testPassword() {
        String str = "hello";
        String salt = "123";
        String md5 = new Md5Hash(str, salt).toString();//还可以转换为 toBase64()/toHex()
        System.out.println(md5);
    }

    @Test
    public void testAES(){
        AesCipherService aesCipherService = new AesCipherService();
        aesCipherService.setKeySize(128); //设置key长度
        //生成key
        Key key = aesCipherService.generateNewKey();
        String text = "hello";
        //加密
        String encrptText =
                aesCipherService.encrypt(text.getBytes(), key.getEncoded()).toHex();
        System.out.println(encrptText);
        //解密
        String text2 =
                new String(aesCipherService.decrypt(Hex.decode(encrptText), key.getEncoded()).getBytes());

        Assert.assertEquals(text, text2);
    }
    @Test
    public void MD5() throws Exception {
        User user = userDao.findUserById(1);
        String password_md5 = MD5.lock(user);
        System.out.println(password_md5);
    }

    @After
    public void after() throws Exception {
    }
}
