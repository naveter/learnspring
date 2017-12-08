package learnspring.springcmd;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.postgresql.Driver;

import javax.sql.DataSource;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
@PropertySource("classpath:learnspring/springcmd/app.properties")
@ImportResource("classpath:learnspring/springcmd/config.xml")
public class Application {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

//    @Bean
//    DataSource getConnection() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(this.driverClassName);
//        dataSource.setUrl(this.url);
//        dataSource.setUsername(this.username);
//        dataSource.setPassword(this.password);
//        return dataSource;
//    }

    @Bean
    public AppAspect doAppAspect(){
        return new AppAspect();
    }

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class);
        printer.printMessage();

        TestDatabase testDateBase = context.getBean(TestDatabase.class);
        testDateBase.printAllUsers();
        testDateBase.printUser(1);


    }
}
