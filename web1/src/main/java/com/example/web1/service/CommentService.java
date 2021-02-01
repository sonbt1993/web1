package com.example.web1.service;

import com.example.web1.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService implements ICommentService{
    @Autowired private CommentRepository commentRepository;
}
