package com.example.latihanbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.latihanbackend.model.Student;
import com.example.latihanbackend.service.IStudentService;

@RestController
@CrossOrigin("http://localhost:8080")
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
	IStudentService studentService;
	
	@PostMapping("/insert")
	public Student insertStudent(@RequestBody Student student) {
		return studentService.insertStudent(student);
	}
	
	@GetMapping("/getAll")
	public List<Student> getAllStudent(){
		return studentService.getAllStudent();
	}
	
	@PutMapping("/update/{id}")
	public Student updateStudent(@PathVariable int id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);
	}
	
	@DeleteMapping("/delete/{id}")
	public Student deleStudent(@PathVariable int id) {
		return studentService.deleteStudent(id);
	}
	
	@GetMapping("/updateGetId/{id}")
	public Student updateGetId(@PathVariable int id) {
		return studentService.updateGettId(id);
	}
}
