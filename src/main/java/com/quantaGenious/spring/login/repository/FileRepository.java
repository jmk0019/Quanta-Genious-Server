package com.quantaGenious.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quantaGenious.spring.login.models.File;


@Repository
public interface FileRepository extends JpaRepository<File, String> {
	
	File getFileById(Long id);

}
