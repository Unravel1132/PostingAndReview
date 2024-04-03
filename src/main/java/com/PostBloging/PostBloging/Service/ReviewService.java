package com.PostBloging.PostBloging.Service;

import com.PostBloging.PostBloging.Entity.Post;
import com.PostBloging.PostBloging.Entity.Review;
import com.PostBloging.PostBloging.Repository.PostRepository;
import com.PostBloging.PostBloging.Repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private PostRepository postRepository;

    public List<Review> getAllReviews() {
        return reviewRepository.findAll();
    }

    public Review getReviewById(Long id) {
        try {
            return reviewRepository.findById(id)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }


    public void addReviewToPost(Long postId, String text) {
        // Получаем пост по его ID
        Post post = postRepository.findById(postId).orElseThrow(() -> new EntityNotFoundException("Post not found with id: " + postId));

        // Создаем новый отзыв
        Review review = new Review();
        review.setText(text);

        // Добавляем отзыв к посту
        post.getReviews().add(review);

        // Сохраняем обновленный пост
        postRepository.save(post);
    }

}
