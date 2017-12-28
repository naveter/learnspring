package learnspring.myblog.controllers;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class CommonController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(CommonController.class);

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
        throw new RuntimeException("Test exception from CommonController.exception()");
    }

    @RequestMapping("/error403")
    public String error403(){
        throw new RuntimeException("Access denied");
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String exception(final Throwable throwable, final Model model) {

        LOGGER.error("Exception during execution of SpringSecurity application", throwable);

        String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("content", "error");

        return "main";
    }


}
