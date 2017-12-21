package learnspring.myblog;

import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dbitems.Category;
import learnspring.myblog.dbitems.Post;
import learnspring.myblog.dbitems.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class PostDAOTest extends DBAbstract {

    @Autowired
    private PostDAO postDAO;

    private String postTable = "public.post";

    @Test
    public void saveTest(){
        Post p = new Post();
        p.setUser_id(1L);
        p.setCategory_id(1L);
        p.setTitle("Test title");
        p.setBody("Test body");
        p.setCreated(new Date());

        int cntOld = countRowsInTable(this.postTable);
        this.postDAO.save(p);
        int cntNew = countRowsInTable(this.postTable);

        assertEquals("After save post", cntOld + 1, cntNew);
    }

    @Test
    public void findByIdTest(){
        Post u = postDAO.findById(2);

        assertNotNull(u);
        assertEquals("Майк Тайсон", u.getTitle());
    }

    @Test
    public void getAllTest(){
        List<Post> all = postDAO.getAll(0, Integer.MAX_VALUE);

        assertNotNull(all);
        assertEquals(all.size(), 3);
    }

    @Test
    public void findByUserIdTest(){
        List<Post> all = postDAO.findByUserId(1,0, Integer.MAX_VALUE);

        assertNotNull(all);
        assertEquals(all.size(), 2);
    }

    @Test
    public void findByCategoryIdTest(){
        List<Post> all = postDAO.findByCategoryId(2,0, Integer.MAX_VALUE);

        assertNotNull(all);
        assertEquals(all.size(), 2);
    }

    @Test
    public void one2oneFieldsInitTest(){
        Post p = postDAO.findById(2);
        User u = p.getUser();
        Category c = p.getCategory();

        assertEquals(u.getFirstname(), "Karl");
        assertEquals(c.getName(), "Sport");
    }

}

