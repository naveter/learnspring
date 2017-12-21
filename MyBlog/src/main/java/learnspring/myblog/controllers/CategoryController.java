package learnspring.myblog.controllers;

import learnspring.myblog.dao.CategoryDAO;
import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dbitems.Post;
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
public class CategoryController {
    private static final Logger LOGGER = Logger.getLogger(PostController.class);

    @Autowired
    private ApplicationContext ctx;

    @Autowired
    CategoryDAO categoryDAO;

    @Autowired
    PostDAO postDAO;

    @GetMapping("/category/{category_id}")
    public String category(
            @PathVariable int category_id,
            @RequestParam(value="p", required=false, defaultValue="0") int p,
            Model model) {

        List<Post> posts = postDAO.findByCategoryId(category_id, p, Glob.postPerPage);

        StringBuilder out = new StringBuilder();
        posts.stream().forEach(u -> out.append(u.toString() + "<br>" ));

        model.addAttribute("p", p );
        model.addAttribute("postsToString", out.toString() );
        model.addAttribute("posts", posts );
        model.addAttribute("category_id", category_id );

        return "category";
    }



}
