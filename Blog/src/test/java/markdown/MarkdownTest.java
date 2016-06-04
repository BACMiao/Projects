package markdown;

import org.markdown4j.Markdown4jProcessor;

import java.io.*;


/**
 *
 * Created by Black on 2016/6/4.
 */
public class MarkdownTest {
    public static void main(String[] args) throws IOException {
        String html = new Markdown4jProcessor().process("> or formatting instructions.");
        System.out.println(html);
    }
}
