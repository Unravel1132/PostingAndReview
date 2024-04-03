package com.PostBloging.PostBloging.Controllers;

import com.PostBloging.PostBloging.Entity.Review;
import com.PostBloging.PostBloging.Service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews() {
        List<Review> reviews = reviewService.getAllReviews();
        return ResponseEntity.ok(reviews);
    }

    @PostMapping
    public void addReviewToPost(@RequestParam Long postId, @RequestBody String text) {
        reviewService.addReviewToPost(postId, text);
    }

    @DeleteMapping("/{reviewId}")
    public void deleteReview(@PathVariable Long reviewId, @RequestParam Long postId) {
        reviewService.deleteReview(reviewId);
    }

}
