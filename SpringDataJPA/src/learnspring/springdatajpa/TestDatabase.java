package learnspring.springdatajpa;

import learnspring.springdatajpa.dbitems.User;
import learnspring.springdatajpa.dbitems.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

@Component
public class TestDatabase {

    @PersistenceUnit
    EntityManagerFactory emf;

    @Autowired
    EntityManager em;

    @Autowired
    UserDAOImpl userDAO;

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Transactional
    public void testHibernate(){
//        UserDAO personDAO = this.ctx.getBean(UserDAO.class);
//        User user = userDAO.getById(1);

        System.out.println("Person is found: ");

        User u = new User();
//        u.setId((long)7);
        u.setFirstname("Terry7");
        u.setLastname("Gabba7");
        u.setCreated(new Date());
        u.setLogin("terry7");
        u.setPassword("123456");
        u.setLastlogin(new Date());
        userDAO.save(u);


    }

    public void printAllUsers(){
        List<User> users = this.jdbcTemplate.query(
                "select * from public.user",
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getLong("id"));
                        user.setFirstname(rs.getString("firstname"));
                        user.setLastname(rs.getString("lastname"));
                        user.setCreated(rs.getDate("created"));
                        user.setLogin(rs.getString("login"));
                        user.setPassword(rs.getString("password"));
                        user.setLastlogin(rs.getDate("lastlogin"));

                        return user;
                    }
                });

        users.stream().forEach(u -> System.out.println(u.toString()));
    }


}
