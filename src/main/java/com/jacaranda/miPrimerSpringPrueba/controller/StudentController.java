package com.jacaranda.miPrimerSpringPrueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jacaranda.miPrimerSpringPrueba.model.Student;
import com.jacaranda.miPrimerSpringPrueba.services.StudentService;

@Controller
public class StudentController {
	
	@Autowired
	StudentService repositorio;
	
	@GetMapping("/listStudent")
	public String listStudent(Model model) {
		model.addAttribute("lista", repositorio.getStudents());
		
		return "listStudents";
	}
	
	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		Student s =new Student();
		
		
		model.addAttribute("student", s);
		
		return "addStudent";
	}
	
	@PostMapping("/addStudent/submit")
	public String addStudentSubmit(@ModelAttribute("student") Student s ) {
		repositorio.addStudent(s);
		
		return "redirect:/listStudent";
	}
	
	@GetMapping("/borrarStudent")
	public String borrarStudent(Model model,
				@RequestParam(name="name", required=true) String name,
				@RequestParam(name="surname", required=true) String surname
			) {
		Student student=repositorio.getStudent(name, surname);
		model.addAttribute("student", student);
		
		return "borrarStudent";
	}
	
	@PostMapping("/borrarStudent/submit")
	public String borrarStudentSubmit(@ModelAttribute("student")Student student) {
		repositorio.removeStudent(student);
		
		return "redirect:/listStudent";
	}
	
	@GetMapping("/editStudent")
	public String editStudent(Model model, @RequestParam(name="name", required=false, defaultValue="")String name,
			@RequestParam(name="surname", required=false, defaultValue="")String surname) {
		
		Student estudiante = repositorio.getStudent(name, surname);
		model.addAttribute("student", estudiante);
		
		return "editStudent";
	}
	
	@PostMapping("/editStudent/Submit")
	public String listStudentseditMethod ( @ModelAttribute("student") Student student) {
		
		repositorio.updateStudent(student.getName(), student.getSurname(), student.getAge());
			
		return "redirect:/listStudent";
	}

}
