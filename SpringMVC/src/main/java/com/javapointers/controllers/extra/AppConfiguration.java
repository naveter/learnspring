package com.javapointers.controllers.extra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan
//@ComponentScan(basePackages = "com.javapointers.controllers")
@ImportResource("WEB-INF/dispatcher-servlet.xml")
@PropertySource("prop/app.properties")
public class AppConfiguration {

    @Value("${jdbc.url}")
    private String url;



}
