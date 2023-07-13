package com.quantaGenious.spring.login.controllers;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/auth")
public class CourseController {
    @Autowired
    private  CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return courseService.getCourses();
    }
    @PostMapping("/addCourse")
    public ResponseEntity<Course>addCourse(@RequestBody Course course){
        Course addedCourse=courseService.addCourse(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedCourse);
    }

}
