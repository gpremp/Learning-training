package com.LibrarianApplication.daoservices;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LibrarianApplication.entities.Author;
import com.LibrarianApplication.reprository.AuthorReprository;

/**
 * Service class of Data Access for Author to add, read, and delete Authors data from database
 * @author premgupta
 *
 */
@Component
public class AuthorServices {

	@Autowired
	private AuthorReprository authorReprository;
	
	/**
	 * Method to save new Author data into database
	 * @param author Author object to save into database
	 * @return return newly save Author object
	 */
	public Author saveAuthor(final Author author) {
		return this.authorReprository.save(author);
	}
	
	/**
	 * Method to get List of Author by its first name and last name
	 * @param firstName represents the first name of Author
	 * @param lastName represents the last name of Author
	 * @return return the list of Authors
	 */
	public List<Author> getAuthor(final String firstName,final String lastName) {
		final List<Author> authors = this.authorReprository.findByFirstNameAndLastName(firstName, lastName);
			return authors;
	}
	
	/**
	 * Method to get the list of all Author from the database
	 * @return return the list of all Authors
	 */
	public List<Author> getAllAuthors() {
		return (List<Author>) this.authorReprository.findAll();
	}
	
	/**
	 * Method to delete the data of a Author
	 * @param firstName firstName represents the first name of Author
	 * @param lastName lastName represents the last name of Author
	 * @return return the details of deleted Author
	 */
	@Transactional
	public List<Author> deleteAuthor(final String firstName,final String lastName) {
		return this.authorReprository.deleteByFirstNameAndLastName(firstName, lastName);
	}
}
