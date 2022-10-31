package com.sahil.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sahil.springboot.cruddemo.dao.EmployeeDAO;
import com.sahil.springboot.cruddemo.entity.Employee;
import com.sahil.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	// Inject employee DAO
	
	private EmployeeService employeeService;
	
	public EmployeeRestController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	
	// Expose "/employees" end point to get the list
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	
	
}
