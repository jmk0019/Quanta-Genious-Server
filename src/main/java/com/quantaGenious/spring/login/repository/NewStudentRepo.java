package com.quantaGenious.spring.login.repository;

import com.quantaGenious.spring.login.models.NewStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewStudentRepo  extends JpaRepository<NewStudent, Integer> {
}
