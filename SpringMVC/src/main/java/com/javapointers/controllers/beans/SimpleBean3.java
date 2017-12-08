package com.javapointers.controllers.beans;

import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class SimpleBean3 {

    @NonNull
    public SimpleBean1 simpleBean1;

    @NonNull
    public SimpleBean2 simpleBean2;

    @Nullable
    public String jdbcUrl;

    public SimpleBean3(SimpleBean1 simpleBean1){
        this.simpleBean1 = simpleBean1;
    }

    public void setSimpleBean2(SimpleBean2 simpleBean2){
        this.simpleBean2 = simpleBean2;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String printDependencies(){
        return "simpleBean1: " + this.simpleBean1.getName() + "<br>" +
                "simpleBean2: " + this.simpleBean2.getName() + "<br>" +
                "jdbc.url: " + this.jdbcUrl;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct SimpleBean3");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("preDestroy SimpleBean3");
    }

    public void init(){
        System.out.println("init SimpleBean3");
    }


}
