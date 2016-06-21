package springTest;

import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * Created by Black on 2016/6/5.
 */
public class CategoryServiceTest extends BaseJunit4Test {

    @Autowired
    private CategoryService categoryService;

    @Before
    public void before() throws Exception {
    }

    @Test
    public void testInjections(){
        Assert.assertNotNull(categoryService);
    }

    @Test
    public void testFindCategoryById() throws Exception{
        System.out.println(categoryService.findCategoryById(1));
    }

    @Test
    public void testAddCategory() throws Exception{
        Category category = new Category();
        category.setCategoryName("maven的使用");
        categoryService.addCategory(category);
    }


    @After
    public void after() throws Exception {
    }
}
