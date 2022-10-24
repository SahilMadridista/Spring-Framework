package com.sahil.springdemo.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sahil.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentController {

	@GetMapping("/students")
	public List<Student> getStudents(){
		
		List<Student> myList = new ArrayList<Student>();
		
		myList.add(new Student("Karim", "Benzema"));
		myList.add(new Student("Luka", "Modric"));
		myList.add(new Student("Federico", "valverde"));
		myList.add(new Student("Toni", "Kroos"));
		myList.add(new Student("Gareth", "Bale"));
		
		return myList;
	}
	
}
