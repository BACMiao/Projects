package otherTest;

import com.blog.util.TimeUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Created by Black on 2016/6/6.
 */
public class TimeTest {
    @Before
    public void before() throws Exception {
    }

    @Test
    public void testTime() throws Exception{
        SimpleDateFormat dateformat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
        String a1 = dateformat1.format(new Date());
        System.out.println("时间1:" + a1);
        SimpleDateFormat dateformat2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒 E ");
        String a2 = dateformat2.format(new Date());
        System.out.println("时间2:" + a2);
    }

    @Test
    public void testTime2() throws Exception{
        System.out.println(TimeUtil.addTime());
    }

    @After
    public void after() throws Exception {
    }
}
