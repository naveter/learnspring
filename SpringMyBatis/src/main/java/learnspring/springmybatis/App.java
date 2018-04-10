package learnspring.springmybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;

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
            User blog = session.selectOne("learnspring.springmybatis.BlogMapper.selectBlog", 1);
            System.out.println(blog.getFirstname() + blog.getLastname());

        } finally {
            session.close();
        }


    }
}
