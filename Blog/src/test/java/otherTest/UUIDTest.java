package otherTest;

import com.blog.util.UUIDGenerator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.UUID;


/**
 *
 * Created by Black on 2016/6/4.
 */
public class UUIDTest {
    @Before
    public void before() throws Exception {
    }

    @Test
    public void testUUID() throws IOException {
        System.out.println(UUIDGenerator.getUUID());
    }

    @After
    public void after() throws Exception {
    }
}
