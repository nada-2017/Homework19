package com.example.homework19.Service;

import com.example.homework19.ApiException.ApiException;
import com.example.homework19.Model.Blog;
import com.example.homework19.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;

    public List<Blog> getBlogs(){
        return blogRepository.findAll();
    }

    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }

    public void updateBlog(Integer id, Blog blog){
        Blog b = blogRepository.getBlogById(id);
        if (b == null)
            throw new ApiException("Not found");
        b.setTitle(blog.getTitle());
        b.setBody(blog.getBody());
        b.setCategory(blog.getCategory());
        b.setIsPublished(blog.getIsPublished());
        blogRepository.save(b);
    }

    public void deleteBlog(Integer id){
        Blog b = blogRepository.getBlogById(id);
        if (b == null)
            throw new ApiException("Not found");
        blogRepository.delete(b);
    }

    public Blog getBlogById(Integer id){
        Blog b = blogRepository.getBlogById(id);
        if (b == null)
            throw new ApiException("Not found");
        return b;
    }

    public Blog getBlogByTitle(String title){
        Blog b = blogRepository.getBlogByTitle(title);
        if (b == null)
            throw new ApiException("Not found");
        return b;
    }

    public List<Blog> getBlogsByCategory(String category){
        List<Blog> blogs = blogRepository.getBlogsByCategory(category);
        if (blogs.size() == 0)
            throw new ApiException("Not found");
        return blogs;
    }

    public void published(){
        List<Blog> blogs = blogRepository.findAll();
        for (Blog b:blogs) {
            b.setIsPublished(true);
            blogRepository.save(b);
        }

    }
}
