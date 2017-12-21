package learnspring.myblog.controllers;

import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dao.UserDAO;
import learnspring.myblog.dbitems.Post;
import learnspring.myblog.extra.Glob;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class PostController {

    private static final Logger LOGGER = Logger.getLogger(PostController.class);

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    PostDAO postDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public String index(@RequestParam(value="p", required=false, defaultValue="0") int p,
                        Model model){

        List<Post> posts = postDAO.getAll(p, Glob.postPerPage);

        StringBuilder out = new StringBuilder();
        posts.stream().forEach(u -> out.append(u.toString() + "<br>" ));

        model.addAttribute("p", p );
        model.addAttribute("posts", posts );
        model.addAttribute("postsToString", out.toString() );

        return "index";
    }

    @GetMapping("/post/{post_id}")
    public String post(
            @PathVariable int post_id,
            Model model) {

        Post post = postDAO.findById(post_id);

        model.addAttribute("post_id", post_id );
        model.addAttribute("post", post );
        model.addAttribute("postToString", post.toString() );

        return "post";
    }

    @RequestMapping("/exception")
    public String exception(){

        throw new RuntimeException("Test exception from HomeController.exception()");

    }

    @GetMapping("/post/add/form")
    public String postAddForm(Model model){

        return "postAddForm";
    }

    @PostMapping("/post/add")
    public String postAdd(Model model){

        return "post";
    }


}