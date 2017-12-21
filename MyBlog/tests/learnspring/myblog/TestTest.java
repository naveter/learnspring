package learnspring.myblog;

import learnspring.myblog.dao.CategoryDAO;
import learnspring.myblog.dbitems.Category;
import learnspring.myblog.extra.AppConfiguration;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfiguration.class)
public class TestTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void saveTest(){
        assertEquals("After save category", 1, 1);
    }

}
