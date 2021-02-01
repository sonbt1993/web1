package com.example.web1.service;

import com.example.web1.model.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {
    List<Post> getAllPost();
    Post save(Post post);
    Post findById(long id);
    void delete(long id);
}
