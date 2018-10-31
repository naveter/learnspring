package hello;

import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.facebook.api.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HelloController {

    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    public HelloController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }

    @GetMapping
    public String helloFacebook(Model model) {
        if (connectionRepository.findPrimaryConnection(Facebook.class) == null) {
            return "redirect:/connect/facebook";
        }

//        User userProfile = facebook.userOperations().getUserProfile();
//        model.addAttribute("userProfile", userProfile);
//        PagedList<Post> userFeed = facebook.feedOperations().getFeed();
//        model.addAttribute("userFeed", userFeed);

        PagedList<FriendList> friendList = facebook.friendOperations().getFriendLists();
        model.addAttribute("friendList", friendList);

//        friendList.get(0).getName();

        return "hello";
    }

}
