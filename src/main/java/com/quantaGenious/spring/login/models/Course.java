package com.quantaGenious.spring.login.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "Courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int courseId;

	@Column(name = "name")
	private String courseName;
	
	@Column(name = "description")
	private String description;
	
	
	public Course() {

	}

	public Course(int courseId, String courseName, String description) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.description = description;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Course{" +
				"courseId=" + courseId +
				", courseName='" + courseName + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
