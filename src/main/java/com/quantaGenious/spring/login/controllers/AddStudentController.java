package com.quantaGenious.spring.login.controllers;

import com.quantaGenious.spring.login.models.NewStudent;
import com.quantaGenious.spring.service.NewStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class AddStudentController {
    @Autowired
    private NewStudentService newStudentService;
    @PostMapping("/addStudent")
    public ResponseEntity<NewStudent> addStudent(@RequestBody NewStudent newStudent){
        NewStudent addedStudent=newStudentService.addStudent(newStudent);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedStudent);
    }
    @GetMapping("/students")
    public List<NewStudent> listAll(){
        return newStudentService.listAll();

    }
}
