package com.blogPost.doaservices;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogPost.entities.User;
import com.blogPost.reprository.UserReprository;

@Service
public class UserService {
	
	@Autowired
	private UserReprository userReprository;
	
	public User saveUser(User user) {
		return userReprository.save(user);
	}
	
	/**
	 * method to find the object of user by its e-mail ID 
	 * @param email represents the e-mail ID of user 
	 * @return returns the object of user 
	 */
	public User findUser(final String email) {
		final List<User> users = this.userReprository.findByEmail(email);
		if(!users.isEmpty()) {
			return users.get(0);
		}
		return null;
	}
	
	/**
	 * method to authenticate a user by its e-mail and password 
	 * @param email represents the e-mail of user 
	 * @param password repeating step password of user 
	 * @return returns the object of user 
	 */
	public User authenticateUser(final String email,final String password) {
		final User user = findUser(email);
		if(null!= user) {
			if(user.getPassword() != null &&user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}
}
