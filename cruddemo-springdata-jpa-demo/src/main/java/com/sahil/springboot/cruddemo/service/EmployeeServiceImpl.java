package com.sahil.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sahil.springboot.cruddemo.dao.EmployeeRepository;
import com.sahil.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeEmployeeRepository) {
		employeeRepository=theEmployeeEmployeeRepository;
	}
	
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if(result.isPresent()) {
			theEmployee = result.get();
		}else {
			throw new RuntimeException("Not found: " + theId);
		}
		
		return theEmployee;
	}

	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}
