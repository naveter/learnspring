package learnspring.angularjs;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class HomeController {

    private static final Logger LOGGER = Logger.getLogger(HomeController.class);

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(value="/", method = RequestMethod.GET)
    public String index(@RequestParam(value="m", required=false, defaultValue="index") String m,
                        @RequestParam(value="c", required=false, defaultValue="index") String c,
                        Model model){

        model.addAttribute("m", m );
        model.addAttribute("c", c );





        return "index";
    }



}