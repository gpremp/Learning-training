package com.LibrarianApplication.daoservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.LibrarianApplication.entities.Librarian;
import com.LibrarianApplication.reprository.LibrarianReprository;

/**
 * Service class of Data Access for Librarian to add, read, update and delete Librarian data from database
 * @author premgupta
 *
 */
@Component
public class LibrarianServices {

	@Autowired
	private LibrarianReprository librarianReprository;
	
	/**
	 * Method to save Librarian data into the database
	 * @param librarian represents the object of a Librarian
	 */
	public void saveLibrarian(final Librarian librarian) {
		try {
			this.librarianReprository.save(librarian);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		
	}
	
	/**
	 * Method to get the data of a Librarian by its email
	 * @param email represents the email of a Librarian
	 * @return return true if data found else false
	 */
	public boolean getLibrarian(final String email){
		final List<Librarian> librarians = this.librarianReprository.findByEmail(email);
		if(librarians.isEmpty()) {
			return true;
		}
		return false;
		
	}
	
	/**
	 * Method to check Librarian details by its email and password
	 * @param email represents the email of Librarian
	 * @param password represents the password of Librarian
	 * @return return true if email and password matched else null
	 */
	public String loginLibraian(final String email,final String password) {
		final List<Librarian> librarians = this.librarianReprository.findByEmail(email);
		if(!(librarians.isEmpty())) {
			if(librarians.get(0).getPassword().equals(password)) {
				return librarians.get(0).getFirstName();
			}
		}
		return null;
    }
}
