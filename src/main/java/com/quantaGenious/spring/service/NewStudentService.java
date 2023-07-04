package com.quantaGenious.spring.service;

import com.quantaGenious.spring.login.models.NewStudent;

import java.util.List;

public interface NewStudentService {
    NewStudent addStudent(NewStudent newStudent);

    List< NewStudent > listAll();

}
