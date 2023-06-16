package com.LibrarianApplication.servlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.LibrarianApplication.daoservices.LibrarianServices;
import com.LibrarianApplication.entities.Librarian;


/**
 * controller servlet for signUp page
 * @author premgupta
 *
 */
@Controller
public class SignUp {
	
	@Autowired
	LibrarianServices librarianServices;
	
	@RequestMapping({"/","/signup"})
	public String defaultPage() {
		return "signup";
	}

	/**
	 * Method to get data from register form from signUp page
	 * @param firstName represents the first name of Librarian
	 * @param lastName  represents the last name of Librarian
	 * @param email   represents the email of Librarian
	 * @param password  represents the password of Librarian
	 * @param model  represents a model to store data to access on jsp page 
	 * @return return signup.jsp page
	 */
	@PostMapping("/register")
	public String signUp(@RequestParam("FirstName")final String firstName,
			@RequestParam("LastName")final String lastName,
			@RequestParam("email")final String email,
			@RequestParam("password")final String password,final Model model){
		final Librarian newLibrarian = new Librarian(firstName,lastName,email,password);
		final boolean userStatus = this.librarianServices.getLibrarian(email);
		if(userStatus) {
			this.librarianServices.saveLibrarian(newLibrarian);
			model.addAttribute("status", "success");
		
		}
		else {
			model.addAttribute("status", "failed");
		}
		
		return "signup";
	}
}
