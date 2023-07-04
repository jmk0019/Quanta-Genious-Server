package com.quantaGenious.spring.login.models;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tutors",
       uniqueConstraints = {
           @UniqueConstraint(columnNames = "username"),
           @UniqueConstraint(columnNames = "email")
       })
public class Tutor {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int tutorId;

  @NotBlank
  @Size(max = 20)
  private String username;

  @NotBlank
  @Size(max = 50)
  @Email
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;
  
  @CreatedDate
  @Column(name = "created_date")
  private Date createdDate;

  @LastModifiedDate
  @Column(name = "last_modified_date")
  private Date lastModifiedDate;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "tutor_roles", 
             joinColumns = @JoinColumn(name = "tutor_id"),
             inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles = new HashSet<>();

  public Tutor() {
  }

  public Tutor(String username, String email, String password) {
	  super();
    this.username = username;
    this.email = email;
    this.password = password;
  }


  public int getTutorId() {
	return tutorId;
}

public void setTutorId(int tutorId) {
	this.tutorId = tutorId;
}

public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
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

  
}
