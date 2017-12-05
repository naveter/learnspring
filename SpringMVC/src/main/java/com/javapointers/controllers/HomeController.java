package com.javapointers.controllers;

import com.javapointers.controllers.beans.SimpleBean3;
import com.javapointers.controllers.beans.iBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.Set;

@Controller
public class HomeController {

    private SimpleBean3 simpleBean3;
    private Set<iBean> beanSet;
    private iBean beanX;

    @Autowired
    @Resource(name="beanX")
    public void setBeanX(iBean beanX) {
        this.beanX = beanX;
    }

    @Autowired
    public void setBeanSet(Set<iBean> beanSet) {
        this.beanSet = beanSet;
    }

    @Autowired
    public void setSimpleBean3(SimpleBean3 simpleBean3){
        this.simpleBean3 = simpleBean3;
    }

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String viewHome(){
        return "home";
    }

    @RequestMapping("/greeting")
    public String greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name,
            Model model) {

        model.addAttribute("printDependencies", this.simpleBean3.printDependencies());
        return "greeting";
    }
}