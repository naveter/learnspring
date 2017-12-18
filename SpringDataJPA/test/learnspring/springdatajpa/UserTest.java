package learnspring.springdatajpa;

import learnspring.springdatajpa.dbitems.User;
import learnspring.springdatajpa.dbitems.UserDAOImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.assertEquals;


public class UserTest extends DBAbstract {

    @Autowired
    private UserDAOImpl userDAOImpl;

    private String userTable = "public.user";


    @Test
//    @Rollback(false)
    public void insertUserTest(){
        User u = new User();
        u.setFirstname("Terry");
        u.setLastname("Gabba");
        u.setCreated(new Date());
        u.setLogin("terry");
        u.setPassword("123456");
        u.setLastlogin(new Date());

        int cntOld = countRowsInTable(this.userTable);
        this.userDAOImpl.save(u);

        int cntNew = countRowsInTable(this.userTable);
        assertEquals("After save user", cntOld + 1, cntNew);
    }



}

