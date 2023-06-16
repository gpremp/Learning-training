package com.LibrarianApplication.reprository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.LibrarianApplication.entities.Librarian;


/**
 *  Repository interface of Librarian to perform database manipulation of Librarian details
 * @author premgupta
 *
 */
public interface LibrarianReprository extends CrudRepository<Librarian, Integer>{

	public List<Librarian> findByEmail(final String email);
}
