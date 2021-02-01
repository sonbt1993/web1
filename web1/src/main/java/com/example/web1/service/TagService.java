package com.example.web1.service;

import com.example.web1.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagService implements ITagService{
    @Autowired
    private TagRepository tagRepository;
}
