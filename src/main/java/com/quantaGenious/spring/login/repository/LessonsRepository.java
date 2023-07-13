package com.quantaGenious.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quantaGenious.spring.login.models.Lessons;

@Repository
public interface LessonsRepository extends JpaRepository<Lessons, Integer> {

}
