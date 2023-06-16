package com.LibrarianApplication.servlet;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LibrarianApplication.daoservices.BookServices;
import com.LibrarianApplication.daoservices.LibrarianServices;
import com.LibrarianApplication.entities.Book;

/**
 * controller servlet for signIn page
 * @author premgupta
 *
 */
@Controller
public class SignIn {
	
	@Autowired
	LibrarianServices librarianServices;
	
	@Autowired
	private BookServices bookServices;

	/**
	 * method to map with signin.jsp page
	 * @return return the signin.jsp page
	 */
	@RequestMapping("/signin")
	public String signinPage() {
		return "signin";
	}
	
	/**
	 * method to get the data of librarySignIn form from signIn page
	 * @param email represent the email of Librarian
	 * @param password  represent the password of Librarian
	 * @param model  represents a model to store data to access on jsp page 
	 * @param session represents the current session
	 * @return return the librarybooks.jsp page if signIn successful else signin.jsp page
	 */
	@PostMapping("/libraraySignIn")
	public String signUp(@RequestParam("email")final String email,
			@RequestParam("password")final String password,
			final Model model,HttpSession session){
		String user = this.librarianServices.loginLibraian(email, password);
		if(null != user) {
			session.setAttribute("user", user);
			final List<Book> books = this.bookServices.getAllBooks();
			model.addAttribute("books", books);
			return "librarybooks";
		}
		else {
			model.addAttribute("status", "failed");
		}
		
		return "signin";
	}
}
