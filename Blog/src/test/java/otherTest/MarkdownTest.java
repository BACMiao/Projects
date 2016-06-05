package otherTest;

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
        String html = new Markdown4jProcessor().process("> or formatting instructions.");
        System.out.println(html);
    }

    @After
    public void after() throws Exception {
    }
}
