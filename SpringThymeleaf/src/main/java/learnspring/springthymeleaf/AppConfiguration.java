package learnspring.springthymeleaf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ImportResource("/WEB-INF/dispatcher-servlet.xml")
//@WebAppConfiguration
public class AppConfiguration {



















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