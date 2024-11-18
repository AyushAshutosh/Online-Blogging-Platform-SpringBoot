package com.codeElevate.blogServer.service;

import com.codeElevate.blogServer.entity.Post;
import com.codeElevate.blogServer.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;


    public Post savePost(Post post) {
        post.setLikeCount(0);
        post.setViewCount(0);
        post.setDate(new Date());

        return postRepository.save(post);
    }

    public List<Post> findAllPosts() {
        return List.of();
    }

    @Override
    public List<Post> getAllPosts() {
        return  postRepository.findAll();
    };

    public Post getPostById(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()) {
            Post post = optionalPost.get();
            post.setViewCount(post.getViewCount() + 1);
            return postRepository.save(post);
        } else {
            throw new EntityNotFoundException("Post Not Found");
        }
    }

    public void likePost(Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if(optionalPost.isPresent()) {
            Post post = optionalPost.get();

            post.setLikeCount(post.getLikeCount() + 1);
            postRepository.save(post);
        } else {
            throw new EntityNotFoundException("Post Not Found With Id:" + postId);
        }
    }

    public List<Post> searchByName(String name) {
        return postRepository.findAllByNameContaining(name);
    }
}