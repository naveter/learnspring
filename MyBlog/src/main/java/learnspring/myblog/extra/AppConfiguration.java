package learnspring.myblog.extra;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ITemplateResolver;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashSet;
import java.util.Set;

@Configuration
@ImportResource("classpath:dispatcher-servlet.xml")
@PropertySource("classpath:app.properties")
@EnableTransactionManagement
//@EnableWebSecurity
public class AppConfiguration extends WebMvcConfigurerAdapter implements ApplicationContextAware  {

    private static final String UTF8 = "UTF-8";

    private ApplicationContext applicationContext;

    @Autowired
    private SessionFactory sessionFactory;

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        final PlatformTransactionManager transactionManager = new JpaTransactionManager();
        return transactionManager;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public EntityManager getEntityManager(EntityManagerFactory emf) {
        return emf.createEntityManager();
    }

    @Bean
    public ViewResolver viewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setTemplateEngine(templateEngine());
        resolver.setCharacterEncoding(UTF8);
        resolver.setOrder(2);
//        resolver.setViewNames(new String[] {"*.html", "*.xhtml"});
        return resolver;
    }

    private TemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());

        Set<IDialect> dialects = new HashSet<>();
        SpringSecurityDialect ssd = new SpringSecurityDialect();
        dialects.add(ssd);
        engine.setAdditionalDialects(dialects);

        return engine;
    }

    private ITemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setApplicationContext(applicationContext);
        resolver.setPrefix("/WEB-INF/templates/");
        resolver.setTemplateMode(TemplateMode.HTML);
        resolver.setSuffix(".html");
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("locale", "locale/messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }

    @Override
    public void addFormatters(final FormatterRegistry registry) {
        super.addFormatters(registry);
        registry.addFormatter(dateFormatter());
    }

    @Bean
    public DateFormatter dateFormatter() {
        return new DateFormatter();
    }














//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/public-resources/")
//                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
//    }

}




//    @Bean("dataSource")
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(this.driverClassName);
//        dataSource.setUrl(this.url);
//        dataSource.setUsername(this.username);
//        dataSource.setPassword(this.password);
//
////        this.dataSource = dataSource;
//
//        return dataSource;
//    }
//
//    @Bean("javaEM")
//    @Qualifier("javaEM")
//    public LocalSessionFactoryBean entityManagerFactory(DataSource dataSource) {
//        LocalSessionFactoryBean em = new LocalSessionFactoryBean();
//        em.setDataSource(dataSource);
//        em.setPackagesToScan(new String[] { "learnspring.myblog.dbitems" });
//
////        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
////        em.setJpaVendorAdapter(vendorAdapter);
//        em.setHibernateProperties(additionalProperties());
//
//        return em;
//    }
//
//    Properties additionalProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
//        properties.setProperty("hibernate.show_sql", "false");
//        return properties;
//    }