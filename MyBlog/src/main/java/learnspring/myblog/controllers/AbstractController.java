package learnspring.myblog.controllers;

import learnspring.myblog.dao.CategoryDAO;
import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dbitems.Category;
import learnspring.myblog.dbitems.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

public class AbstractController {

    @Autowired
    private ApplicationContext ac;

    @Autowired
    PostDAO postDAO;

    @Autowired
    CategoryDAO categoryDAO;

    @ModelAttribute("sidebarPosts")
    public List<Post> sidebarPosts() {
        List<Post> posts = postDAO.getAll(0, 10);

        return posts;
    }

    @ModelAttribute("sidebarCategories")
    public List<Category> sidebarCategories() {
        List<Category> category = categoryDAO.getAll(0, 10);

        return category;
    }

}
