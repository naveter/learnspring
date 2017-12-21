package learnspring.myblog.dao;

import learnspring.myblog.dbitems.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UserDAOTest extends DBAbstract {

    @Autowired
    private UserDAO userDAO;

    private String userTable = "public.user";

    @Test
    public void saveTest(){
        User u = new User();
        u.setFirstname("Terry");
        u.setLastname("Gabba");
        u.setCreated(new Date());
        u.setLogin("terry");
        u.setPassword("123456");
        u.setLastlogin(new Date());

        int cntOld = countRowsInTable(this.userTable);
        this.userDAO.save(u);

        int cntNew = countRowsInTable(this.userTable);
        assertEquals("After save user", cntOld + 1, cntNew);
    }

    @Test
    public void findByIdTest(){
        User u = userDAO.findById(1);

        assertNotNull(u);
        assertEquals("Ivan", u.getFirstname());
    }

    @Test
    public void getAllTest(){
        List<User> all = userDAO.getAll(0, Integer.MAX_VALUE);

        assertNotNull(all);
        assertEquals(all.size(), 2);
    }

}

