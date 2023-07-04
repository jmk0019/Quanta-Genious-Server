package com.quantaGenious.spring.service;

import com.quantaGenious.spring.login.models.NewStudent;
import com.quantaGenious.spring.login.repository.NewStudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewStudentImpl implements NewStudentService {
    private NewStudentRepo newStudentRepo;;
    public NewStudentImpl(NewStudentRepo newStudentRepo){
        this.newStudentRepo=newStudentRepo;
    }

    @Override
    public NewStudent addStudent(NewStudent newStudent) {
        return newStudentRepo.save(newStudent);
    }

    @Override
    public List<NewStudent> listAll() {
        return newStudentRepo.findAll();
    }
}
