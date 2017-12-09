package learnspring.springcmd;

import learnspring.springcmd.dbitrems.User;
import learnspring.springcmd.dbitrems.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.stereotype.Component;

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

    private List<User> getAllUsers(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
        List<User> users = jdbcTemplate.query(
                "select * from public.user",
                new RowMapper<User>() {
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getInt("id"));
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
            user.setId(rs.getInt("id"));
            user.setFirstname(rs.getString("firstname"));
            user.setLastname(rs.getString("lastname"));
            user.setCreated(rs.getDate("created"));
            user.setLogin(rs.getString("login"));
            user.setPassword(rs.getString("password"));
            user.setLastlogin(rs.getDate("lastlogin"));

            return user;
        }

    }

    public void testHibernate(){
        UserDAO personDAO = this.ctx.getBean(UserDAO.class);
        User user = personDAO.getById(1);

        System.out.println("Person is found: " + user.toString());
    }

}
