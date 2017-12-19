package learnspring.springdatajpa;

import learnspring.springdatajpa.dao.SourceDAO;
import learnspring.springdatajpa.dbitems.Category;
import learnspring.springdatajpa.dbitems.Post;
import learnspring.springdatajpa.dbitems.Source;
import learnspring.springdatajpa.dbitems.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class SourceDAOTest extends DBAbstract {

    @Autowired
    private SourceDAO sourceDAO;

    private String sourceTable = "public.source";

    @Test
    public void saveTest(){
        Source p = new Source();
        p.setUser_id(1L);
        p.setUrl("http://mail.ru");
        p.setLastupdate(new Date());
        p.setParser("MailParser");
        p.setCreated(new Date());

        int cntOld = countRowsInTable(this.sourceTable);
        this.sourceDAO.save(p);
        int cntNew = countRowsInTable(this.sourceTable);

        assertEquals("After save source", cntOld + 1, cntNew);
    }

    @Test
    public void findByIdTest(){
//        Post u = sourceDAO.findById(2);
//
//        assertNotNull(u);
//        assertEquals("Майк Тайсон", u.getTitle());
    }

    @Test
    public void getAllTest(){
//        List<Post> all = sourceDAO.getAll(0, Integer.MAX_VALUE);
//
//        assertNotNull(all);
//        assertEquals(all.size(), 3);
    }

    @Test
    public void findByUserIdTest(){
//        List<Post> all = sourceDAO.findByUserId(1,0, Integer.MAX_VALUE);
//
//        assertNotNull(all);
//        assertEquals(all.size(), 2);
    }

    @Test
    public void findByCategoryIdTest(){
//        List<Post> all = sourceDAO.findByCategoryId(2,0, Integer.MAX_VALUE);
//
//        assertNotNull(all);
//        assertEquals(all.size(), 2);
    }

    @Test
    public void one2oneFieldsInitTest(){
//        Post p = sourceDAO.findById(2);
//        User u = p.getUser();
//        Category c = p.getCategory();
//
//        assertEquals(u.getFirstname(), "Karl");
//        assertEquals(c.getName(), "Sport");
    }

}

