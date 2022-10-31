package com.sahil.springboot.cruddemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sahil.springboot.cruddemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	// That's it. No need to write any code here
	
}
