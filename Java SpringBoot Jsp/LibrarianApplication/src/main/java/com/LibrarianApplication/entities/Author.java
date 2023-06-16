package com.LibrarianApplication.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Model class of Author to store the details of an author
 * @author premgupta
 *
 */
@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;   // represents the id of Author
	private String firstName; // represents the first name of Author
	private String lastName;  // represents the last name of Author
	private int age;  // represents the age of Author
	public Author() {
		super();
		
	}
	public Author(final String firstName,final String lastName,final int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	public int getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public int getAge() {
		return age;
	}

}
