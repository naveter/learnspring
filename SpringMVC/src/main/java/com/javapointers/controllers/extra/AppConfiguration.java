package com.javapointers.controllers.extra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@ComponentScan
//@ComponentScan(basePackages = "com.javapointers.controllers")
@ImportResource("WEB-INF/dispatcher-servlet.xml")
@PropertySource("prop/app.properties")
public class AppConfiguration {

    @Value("${jdbc.url}")
    private String url;



}
