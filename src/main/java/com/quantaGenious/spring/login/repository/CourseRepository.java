package com.quantaGenious.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.login.models.Role;


@Repository
public interface CourseRepository extends JpaRepository<Role, Integer> {

	Course save(Course course);

}
