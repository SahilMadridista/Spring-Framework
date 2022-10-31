package com.sahil.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
	
	
	// Add mapping for GET /employees/{employeeId}
	
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee emp = employeeService.findById(employeeId);
		
		if(emp == null) {
			throw new RuntimeException("Employee id not found- " + employeeId);
		}
		
		return emp;
		
	}
	
	// Adding method for POST- adding a new employee
	
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	// Adding method for PUT- updating an employee
	
	@PutMapping("/employees")
	public Employee updateEmp(@RequestBody Employee theEmployee) {
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	// Adding method to delete an employee- DELETE
	
	@DeleteMapping("/employees/{id}")
	public String deleteEmp(@PathVariable int id) {

		Employee tempEmp = employeeService.findById(id);
		
		if(tempEmp == null) {
			throw new RuntimeException("Employee not found: " + id);
		}
		
		employeeService.deleteById(id);
		
		return "Deleted employee: " + id;
		
	}
	
}














