package learnspring.myblog.controllers;

import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dao.UserDAO;
import learnspring.myblog.dbitems.Category;
import learnspring.myblog.dbitems.Post;
import learnspring.myblog.extra.Glob;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class PostController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(PostController.class);

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public String index(@RequestParam(value="p", required=false, defaultValue="0") int p,
                        Model model){

        List<Post> posts = postDAO.getAll(p, Glob.postPerPage);

        model.addAttribute("p", p );
        model.addAttribute("posts", posts );
        model.addAttribute("content", "index");

        return "main";
    }

    @GetMapping("/post/{post_id}")
    public String post(
            @PathVariable int post_id,
            Model model) {

        Post post = postDAO.findById(post_id);

        model.addAttribute("post", post );
        model.addAttribute("content", "post");

        return "main";
    }

    @RequestMapping("/exception")
    public String exception(){

        throw new RuntimeException("Test exception from HomeController.exception()");

    }

    @GetMapping("/post/add/form")
    public String postAddForm(Model model){
        List<Category> categories = categoryDAO.getAll(0, Integer.MAX_VALUE);

        model.addAttribute("categories", categories);
        model.addAttribute("content", "postAddForm");

        return "main";
    }

    @PostMapping("/post/add")
    public String postAdd(@ModelAttribute("Post") Post post,
                          BindingResult result, ModelMap model){
        if (result.hasErrors()) {
            List<Category> categories = categoryDAO.getAll(0, Integer.MAX_VALUE);
            model.addAttribute("categories", categories);
            model.addAttribute("content", "postAddForm");
            return "main";
        }

        System.out.println(post.toString());

        post.setUser_id(2L);
        post.setCreated(new Date());
        post = postDAO.save(post);

        return "redirect:/post/" + post.getId();
    }




}