package com.example.homework19.Controller;

import com.example.homework19.Model.Blog;
import com.example.homework19.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
public class BlogController {

    private final BlogService blogService;

    @GetMapping("/get")
    public ResponseEntity getBlogs(){
        return ResponseEntity.status(200).body(blogService.getBlogs());
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid@RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Blog added");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable Integer id, @Valid@RequestBody Blog blog){
        blogService.updateBlog(id, blog);
        return ResponseEntity.status(200).body("Blog updated");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("Blog deleted");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        return ResponseEntity.status(200).body(blogService.getBlogById(id));
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getBlogByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(title));
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getBlogByCategory(@PathVariable String category){
        return ResponseEntity.status(200).body(blogService.getBlogsByCategory(category));
    }

    @PutMapping("/published")
    public ResponseEntity published(){
        blogService.published();
        return ResponseEntity.status(200).body("All Blogs are published");
    }
}
