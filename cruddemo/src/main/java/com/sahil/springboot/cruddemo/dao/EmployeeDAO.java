package com.sahil.springboot.cruddemo.dao;

import java.util.List;
import com.sahil.springboot.cruddemo.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
	
}
