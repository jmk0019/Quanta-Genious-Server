package com.quantaGenious.spring.login.controllers;

import java.net.URI;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.login.security.services.StudentService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class StudentsController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/students/{studentId}/courses")
	public Set<Course> retrieveCoursesForStudent(@PathVariable int studentId) {
		return studentService.retrieveCourses(studentId);
	}

	@PostMapping("/students/{studentId}/courses")
	public Course registerStudentForCourse(
			@PathVariable int studentId, @RequestBody Course newCourse) {

		Course course = studentService.addCourse(studentId, newCourse);

		if (course == null)
			return null;
		return course;
	}

	@GetMapping("/students/{studentId}/courses/{courseId}")
	public Course retrieveDetailsForCourse(@PathVariable int studentId,
			@PathVariable int courseId) {
		return studentService.retrieveCourse(studentId, courseId);
	}

}
