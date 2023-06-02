package com.blogPost.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**Class to create blog object to save blog details 
 * 
 * @author premgupta
 *
 */
@Entity
@Table(name = "blogData")
public class Blog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String title;
	private String category;
	private String content;
	private int blogLike;
	public Blog() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Blog(String title, String category, String content, int blogLike) {
		super();
		this.title = title;
		this.category = category;
		this.content = content;
		this.blogLike = blogLike;
	}
	
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getBlogLike() {
		return blogLike;
	}
	public void setBlogLike(int blogLike) {
		this.blogLike = blogLike;
	}
	@Override
	public String toString() {
		return "Blog [id=" + id + ", title=" + title + ", category=" + category + ", content=" + content + ", blogLike="
				+ blogLike + "]";
	}
	
}
