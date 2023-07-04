package com.quantaGenious.spring.service;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.login.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private CourseRepository courseRepository;
    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> getCourseById(Integer id) {
        return courseRepository.findById(id);
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteEmployee(Integer id) {
        courseRepository.deleteById(id);
    }
}




