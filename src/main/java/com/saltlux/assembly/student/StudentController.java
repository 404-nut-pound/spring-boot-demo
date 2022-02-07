package com.saltlux.assembly.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.saltlux.assembly.vos.Student;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value = "/time")
	@ResponseBody
	public String getCurrentTimestamp() {
		return studentService.getCurrentTimestamp();
	}
	
	@GetMapping
	public String route() {
		return "student/student";
	}
	
	@GetMapping(value = "/list")
	@ResponseBody
	public String getStudentList() {
		return new Gson().toJson(studentService.getStudentList());
	}
	
	@PostMapping
	@ResponseBody
	public String insertStudent() {
		return new Gson().toJson(studentService.insertStudent());
	}
	
	@PutMapping
	@ResponseBody
	public String updateStudent(
			@RequestBody Student student,
			Model model
			) {
		return new Gson().toJson(studentService.updateStudent(student));
	}
	
	@DeleteMapping
	@ResponseBody
	public String deleteStudent(
			@RequestBody Student student,
			Model model
			) {
		return new Gson().toJson(studentService.deleteStudent(student));
	}
}
