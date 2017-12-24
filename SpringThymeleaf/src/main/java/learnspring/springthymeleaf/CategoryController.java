package learnspring.springthymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Controller
//@RequestMapping("/")
public class CategoryController {

    @Autowired
    ApplicationContext ac;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model) {
        model.addAttribute("content", "index");
        model.addAttribute("userJSP", new User());

        String name = ac.getMessage("customer.name",
                new Object[] { 28,"http://www.mkyong.com" }, new Locale("en_US"));
        System.out.println("Customer name (English) : " + name);

        name = ac.getMessage("customer.name",
                new Object[] { 28,"http://www.mkyong.com" }, new Locale("ru_RU"));
        System.out.println("Customer name (Russian) : " + name);

        return "main";
    }

    @ModelAttribute("sidebar")
    public List<String[]> sidebar() {
        List<String[]> list = new ArrayList<>();

        list.add( new String[]{"first", "First link"} );
        list.add( new String[]{"second", "Super article"} );
        list.add( new String[]{"third", "Incredible Halk"} );

        return list;
    }

}
