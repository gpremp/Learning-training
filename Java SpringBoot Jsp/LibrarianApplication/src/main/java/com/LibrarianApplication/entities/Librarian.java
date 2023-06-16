package com.LibrarianApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Model class of Librarian to store the details of an Librarian
 * @author premgupta
 *
 */
@Entity
public class Librarian {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;    // represents the id of Librarian
	private String firstName;  // represents the first name of Librarian
	private String lastName;   // represents the last name of Librarian
	private String email;   // represents the id email Librarian
	private String password;   // represents the password of Librarian
	public Librarian() {
		super();
	}
	public Librarian(final String firstName,final String lastName,final String email,final String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public int getId() {
		return Id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}

}
