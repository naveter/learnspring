package com.javapointers.controllers.extra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan
//@ComponentScan(basePackages = "com.javapointers.controllers")
@ImportResource("classpath:dispatcher-servlet.xml")
@PropertySource("classpath:app.properties")
public class AppConfiguration  {

    @Value("${jdbc.url}")
    private String url;

//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("/public-resources/")
//                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
//    }

}
