package ServiceTest;

import com.blog.dao.CategoryDao;
import com.blog.model.Category;
import com.blog.service.CategoryService;
import com.blog.serviceImpl.CategoryServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Black on 2016/6/5.
 */
public class CategoryServiceTest {
    private ApplicationContext applicationContext;
    @Before
    public void before() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-mybatis.xml");
    }

    @Test
    public void testAddCategory() throws Exception{
//        CategoryDao categoryDao = (CategoryDao) applicationContext.getBean("categoryDao");
//        CategoryService categoryService = new CategoryServiceImpl();
//        Category category = new Category();
//        category.setCategoryName("spring学习");
//        categoryService.addCategory(category);
    }

    @After
    public void after() throws Exception {
    }
}
