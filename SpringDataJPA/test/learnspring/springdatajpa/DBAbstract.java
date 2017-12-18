package learnspring.springdatajpa;

import org.hibernate.SessionFactory;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
@TestPropertySource("test.properties")
@Sql({"create.sql", "insert.sql"})
@Transactional
public abstract class DBAbstract {

    @Autowired
    private ApplicationContext applicationContext;

    @PersistenceContext
    private EntityManager em;

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    protected int countRowsInTable(String tablename) {
        BigInteger cnt = (BigInteger) em.createNativeQuery("select count(*) from " + tablename).getSingleResult();
        return cnt.intValue();
    }

}
