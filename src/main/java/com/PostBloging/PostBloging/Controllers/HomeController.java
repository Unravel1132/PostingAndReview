package com.PostBloging.PostBloging.Controllers;

import com.PostBloging.PostBloging.Entity.Post;
import com.PostBloging.PostBloging.Entity.Review;
import com.PostBloging.PostBloging.Service.PostService;
import com.PostBloging.PostBloging.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PostService postService;

    @Autowired
    ReviewService reviewService;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
