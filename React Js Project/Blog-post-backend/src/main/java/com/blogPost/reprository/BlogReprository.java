package com.blogPost.reprository;
/**
 * Repository for blog to save blog details into database 
 */

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogPost.entities.Blog;

public interface BlogReprository extends JpaRepository<Blog, Integer>{
	

}
