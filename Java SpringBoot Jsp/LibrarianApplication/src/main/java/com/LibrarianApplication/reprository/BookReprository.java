package com.LibrarianApplication.reprository;

import org.springframework.data.repository.CrudRepository;

import com.LibrarianApplication.entities.Book;



/**
 *  Repository interface of Book to perform database manipulation of Book details
 * @author premgupta
 *
 */
public interface BookReprository extends CrudRepository<Book, Integer>{

}
