package com.quantaGenious.spring.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.quantaGenious.spring.exception.FileStorageException;
import com.quantaGenious.spring.login.models.File;
import com.quantaGenious.spring.login.repository.FileRepository;

@Service
public class DatabaseFileService {
	
    @Autowired
    private FileRepository dbFileRepository;

    public File storeFile(MultipartFile file) {
        // Normalize file name
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            // Check if the file's name contains invalid characters
            if (fileName.contains("..")) {
                throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
            }

            File dbFile = new File(fileName, file.getContentType(), file.getBytes());

            return dbFileRepository.save(dbFile);

        }
        catch (IOException ex) {
            throw new FileStorageException("Could not store file " + fileName + ". Please try again!", ex);
        } 
    }


    public File getFile(Long fileId) {
        return dbFileRepository.getFileById(fileId);
    }
    
    public List<File> getAllFiles(List<Long> fileIds) {
        return dbFileRepository.getAllFilesByIdIn(fileIds);
    }

    public List<File> getAllVideoFiles() {
        return dbFileRepository.findAll();
    }



}
