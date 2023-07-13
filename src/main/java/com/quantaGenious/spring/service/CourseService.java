package com.quantaGenious.spring.service;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.login.models.Lessons;
import com.quantaGenious.spring.login.models.Tutor;
import com.quantaGenious.spring.login.repository.CourseRepository;
import com.quantaGenious.spring.login.repository.LessonsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
	@Autowired
    private CourseRepository courseRepository;
	
	@Autowired
	private LessonsRepository lessonsRepo;
	
	
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

	public Lessons addLessonsToCourse(Lessons lessons) {
		
			return lessonsRepo.save(lessons);
			
		}
	
}





