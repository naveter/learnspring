package learnspring.myblog.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String viewHome(){
        return "home";
    }

    @RequestMapping("/greeting")
    public String greeting(
            @RequestParam(value="name", required=false, defaultValue="World") String name,
            Model model) {

        LOGGER.info("printHello started.");

        Environment env = this.ctx.getEnvironment();
        model.addAttribute("env", env.toString());

        return "greeting";
    }

    @RequestMapping("/exception")
    public String exception(){

        throw new RuntimeException("Test exception from HomeController.exception()");

    }


}