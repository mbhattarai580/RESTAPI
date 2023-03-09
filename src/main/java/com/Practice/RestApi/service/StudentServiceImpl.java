package com.Practice.RestApi.service;

import com.Practice.RestApi.StudentDTO.StudentDTO;
import com.Practice.RestApi.model.StudentEntity;
import com.Practice.RestApi.model.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void createStudent(StudentDTO studentDTO) {

    }

    @Override
    public List<StudentDTO> getAllStudentList() {
        List<StudentEntity> students = studentRepository.findAll();

        List<StudentDTO> studentDTOS = new ArrayList<>();
        for (StudentEntity student : students) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setTid(student.getId());
            studentDTO.setSname(student.getName());
            studentDTO.setAddress(student.getAddress());
            studentDTO.setPhonenumber(student.getPhonenumber());
            studentDTOS.add(studentDTO);
        }

        return studentDTOS;

    }
//    @Override
//    public void updateStudent(StudentDTO studentDTO) {
//        StudentEntity studentEntity = studentRepository.findById(studentDTO.getTid()).get();
//        studentEntity.setId(studentDTO.getTid());
//        studentEntity.setName(studentDTO.getSname());
//        studentEntity.setAdress(studentDTO.getAddress());
//        studentEntity.setPhonenumber(studentDTO.getPhonenumber());
//
//        studentRepository.save(studentEntity);
//}




    @Override
     public StudentDTO updateStudent(StudentDTO studentDTO) {
        StudentEntity studentEntity = studentRepository.findById(studentDTO.getTid()).get();
        studentEntity.setId(studentDTO.getTid());
        studentEntity.setName(studentDTO.getSname());
        studentEntity.setAdress(studentDTO.getAddress());
        studentEntity.setPhonenumber(studentDTO.getPhonenumber());

      StudentEntity dto=  studentRepository.save(studentEntity);
       StudentDTO dto2=new StudentDTO();
      //  BeanUtils.copyProperties(dto,dto2);
       dto2.setTid(dto.getId());
       dto2.setSname(dto.getName());
       dto2.setAddress(dto.getAddress());
       dto2.setPhonenumber(dto.getPhonenumber());
        return dto2;

    }

    @Override
    public void deleteStudent(long id) {

    }
}