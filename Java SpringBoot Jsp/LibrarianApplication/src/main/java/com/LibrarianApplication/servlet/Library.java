package com.LibrarianApplication.servlet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LibrarianApplication.daoservices.BookServices;
import com.LibrarianApplication.entities.Book;


/**
 * Servlet controller of Library Book page to show the details of book
 * @author premgupta
 *
 */
@Controller
public class Library {
	
	@Autowired
	private BookServices bookServices;
	
	/**
	 * method to map with librarybooks.jsp page
	 * @param model represents a model to store data to access on jsp page 
	 * @param session represents the current session
	 * @return return the librarybooks.jsp page
	 */
	@RequestMapping("/librarybooks")
	public String defaultPage(final Model model,HttpSession session) {
		final String user = (String) session.getAttribute("user");
		if(null == user) {
			return "logout";
		}
		final List<Book> books = this.bookServices.getAllBooks();
		model.addAttribute("books", books);
		return "librarybooks";
	}
	
	/**
	 * method to map with delete button
	 * @param bookId represents the book code of book
	 * @param model model represents a model to store data to access on jsp page
	 * @return return the librarybooks.jsp page
	 */
	@RequestMapping("/deletebook")
	public String deleteBook(@RequestParam("bookId")final int bookId,Model model){
		this.bookServices.deleteBook(bookId);
		final List<Book> books = this.bookServices.getAllBooks();
		model.addAttribute("books", books);
		return "librarybooks";
	}

}
