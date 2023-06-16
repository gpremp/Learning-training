package com.LibrarianApplication.daoservices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LibrarianApplication.entities.Book;
import com.LibrarianApplication.reprository.BookReprository;

/**
 * Service class of Data Access for Book to add, read, update and delete Book data from database
 * @author premgupta
 *
 */
@Component
public class BookServices {

	@Autowired
	private BookReprository bookReprository;
	
	/**
	 * Method to save new book into the database
	 * @param book represents the object of book
	 */
	public void saveBook(final Book book) {
		this.bookReprository.save(book);
	}
	
	/**
	 * Method to get list of all books
	 * @return return list of all books
	 */
	public List<Book> getAllBooks(){
		return (List<Book>) this.bookReprository.findAll();
	}
	
	/**
	 * Method to get details of a book by its id
	 * @param id represents the id of a book
	 * @return return the object of a book
	 */
	public Book getBook(final int id){
		Book book=null;
		final Optional<Book> bookCheck = this.bookReprository.findById(id);
		if(bookCheck.isPresent()) {
			book=bookCheck.get();
		}
		return book;
	}
	
	/**
	 * Method to delete a book from the database
	 * @param id represents the id of the book
	 */
	public void deleteBook(int id) {
		this.bookReprository.deleteById(id);
	}
}
