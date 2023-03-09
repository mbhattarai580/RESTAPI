package com.main.person.service;

import com.main.person.entity.Student;

import java.util.Collection;
import java.util.List;

public interface StudentService {


    List<Student> getAllStudent();


    void addStudent(Student student);


    List<Student> findById(Long id);


    Student updateStudent(Student student, long id);

    Collection<Student> deleteStudent(long id);


}



    
    
