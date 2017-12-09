package com.javapointers.controllers;

import com.javapointers.controllers.beans.SimpleBean3;
import com.javapointers.controllers.beans.iBean;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @Autowired
    private SimpleBean3 simpleBean3;

    @Autowired
    private Set<iBean> beanSet;

    @Autowired
    @Resource(name="beanX")
    private iBean beanX;

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String viewHome(){
        return "home";
    }

    private Date testDate = new Date();

    @RequestMapping("/greeting")
    public String greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name,
            Model model) {

        LOGGER.info("printHello started.");

        //logs debug message
        if(LOGGER.isDebugEnabled()){
            LOGGER.debug("Inside:  printHello");
        }

        Environment env = this.ctx.getEnvironment();
        model.addAttribute("env", env.toString());
        model.addAttribute("printDependencies", this.simpleBean3.printDependencies());

        // resource
        String title = "not found";
//        org.springframework.core.io.Resource template = this.ctx.getResource("https://mail.ru");
//
//        try {
//            title = new BufferedReader(new InputStreamReader(template.getInputStream()))
//                    .lines()
//                    .filter(e -> e.matches(".*<title>.+</title>.*"))
//                    .map(e -> e.replaceAll(".+<title>|</title>.+", ""))
//                    .collect(Collectors.joining("<br>"));
//        }
//        catch(IOException e) {
//            System.out.println(e.getMessage());
//        }

        model.addAttribute("title", title + " русский");
        model.addAttribute("testDate" , this.testDate);

        return "greeting";
    }

    @RequestMapping("/exception")
    public String exception(){

        throw new RuntimeException("Test exception from HomeController.exception()");

    }

//    @ExceptionHandler(Exception.class)
//    public ModelAndView handleIOException(Exception ex) {
//
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", ex);
//        mav.setViewName("error");
//
//        return mav;
//    }

}