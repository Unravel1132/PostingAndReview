package com.PostBloging.PostBloging.Repository;

import com.PostBloging.PostBloging.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {


}
