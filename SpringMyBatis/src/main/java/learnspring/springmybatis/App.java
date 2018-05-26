package learnspring.springmybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.SQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.util.List;

import static org.apache.ibatis.jdbc.SelectBuilder.*;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                "spring-module.xml");

        HelloWorld obj = (HelloWorld) context.getBean("helloBean");
        obj.printHello();

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (inputStream == null) return;

        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();
        try {
//            User blog = session.selectOne("learnspring.springmybatis.BlogMapper.selectBlog", 1);
//            System.out.println(blog.getFirstname() + " " + blog.getLastname());

            List<Post> posts = session.selectList("learnspring.springmybatis.BlogMapper.selectPosts");
            for (Post p : posts) {
                System.out.println(p.getTitle() + " "
                        + p.getCategory().getName()
                        + " " + p.getUser().getLastname()
                        + " " + p.getCreated()
                        + " " + p.getUser().getCreated()
                );
            }

//            BlogMapperI mapper = session.getMapper(BlogMapperI.class);
//            User blog2 = mapper.selectBlog(2);
//            System.out.println(blog2.getFirstname() + " " + blog2.getLastname());
//
//            User blog3 = session.selectOne("learnspring.springmybatis.BlogMapper.getUser2", 3);
//            System.out.println(blog3.getFirstname() + " " + blog3.getLastname());

        } finally {
            session.close();
        }


    }

    private String selectPersonSql() {
        return new SQL() {{
            SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
            SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
            FROM("PERSON P");
            FROM("ACCOUNT A");
            INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
            INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
            WHERE("P.ID = A.ID");
            WHERE("P.FIRST_NAME like ?");
            OR();
            WHERE("P.LAST_NAME like ?");
            GROUP_BY("P.ID");
            HAVING("P.LAST_NAME like ?");
            OR();
            HAVING("P.FIRST_NAME like ?");
            ORDER_BY("P.ID");
            ORDER_BY("P.FULL_NAME");
        }}.toString();
    }
}
