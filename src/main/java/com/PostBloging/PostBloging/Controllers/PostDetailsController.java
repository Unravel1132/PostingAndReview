package com.PostBloging.PostBloging.Controllers;


import com.PostBloging.PostBloging.Entity.Post;
import com.PostBloging.PostBloging.Service.PostService;
import com.PostBloging.PostBloging.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostDetailsController {

    private final PostService postService;
    private final ReviewService reviewService;

    @Autowired
    public PostDetailsController(PostService postService, ReviewService reviewService) {
        this.postService = postService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public String showPostDetails(@PathVariable Long id, Model model) {
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post-details";
    }

    @PostMapping("/{id}/reviews")
    public String addReviewToPost(@PathVariable Long id, @RequestParam String text, Model model) {
        reviewService.addReviewToPost(id, text);
        Post post = postService.getPostById(id);
        model.addAttribute("post", post);
        return "post-details";
    }

}
