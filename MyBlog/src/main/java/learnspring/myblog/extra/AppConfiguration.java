package learnspring.myblog.extra;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@ImportResource("WEB-INF/dispatcher-servlet.xml")
@PropertySource("prop/app.properties")
@EnableTransactionManagement
public class AppConfiguration  {

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    @Autowired
    private SessionFactory sessionFactory;

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