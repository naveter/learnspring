package com.javapointers.controllers;

import com.javapointers.controllers.extra.AppConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static junit.framework.Assert.assertEquals;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=AppConfiguration.class)
//@WebAppConfiguration
public class SimpleTest {

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void saveTest(){
        assertEquals("After save category", 1, 1);
    }

}
