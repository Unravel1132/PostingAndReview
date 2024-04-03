package com.PostBloging.PostBloging.Repository;

import com.PostBloging.PostBloging.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
