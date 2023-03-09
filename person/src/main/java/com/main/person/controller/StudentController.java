package com.main.person.controller;

import com.main.person.entity.Student;
import com.main.person.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class StudentController {

    /*
   - get- getAllList of from existing resource
   - creat- new  resource
   - update-existing resource
   - delete-delete existing resource ById of from existing resource
 -  get- get  existing resource findById of from existing resource


     */
    @Autowired
    private StudentService studentService;

    @GetMapping(value = "/students")
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping(value = "/students/{id}")
    public List<Student> findById(@PathVariable Long id) {
        return studentService.findById(id);
    }


    @PostMapping(value = "/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void addStudent(@RequestBody Student student) {
        studentService.addStudent(student);


    }

    @PutMapping(value = "/update/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable long id) {
        studentService.updateStudent(student, id);


    }

    @DeleteMapping(value = "/delete/{id}")
    public void deleteStudent( @PathVariable long id){
             studentService.deleteStudent(id);
    }


}
