package learnspring.springdatajpa;

import learnspring.springdatajpa.dao.CategoryDAO;
import learnspring.springdatajpa.dbitems.Category;
import learnspring.springdatajpa.dbitems.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class CategoryTest extends DBAbstract {

    @Autowired
    private CategoryDAO categoryDAO;

    private String categoryTable = "public.category";

    @Test
    public void saveTest(){
        Category u = new Category();
        u.setName("Terry");

        int cntOld = countRowsInTable(this.categoryTable);
        this.categoryDAO.save(u);
        int cntNew = countRowsInTable(this.categoryTable);

        assertEquals("After save category", cntOld + 1, cntNew);
    }

    @Test
    public void findByIdTest(){
        Category u = categoryDAO.findById(1);

        assertNotNull(u);
        assertEquals("Traveling", u.getName());
    }

    @Test
    public void getAllTest(){
        List<Category> all = categoryDAO.getAll(0, Integer.MAX_VALUE);

        assertNotNull(all);
        assertEquals(all.size(), 4);
    }

}

