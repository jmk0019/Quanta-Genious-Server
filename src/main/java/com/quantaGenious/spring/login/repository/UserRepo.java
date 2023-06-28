package com.quantaGenious.spring.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quantaGenious.spring.login.models.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
	
	 Optional<User> findByUsername(String username);
	 
	 User findByUserId(int userId);

	  Boolean existsByUsername(String username);

	  Boolean existsByEmail(String email);

}
