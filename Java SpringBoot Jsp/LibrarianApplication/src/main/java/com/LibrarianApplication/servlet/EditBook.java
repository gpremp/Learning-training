package com.LibrarianApplication.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LibrarianApplication.daoservices.AuthorServices;
import com.LibrarianApplication.daoservices.BookServices;
import com.LibrarianApplication.entities.Author;
import com.LibrarianApplication.entities.Book;


/**
 * Servlet controller of edit Book page to edit the details of book
 * @author premgupta
 *
 */
@Controller
public class EditBook {

	@Autowired
	private BookServices bookServices;
	
	@Autowired
	private AuthorServices authorServices;
	
	/**
	 * method to map with editbook.jsp page
	 * @param bookId represents book code of book
	 * @param model represents a model to store data to access on jsp page 
	 * @return return editbook.jsp page
	 */
	@RequestMapping("/editbook")
	public String editBookPage(@RequestParam("bookId")final int bookId,final Model model) {
		final Book book = this.bookServices.getBook(bookId);
		final List<Author> authors = this.authorServices.getAllAuthors();
		model.addAttribute("authors", authors);
		model.addAttribute("book", book);
		return "editbook";
	}
	
	/**
	 * method to map with updatebook form to update the book details
	 * @param bookId  represents book code of book
	 * @param bookName represents book name of book
	 * @param author  represents author of book
	 * @param model  represents a model to store data to access on jsp page 
	 * @return return librarybooks.jsp page
	 */
	@GetMapping("/updateBook")
	public String updateBooksd(@RequestParam("bookId")final int bookId,
			@RequestParam("bookName")final String bookName,
			@RequestParam("getAuthor")final String author,
			final Model model) {
		final Book book = this.bookServices.getBook(bookId);
		book.setBookName(bookName);
		book.setAuthorName(author);
		this.bookServices.saveBook(book);
		final List<Book> books = this.bookServices.getAllBooks();
		model.addAttribute("books", books);	
		return "librarybooks";
	}
	
	
}
