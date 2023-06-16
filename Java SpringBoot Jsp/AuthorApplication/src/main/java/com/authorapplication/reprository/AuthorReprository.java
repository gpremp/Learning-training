package com.authorapplication.reprository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.authorapplication.entities.Author;




/**
 *  Repository interface of Author to perform database manipulation of Author details
 * @author premgupta
 *
 */
public interface AuthorReprository extends CrudRepository<Author, Integer>{
	
	public List<Author> findByFirstNameAndLastName(final String firstName,final String lastName);
	public List<Author> deleteByFirstNameAndLastName(final String firstName,final String lastName);

}
