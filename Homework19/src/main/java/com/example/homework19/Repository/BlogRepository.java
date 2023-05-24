package com.example.homework19.Repository;

import com.example.homework19.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {


    @Query("select b from Blog b where b.id = ?1")
    Blog getBlogById(Integer id);
    @Query("select b from Blog b where b.title = ?1")
    Blog getBlogByTitle(String title);

    @Query("select b from Blog b where b.category = ?1")
    List<Blog> getBlogsByCategory(String category);



}
