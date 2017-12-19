package learnspring.myblog.controllers;

import learnspring.myblog.dao.UserDAO;
import learnspring.myblog.dbitems.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    UserDAO userDAO;

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

    @RequestMapping("/dao")
    public String dao(Model model){
        List<User> all = userDAO.getAll(0, Integer.MAX_VALUE);
        StringBuilder out = new StringBuilder();
        all.stream().forEach(u -> out.append(u.toString() + "<br>" ));

        model.addAttribute("users", out.toString() );

        return "dao";
    }


}