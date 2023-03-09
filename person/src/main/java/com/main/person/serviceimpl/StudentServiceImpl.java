package com.main.person.serviceimpl;

import com.main.person.DAO.StudentRepository;
import com.main.person.entity.Student;
import com.main.person.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getAllStudent() {
        List<Student> students= studentRepository.findAll();
        return students;
    }


    @Override
    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findById(Long id) {
//        Optional<Student> optionalStudent=studentRepository.findById(id);
//        if (optionalStudent.isPresent())
//            optionalStudent.get();
    // Student student= studentRepository.findById(id).get();
      //  return optionalStudent.get();
        return  getAllStudent().stream().filter(student ->student.getId()==id ).collect(Collectors.toList());
        }




    @Override
    public Student updateStudent(Student student, long id) {
        Student updateStudent = new Student();
        updateStudent.setId(student.getId());
        updateStudent.setName(student.getName());
        updateStudent.setAddress(student.getAddress());
        updateStudent.setPhonenumber(student.getPhonenumber());
        studentRepository.save(updateStudent);
        //return "update";
        return updateStudent;
    }







    @Override
    public Collection<Student> deleteStudent(long id) {
     // studentRepository.deleteById(id);

        getAllStudent().stream().filter(student ->student.getId()!=id ).collect(Collectors.toList());
        return null;
    }

    }



















