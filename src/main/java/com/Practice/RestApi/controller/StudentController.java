package com.Practice.RestApi.controller;

import java.util.ArrayList;
import java.util.List;


import com.Practice.RestApi.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Practice.RestApi.StudentDTO.StudentDTO;

//@CrossOrigin(origins = "http://localhost:9999")
@RestController
@RequestMapping("/v1")
public class StudentController {

	@Autowired
	private StudentService studentService;

//	@GetMapping( value ="/student")
//	public String helloworld() {
//		return "helloworld";

	//	}
	@GetMapping(value = "/studentlist")
	public List<StudentDTO> getAllStudentList() {
		List<StudentDTO> students = new ArrayList<>();
		students = studentService.getAllStudentList();
		return students;

	}

	@PostMapping(value = "/students")
	public void createStudent(@RequestBody StudentDTO studentDTO) {
		studentService.createStudent(studentDTO);

	}

		@DeleteMapping(value ="/students/{id}" )
		public void deleteStudentById(@PathVariable long id){
		studentService.deleteStudent(id);

	}


//	@PutMapping(value = "/students/")
//	public String updateStudent(@RequestBody StudentDTO studentDTO) {
//		String str= null;
//		if (studentDTO!=null) {
//			studentService.updateStudent(studentDTO);
//			return "update successfully";
//		}
//		else {
//		return 	str;
//		}


		@PutMapping(value = "/students/")
		public StudentDTO updateStudent(@RequestBody StudentDTO studentDTO) {

		StudentDTO dto=studentService.updateStudent(studentDTO);
       return dto;






	}
}
