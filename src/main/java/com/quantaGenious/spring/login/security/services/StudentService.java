package com.quantaGenious.spring.login.security.services;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.login.models.User;
import com.quantaGenious.spring.login.repository.FileRepository;
import com.quantaGenious.spring.login.repository.UserRepo;


@Service
public class StudentService {
	
	@Autowired
    private UserRepo userRepo;

	public List<User> retrieveAllUsers() {
		return userRepo.findAll();
	}

	public User retrieveStudent(int userId) {
		return userRepo.findByUserId(userId);
	}

	public Set<Course> retrieveCourses(int studentId) {
		User student = retrieveStudent(studentId);

		return student == null ? null : student.getCourses();

	}

	public Course retrieveCourse(int studentId, int courseId) {
		User student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}

		for (Course course : student.getCourses()) {
			if (course.getCourseId()==courseId) {
				return course;
			}
		}

		return null;
	}

	public Course addCourse(int studentId, Course course) {
		User student = retrieveStudent(studentId);

		if (student == null) {
			return null;
		}
		course.setCourseId(course.getCourseId());
		student.getCourses().add(course);

		return course;
	}

}
