package com.quantaGenious.spring.login.models;
import java.sql.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "lessons")
public class Lessons {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int lessonId;
  
  @NotBlank
  @Size(max = 20)
  private String sectionName;

  @NotBlank
  @Size(max = 20)
  private String lessonName;
  
  @CreatedDate
  @Column(name = "created_date")
  private Date createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  private Date lastModifiedDate;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "lesson_mapping", 
             joinColumns = @JoinColumn(name = "lesson_id"),
             inverseJoinColumns = @JoinColumn(name = "course_id"))
  private Set<Course> courses = new HashSet<>();

  public Lessons() {
  }

public int getLessonId() {
	return lessonId;
}

public void setLessonId(int lessonId) {
	this.lessonId = lessonId;
}


public Date getCreatedDate() {
	return createdDate;
}

public void setCreatedDate(Date createdDate) {
	this.createdDate = createdDate;
}

public Date getLastModifiedDate() {
	return lastModifiedDate;
}

public void setLastModifiedDate(Date lastModifiedDate) {
	this.lastModifiedDate = lastModifiedDate;
}

public Set<Course> getCourses() {
	return courses;
}

public void setCourses(Set<Course> courses) {
	this.courses = courses;
}



public String getSectionName() {
	return sectionName;
}

public void setSectionName(String sectionName) {
	this.sectionName = sectionName;
}

public String getLessonName() {
	return lessonName;
}

public void setLessonName(String lessonName) {
	this.lessonName = lessonName;
}

@Override
public String toString() {
	return "Lessons [lessonId=" + lessonId + ", sectionName=" + sectionName + ", lessonName=" + lessonName
			+ ", createdDate=" + createdDate + ", lastModifiedDate=" + lastModifiedDate + ", courses=" + courses + "]";
}

}
