package learnspring.springcmd;

import learnspring.springcmd.dbitems.User;
import learnspring.springcmd.dbitems.UserDAO;
import learnspring.springcmd.dbitems.UserDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

@Component
public class TestDatabase {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private ApplicationContext ctx;

    @PersistenceUnit
    EntityManagerFactory emf;

    @Autowired
    EntityManager em;

    @Autowired
    UserDAOImpl userDAO;

    private List<User> getAllUsers(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        List<User> users = jdbcTemplate.query(
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

        return users;
    }

    public void printAllUsers(){
        List<User> users = this.getAllUsers();
        users.stream().forEach(u -> System.out.println(u.toString()));
    }

    public void printUser(int id){
        GetUser gu = new GetUser(this.dataSource);
        System.out.println((gu.findObject(id)).toString());

    }

    public class GetUser extends MappingSqlQuery<User> {

        public GetUser(DataSource ds) {
            super(ds, "select * from public.user where id = ?");
            super.declareParameter(new SqlParameter("id", Types.INTEGER));
            compile();
        }

        @Override
        protected User mapRow(ResultSet rs, int rowNumber) throws SQLException {
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

    }

//    @Transactional
    public void testHibernate(){
//        UserDAO personDAO = this.ctx.getBean(UserDAO.class);
        User user = userDAO.getById(1);

        System.out.println("Person is found: " + user.toString());

        User u = new User();
//        u.setId((long)3);
        u.setFirstname("Terry2");
        u.setLastname("Gabba2");
        u.setCreated(new Date());
        u.setLogin("terry2");
        u.setPassword("123456");
        u.setLastlogin(new Date());
        userDAO.save(u);
//        em.persist(u);


    }

    public void testEntityManager(){
        Query query = em.createQuery("from User");
        List<User> users = query.getResultList();
        users.stream().forEach(u -> System.out.println(u.toString()));

    }

}
