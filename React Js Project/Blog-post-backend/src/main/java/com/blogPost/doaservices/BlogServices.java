package com.blogPost.doaservices;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogPost.entities.Blog;
import com.blogPost.reprository.BlogReprository;

/**
 * Product service class to manage product database operation 
 * @author premgupta
 *
 */
@Service
public class BlogServices {
	
	@Autowired
	private BlogReprository blogReprository;
	
	/**
	 * Method to save new blog into the database 
	 * @param product Represents the object of blog 
	 * @return 
	 */
	public Blog saveBlog(final Blog blog) {
		return this.blogReprository.save(blog);
	}
	
	/**
	 * method to get the object of blog by its ID 
	 * @param id represents the id of blog 
	 * @return return the object of blog 
	 */
	public Blog getBlog(final int id) {
		final Optional<Blog> product= this.blogReprository.findById(id);
		if(product.isPresent()) {
			System.out.println("id");
			return product.get();
		}
		return null;
	}
	
	
	/**
	 * method to get the list of all blogs
	 * @return return the list of blog 
	 */
	public List<Blog> getBlogs(){
		return this.blogReprository.findAll();
	}
	/**
	 * Method to delete the data of a blog
	 */
	@Transactional
	public void deleteBlog(final int id) {
		this.blogReprository.deleteById(id);
	}
}
