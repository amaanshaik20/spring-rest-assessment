package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.BlogEntity;
import com.service.BlogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/blogs")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping
    public ResponseEntity<BlogEntity> createBlog(@Valid @RequestBody BlogEntity blogEntity) {
        return ResponseEntity.ok(blogService.createBlog(blogEntity));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BlogEntity> getBlogById(@PathVariable Long id) {
        return ResponseEntity.ok(blogService.getBlogById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BlogEntity> updateBlog(@PathVariable Long id, @Valid @RequestBody BlogEntity blogEntity) {
        return ResponseEntity.ok(blogService.updateBlog(blogEntity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return ResponseEntity.ok("Blog deleted successfully");
    }
    @GetMapping("/all")
    public ResponseEntity<List<BlogEntity>> getAllBlogs() {
        return ResponseEntity.ok(blogService.findAll());
    }
}