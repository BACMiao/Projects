package markdown;

import org.markdown4j.Markdown4jProcessor;

import java.io.IOException;

/**
 *
 * Created by Black on 2016/6/4.
 * printf为<p>This is a <strong>bold</strong> text</p>
 */
public class MarkdownTest {
    public static void main(String[] args) throws IOException {
        String html = new Markdown4jProcessor().process("This is a **bold** text");
        System.out.println(html);
    }
}
