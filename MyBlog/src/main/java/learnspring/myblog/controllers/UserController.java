package learnspring.myblog.controllers;

import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dao.UserDAO;
import learnspring.myblog.dbitems.Post;
import learnspring.myblog.dbitems.User;
import learnspring.myblog.extra.Glob;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {
    private static final Logger LOGGER = Logger.getLogger(PostController.class);

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    UserDAO userDAO;

    @Autowired
    PostDAO postDAO;

    @GetMapping("/user/{user_id}")
    public String user(
            @PathVariable int user_id,
            Model model) {

        User user = userDAO.findById(user_id);

        model.addAttribute("user_id", user_id );
        model.addAttribute("userToString", user.toString() );

        return "user";
    }

    @GetMapping("/user/{user_id}/all")
    public String userAll(
            @PathVariable int user_id,
            @RequestParam(value="p", required=false, defaultValue="0") int p,
            Model model) {

        List<Post> posts = postDAO.findByUserId(user_id, p, Glob.postPerPage);

        StringBuilder out = new StringBuilder();
        posts.stream().forEach(u -> out.append(u.toString() + "<br>" ));

        model.addAttribute("postsToString", out.toString() );
        model.addAttribute("user_id", user_id );
        model.addAttribute("posts", posts );
        model.addAttribute("p", p );

        return "userAll";
    }

}
