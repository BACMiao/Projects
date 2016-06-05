import com.blog.dao.ArticleDao;
import com.blog.model.Article;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 *
 * Created by Black on 2016/6/5.
 */
public class ArticleMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    }

    @Test
    public void testFindArticleById() throws Exception{
        ArticleDao articleDao = (ArticleDao) applicationContext.getBean("articleDao");
        Article article = articleDao.findArticleById(1);
        System.out.println(article);
    }

    @Test
    public void testFindArticleByTitle() throws Exception{
        ArticleDao articleDao = (ArticleDao) applicationContext.getBean("articleDao");
        Article article = articleDao.findArticleByTitle("搭建");
        System.out.println(article);
    }

    @Test
    public void testFindArticleByList() throws Exception{
        ArticleDao articleDao = (ArticleDao) applicationContext.getBean("articleDao");
        Article article = new Article();
        article.setCategoryId(1);
        article.setTitle("搭建");
        System.out.println(articleDao.findArticleByList(article));
    }

    @Test
    public void testInsertArticle() throws Exception{
        ArticleDao articleDao = (ArticleDao) applicationContext.getBean("articleDao");
        Article article = new Article();
        article.setTitle("mybatis的使用");
        article.setCategoryId(2);
        article.setArticlePath("/txt/test4.txt");
        article.setCreateTime(new Date());
        articleDao.insertArticle(article);
    }

    @Test
    public void testDeleteArticleById() throws Exception{
        ArticleDao articleDao = (ArticleDao) applicationContext.getBean("articleDao");
        articleDao.deleteArticleById(6);
    }

    @Test
    public void testUpdateArticleById() throws Exception{
        ArticleDao articleDao = (ArticleDao) applicationContext.getBean("articleDao");
        Article article = new Article();
        article.setId(3);
        article.setTitle("mybatis使用");
        article.setCategoryId(3);
        article.setCreateTime(new Date());
        articleDao.updateArticleById(article);
    }



    @After
    public void after() throws Exception {
    }
}
