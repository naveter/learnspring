package learnspring.myblog.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import learnspring.myblog.dao.PostDAO;
import learnspring.myblog.dbitems.Category;
import learnspring.myblog.dbitems.Post;
import learnspring.myblog.extra.Glob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RestServiceController {

    @Autowired
    PostDAO postDAO;

    @GetMapping("/")
    public List<Post> index(@RequestParam(value="p", required=false, defaultValue="0") int p) {
        List<Post> posts = postDAO.getAll(p, Glob.postPerPage);
        return posts;
    }

    @GetMapping("/post")
    public Post post(@RequestParam(value="id", defaultValue="1") int post_id) {
        Post post = postDAO.findById(post_id);
        return post;
    }

    @GetMapping("/category")
    public List<Post> category(
            @RequestParam(value="id", defaultValue="1") int category_id,
            @RequestParam(value="p", required=false, defaultValue="0") int p) {
        List<Post> posts = postDAO.findByCategoryId(category_id, p, Glob.postPerPage);
        return posts;
    }

    @GetMapping("/user")
    public List<Post> user(
            @RequestParam(value="id", defaultValue="1") int user_id,
            @RequestParam(value="p", required=false, defaultValue="0") int p) {
        List<Post> posts = postDAO.findByUserId(user_id, p, Glob.postPerPage);
        return posts;
    }

}
