package com.quantaGenious.spring.login.security.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.quantaGenious.spring.login.models.Course;
import com.quantaGenious.spring.login.models.Tutor;
import com.quantaGenious.spring.login.models.User;
import com.quantaGenious.spring.login.repository.CourseRepository;
import com.quantaGenious.spring.login.repository.UserRepo;
import com.quantaGenious.spring.login.repository.UserRepository;


@Service
public class StudentService {
	
	@Autowired
    private UserRepo userRepo;
	
	@Autowired
	private UserRepository tutorRepo;
	
	@Autowired
	private CourseRepository courseRepo;
	
	  @Autowired
	  PasswordEncoder encoder;
	

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
	
	
	

	public Course addCourse(int tutorId, Course course) {
		Optional<Tutor> tutor = tutorRepo.findById(tutorId);

		if (tutor == null) {
			return null;
		}
		
		Course CourseData =courseRepo.save(course);
		
		if(CourseData!=null) {
			
//			for (User user : course.getUsers()) {
//				user.setCourses((Set<Course>) CourseData);
//				userRepo.save(user);	
//			}
			
		}
		
		return CourseData;
	}

	public int changeUserPassword(Tutor tutor, String newPassword) {
		
		int tutorId=tutor.getTutorId();
		String password=tutor.getPassword();
		
		boolean checkPassword=isTruePassword(tutorId,password);
		
		if(checkPassword) {
			tutorRepo.changeUserPassword(encoder.encode(newPassword));
			return 1;
		}
		
		return 0;
	}

 	private boolean isTruePassword(int tutorId, String password) {

     Optional<Tutor> tutor =tutorRepo.findById(tutorId);
     
     if(tutor!=null) {
    	 boolean check=encoder.matches(encoder.encode(password),tutor.get().getPassword());
    	 return check;
    	 
     }else {
		
		return false;
     }
	}

}
