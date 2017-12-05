package com.javapointers.controllers.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
//@Scope("prototype")
public class BeanXY {
    public BeanX beanX;
    public BeanY beanY;

    @Autowired
    public BeanXY(BeanX beanX, BeanY beanY){
        this.beanX = beanX;
        this.beanY = beanY;
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("postConstruct BeanXY");
    }
}
