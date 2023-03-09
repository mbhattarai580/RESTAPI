package com.Practice.RestApi.service;

import com.Practice.RestApi.StudentDTO.StudentDTO;

import java.util.List;

public interface StudentService {
    void createStudent(StudentDTO studentDTO);

    List<StudentDTO> getAllStudentList();

    //void updateStudent(StudentDTO studentDTO);

   StudentDTO updateStudent(StudentDTO studentDTO);

    void deleteStudent(long id);
}
