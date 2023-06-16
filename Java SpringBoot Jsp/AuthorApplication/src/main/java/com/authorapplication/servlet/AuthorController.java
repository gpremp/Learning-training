package com.authorapplication.servlet;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.authorapplication.daoservices.AuthorServices;
import com.authorapplication.entities.Author;



/**
 * RESTapi Servlet controller for Author to add, remove, delete the Author data.
 * @author premgupta
 *
 */
@RestController
public class AuthorController {

	@Autowired
	private AuthorServices authorServices;
	
	/**
	 * Mapping with addauthor link to add new author
	 * @param author represents the object of Author
	 * @return return the newly added Author
	 */
	@PostMapping("/author")
	public Author addAuthor(@RequestBody final Author author) {
		final Author newAuthor = authorServices.saveAuthor(author);
		return newAuthor;
	}
	
	/**
	 * Mapping with getauthor link to get the details of an author
	 * @return  return the object of author
	 */
	@GetMapping("/author/{id}")
	public Author getAuthor(@PathVariable("id") final int id) {
		final Author author = authorServices.getAutherById(id);
		return author;
	}
	
	/**
	 * Mapping with getauthor link to get the details of an author
	 * @param firstName represents the first name of Author
	 * @param lastName  represents the last name of Author
	 * @return  return the object of author
	 */
	@GetMapping("/getauthor/{firstName}/{lastName}")
	public List<Author> getAuthor(@PathVariable final String firstName, @PathVariable final String lastName) {
		final List<Author> authors = authorServices.getAuthor(firstName, lastName);
		return authors;
	}
	
	/**
	 * Mapping with deletAuthor link to delete an author
	 * @param firstName represents the first name of Author
	 * @param lastName  represents the last name of Author
	 * @return return the deleted author
	 * rechardtion 
	 */
	@DeleteMapping("/author/{firstName}/{lastName}")
	public List<Author> deleteAuthor(@PathVariable final String firstName, @PathVariable final String lastName) {
		final List<Author> authors = authorServices.deleteAuthor(firstName, lastName);
		return authors;
	}
	
	/**
	 * Mapping with getallauthor link to get the details of all author
	 * @return return the list of all authors
	 */
	@GetMapping("/authors")
	public List<Author> getAuthors() {
		final List<Author> authors = authorServices.getAllAuthors();
		return authors;
	}
	
}
