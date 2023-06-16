package com.LibrarianApplication.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model class of Book to store the details of an Book
 * @author premgupta
 *
 */
@Entity
public class Book {
	
	@Id
	private int id;  // represents the id of book
	private String bookName;  // represents the name of book
	private String authorName;  // represents the Author of book
	private String bookDate;   // represents the book added date.
	public Book() {
		super();
	}
	public Book(final int id,final String bookName,final String authorName,final String bookDate) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.bookDate = bookDate;
	}
	public int getId() {
		return id;
	}
	public String getBookName() {
		return bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public String getBookDate() {
		return bookDate;
	}
	public void setBookName(final String bookName) {
		this.bookName = bookName;
	}
	public void setAuthorName(final String authorName) {
		this.authorName = authorName;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", authorName=" + authorName + ", bookDate=" + bookDate
				+ "]";
	}
	
	

}
