package com.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.exception.ResourceNotFoundException;
import com.model.BlogEntity;
import com.repository.BlogRepository;

@Service
@Validated
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Override
    public BlogEntity createBlog(BlogEntity blogEntity) {
        return blogRepository.save(blogEntity);
    }

    @Override
    public BlogEntity getBlogById(Long id) {
        BlogEntity blog = blogRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        return new BlogEntity(blog.getId(), blog.getTitle(), blog.getContent());
    }

    @Override
    public BlogEntity updateBlog(BlogEntity blogEntity) {
        BlogEntity blog = blogRepository.findById(blogEntity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        
        blog.setTitle(blogEntity.getTitle());
        blog.setContent(blogEntity.getContent());
        BlogEntity updatedBlog = blogRepository.save(blog);
        return new BlogEntity(updatedBlog.getId(), updatedBlog.getTitle(), updatedBlog.getContent());
    }

    @Override
    public Boolean deleteBlog(Long id) {
    	try {
    		BlogEntity blog = blogRepository.findById(id)
    				.orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
    		
    		blogRepository.delete(blog);
    		return true;
    	}catch(Exception e) {
    		return false;
    				
    	}
        
    }

    @Override
    public List<BlogEntity> findAll() {
        return blogRepository.findAll().stream()
                .map(blog -> new BlogEntity(blog.getId(), blog.getTitle(), blog.getContent()))
                .collect(Collectors.toList());
        
    }
}