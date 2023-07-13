package com.quantaGenious.spring.login.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quantaGenious.spring.login.models.Tutor;

@Repository
public interface UserRepository extends JpaRepository<Tutor, Integer> {
	
  Optional<Tutor> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
  
  @Transactional
  @Modifying // It means it's not a select statement
  @Query(value = "UPDATE tutors set password = :password", nativeQuery = true)
  void changeUserPassword(@Param("password") String password);
}
