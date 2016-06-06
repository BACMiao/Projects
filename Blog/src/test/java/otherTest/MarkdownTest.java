package otherTest;

import com.blog.util.MarkdownUtil;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.markdown4j.Markdown4jProcessor;

import java.io.*;


/**
 *
 * Created by Black on 2016/6/4.
 */
public class MarkdownTest {
    @Before
    public void before() throws Exception {
    }

    @Test
    public void testMarkdown() throws IOException {
        BufferedReader in = new BufferedReader(new FileReader("E:\\computer\\text.txt"));
        String s;
        StringBuilder sb = new StringBuilder();
        while ((s = in.readLine()) != null){
            sb.append(s + "\n");
        }
        in.close();
        String html = new Markdown4jProcessor().process(sb.toString());
        System.out.println(html);
    }

    @Test
    public void testMarkdown2() throws Exception {
        System.out.println(MarkdownUtil.read("E:\\computer\\text.txt"));
    }

    @After
    public void after() throws Exception {
    }
}
