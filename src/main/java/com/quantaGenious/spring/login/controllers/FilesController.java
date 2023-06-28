package com.quantaGenious.spring.login.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.quantaGenious.spring.login.models.File;
import com.quantaGenious.spring.login.models.User;
import com.quantaGenious.spring.login.payload.request.Response;
import com.quantaGenious.spring.login.payload.response.MessageResponse;
import com.quantaGenious.spring.service.DatabaseFileService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class FilesController {
	
	 @Autowired
	 DatabaseFileService fileStorageService;
	
	@GetMapping("/downloadFile/{fileId:.+}")
    public ResponseEntity < Resource > downloadFile(@PathVariable Long fileId, HttpServletRequest request) {
        // Load file as Resource
		File databaseFile = fileStorageService.getFile(fileId);

        return ResponseEntity.ok()
            .contentType(MediaType.parseMediaType(databaseFile.getFileType()))
            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + databaseFile.getFileName() + "\"")
            .body(new ByteArrayResource(databaseFile.getData()));
    }
	
	@PostMapping("/uploadFile")
    public Response uploadFile(@RequestParam("file") MultipartFile file) {
        File fileName = fileStorageService.storeFile(file);

        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
            .path("/downloadFile/")
            .path(fileName.getFileName())
            .toUriString();

        return new Response(fileName.getFileName(), fileDownloadUri,
            file.getContentType(), file.getSize());
    }
	
	@PostMapping("/uploadMultipleFiles")
    public List < Response > uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.asList(files)
            .stream()
            .map(file -> uploadFile(file))
            .collect(Collectors.toList());
    }

}
