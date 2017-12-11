package learnspring.springcmd;

import learnspring.springcmd.dbitems.User;
import learnspring.springcmd.dbitems.UserDAOImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
@TestPropertySource("test.properties")
@Sql({"create.sql", "insert.sql"})
@Transactional
public class ApplicationTest {

    @Autowired
    private MessageService service;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TestDatabase testDatabase;

    @Autowired
    private EntityManager em;

    @Autowired
    private UserDAOImpl userDAOImpl;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private String userTable = "user";

    @Test
    public void contextLoads() {
        System.out.println(service.getMessage());
        assertEquals("Hello World!", service.getMessage());
    }

    @Test
    public void insertUserTest(){
//        User u = new User();
//        u.setId((long)3);
//        u.setFirstname("Terry");
//        u.setLastname("Gabba");
//        u.setCreated(new Date());
//        u.setLogin("terry");
//        u.setPassword("123456");
//        u.setLastlogin(new Date());
//
//        int cntOld = JdbcTestUtils.countRowsInTable(this.jdbcTemplate, this.userTable);
//        this.userDAOImpl.save(u);
//
//        Session session = this.sessionFactory.openSession();
////        Transaction tx = session.beginTransaction();
//        session.saveOrUpdate(u);
////        tx.commit();
////        session.close();
//
//
////        session.flush();
//        int cntNew = JdbcTestUtils.countRowsInTable(this.jdbcTemplate, this.userTable);
//
//        assertEquals("After save user", cntNew, cntOld + 1);
    }

}

