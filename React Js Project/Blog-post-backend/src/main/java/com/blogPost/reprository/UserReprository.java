package com.blogPost.reprository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blogPost.entities.User;

public interface UserReprository extends JpaRepository<User,Integer>{
	public List<User> findByEmail(final String email);

}
