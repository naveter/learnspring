package learnspring.springthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/")
public class CategoryController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("userJSP", new User());

        return "index.html";
    }

    @RequestMapping(value = "/next")
    public String checkUser(Model model) {
        model.addAttribute("userJSP", new User());

        return "common/next.html";
    }

}
