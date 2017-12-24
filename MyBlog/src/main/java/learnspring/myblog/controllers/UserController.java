package learnspring.myblog.controllers;

import learnspring.myblog.dao.UserDAO;
import learnspring.myblog.dbitems.Post;
import learnspring.myblog.dbitems.User;
import learnspring.myblog.extra.Glob;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class);

    @Autowired
    UserDAO userDAO;

    @GetMapping("/user/{user_id}")
    public String userAll(
            @PathVariable int user_id,
            @RequestParam(value="p", required=false, defaultValue="0") int p,
            Model model) {

        List<Post> posts = postDAO.findByUserId(user_id, p, Glob.postPerPage);
        User user = userDAO.findById(user_id);

        model.addAttribute("content", "user");
        model.addAttribute("user", user );
        model.addAttribute("posts", posts );
        model.addAttribute("p", p );

        return "main";
    }

}
