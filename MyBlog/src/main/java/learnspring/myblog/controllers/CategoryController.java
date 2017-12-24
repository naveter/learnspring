package learnspring.myblog.controllers;

import learnspring.myblog.dao.CategoryDAO;
import learnspring.myblog.dbitems.Category;
import learnspring.myblog.dbitems.Post;
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
public class CategoryController extends AbstractController {

    private static final Logger LOGGER = Logger.getLogger(CategoryController.class);

    @GetMapping("/category/{category_id}")
    public String category(
            @PathVariable int category_id,
            @RequestParam(value="p", required=false, defaultValue="0") int p,
            Model model) {

        List<Post> posts = postDAO.findByCategoryId(category_id, p, Glob.postPerPage);
        Category category = categoryDAO.findById(category_id);

        model.addAttribute("p", p );
        model.addAttribute("content", "category" );
        model.addAttribute("posts", posts );
        model.addAttribute("category", category );

        return "main";
    }



}
