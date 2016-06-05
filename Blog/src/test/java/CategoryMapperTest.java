import com.blog.dao.CategoryDao;
import com.blog.model.Category;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Created by Black on 2016/6/5.
 */
public class CategoryMapperTest {
    private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    }

    @Test
    public void testInsertCategory() throws Exception{
        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
        Category category = new Category();
        category.setCategoryName("blog");
        categoryDao.insertCategory(category);
    }

    @Test
    public void testDeleteCategoryById() throws Exception{
        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
        categoryDao.deleteCategoryById(2);
    }

    @Test
    public void testUpdateCategoryById() throws Exception{
        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
        Category category = new Category();
        category.setCid(1);
        category.setCategoryName("blog的搭建");
        categoryDao.updateCategoryById(category);
    }

    @After
    public void after() throws Exception {
    }
}
