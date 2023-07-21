package com.blogPost.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blogPost.doaservices.BlogServices;
import com.blogPost.entities.Blog;

/**
 * controller to manage HTTP request related to blog 
 * @author premgupta
 *
 */
@RestController
@CrossOrigin("*")
public class BlogController {

	@Autowired
	private BlogServices blogServices;
	
	@PostMapping("/blog")
	public Blog saveBlog(@RequestBody final Blog blog) {
		return this.blogServices.saveBlog(blog);
	}
	
	@PutMapping("/blog")
	public Blog UpdateBlog(@RequestBody final Blog blog) {
		return this.blogServices.saveBlog(blog);
	}
	
	/**
	 * Get HTTP request to get the blog details by its ID 
	 * @param id Represents the id of blog 
	 * @return returns turns the object of blog 
	 */
	@GetMapping("/blog/{id}")
	public Blog getBlog(@PathVariable("id")final int id) {
		return this.blogServices.getBlog(id);
	}
	
	/**
	 * Get HTTP request to get the list of blog
	 * @param requestHTTP servlet request 
	 * @return returns the list of blog
	 */
	@GetMapping("/blogs")
	public List<Blog> getBlogs(HttpServletRequest request){	
		List<Blog> blogs = this.blogServices.getBlogs();
		System.out.println(blogs);
		return blogs;
		
	}
	/**
	 * Delete HTTP request to delete a blog by id
	 * @param id Represents the id of blog
	 */
	@DeleteMapping("/blog/{id}")
	public void deleteBlog(@PathVariable("id")final int id) {
		 this.blogServices.deleteBlog(id);
	}
}
