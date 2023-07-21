package com.blogPost.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogPost.doaservices.UserService;
import com.blogPost.entities.User;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public String saveUser(@RequestBody final User user) {
		final User newUser = this.userService.findUser(user.getEmail());
		if(newUser==null) {
			this.userService.saveUser(user);
			return "success";
		}
		else {
			return "failed";
		}
	}
	
	@GetMapping("/user")
	public User validateUser(@RequestParam("email") final String email, @RequestParam("password") final String password) {
		System.out.println(email);
		System.out.println(password);
		final User user = userService.authenticateUser(email, password);
		if(user!=null) {
			return user;
		}
		else {
			return null;
		}
		
	}
}
