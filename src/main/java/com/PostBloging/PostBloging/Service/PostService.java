package com.PostBloging.PostBloging.Service;


import com.PostBloging.PostBloging.Entity.Post;
import com.PostBloging.PostBloging.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository postRepository;

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        try {
            return postRepository.findById(id)
                    .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Post savePost(Post post) {
        return postRepository.save(post);
    }


    public void deletePostById(Long id) {
        postRepository.deleteById(id);
    }
}