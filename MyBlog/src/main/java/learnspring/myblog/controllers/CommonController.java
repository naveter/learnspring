package learnspring.myblog.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(PostController.class);

    @RequestMapping("/login")
    public String login(Model model) {
        model.addAttribute("content", "login");
        return "main";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("content", "login");
        return "main";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("content", "admin");
        return "main";
    }


    @RequestMapping("/exception")
    public String exception(){

        throw new RuntimeException("Test exception from HomeController.exception()");

    }


}
