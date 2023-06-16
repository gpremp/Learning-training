package com.LibrarianApplication.servlet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LibrarianApplication.daoservices.AuthorServices;
import com.LibrarianApplication.daoservices.BookServices;
import com.LibrarianApplication.entities.Author;
import com.LibrarianApplication.entities.Book;


/**
 * Servlet controller of add Book and Add new Book jsp page
 * @author premgupta
 *
 */
@Controller
public class AddBook {

	@Autowired
	private AuthorServices authorServices;
	
	@Autowired
	private BookServices bookServices;

	/**
	 * method to map with addbook.jsp page
	 * @param model represents a model to store data to access on jsp page
	 * @param session represents the current session of application
	 * @return return addbook.jsp page
	 */
	@RequestMapping("/addbook")
	public String addBookPage(final Model model,HttpSession session) {
		List<Author> authors = this.authorServices.getAllAuthors();
		model.addAttribute("authors", authors);
		return "addbook";
	}
	
	/**
	 * method to map with add new book form.
	 * @param bookCode represents book code of book
	 * @param bookName represents book name of book
	 * @param author  represents author of book
	 * @param model represents a model to store data to access on jsp page
	 * @return  return addbook.jsp page
	 */
	@PostMapping("/addNewBook")
	public String addBook(@RequestParam("bookCode")final int bookCode,
			@RequestParam("bookName")final String bookName,
			@RequestParam("getAuthor")final String author,
			final Model model) {
		final List<Author> authors = this.authorServices.getAllAuthors();
		model.addAttribute("authors", authors);
		Date date = new Date();
		final String currentDate= new SimpleDateFormat("dd MMM yyyy").format(date);
		final Book newBook = new Book(bookCode,bookName,author,currentDate);
		final Book book = this.bookServices.getBook(bookCode);
        if(null == book) {
        	this.bookServices.saveBook(newBook);
        	model.addAttribute("bookStatus", "success");
        	return "addbook";
        }else {
        	model.addAttribute("bookStatus", "failed");
        	return "addbook";
		}
        
	}
}
