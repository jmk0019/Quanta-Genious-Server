package com.quantaGenious.spring.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quantaGenious.spring.login.models.Tutor;

@Repository
public interface UserRepository extends JpaRepository<Tutor, Long> {
  Optional<Tutor> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);
}
