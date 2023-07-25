package com.quantaGenious.spring.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quantaGenious.spring.login.models.File;

import java.util.List;



@Repository
public interface FileRepository extends JpaRepository<File, Long> {


	File getFileById(Long id);
	
	@Override
	List<File> findAll();
	
	List<File> getAllFilesByIdIn(List<Long> id);
}
