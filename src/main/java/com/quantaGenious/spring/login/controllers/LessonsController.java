package com.quantaGenious.spring.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.login.models.Lessons;
import com.quantaGenious.spring.service.CourseService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class LessonsController {
	
    @Autowired
    private CourseService courseService;
	
	
	 @PostMapping("/addLesson")
	    public ResponseEntity<Lessons>addLessonsToCourse(@RequestBody Lessons lessons){
		 Lessons addedLesson=courseService.addLessonsToCourse(lessons);
	        return ResponseEntity.status(HttpStatus.CREATED).body(addedLesson);
	    }

}
