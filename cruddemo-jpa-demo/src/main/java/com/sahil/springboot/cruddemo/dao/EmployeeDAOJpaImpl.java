package com.sahil.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sahil.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOJpaImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public List<Employee> findAll() {

		// Create a query
		Query theQuery = entityManager.createQuery("from Employee");

		// Execute and get result
		List<Employee> emp = theQuery.getResultList();

		// Return result
		return emp;
	}

	public Employee findById(int theId) {

		// Get the employee
		Employee emp = entityManager.find(Employee.class, theId);

		// Return the employee
		return emp;
	}

	public void save(Employee theEmployee) {

		// Save or update the employee
		Employee dbEmp = entityManager.merge(theEmployee);

		// Update with id from db...
		theEmployee.setId(dbEmp.getId());

	}

	public void deleteById(int theId) {

		// Delete object with primary key
		Query theQuery = entityManager.createQuery(
				"delete from Employee where id=:empId"
				);

		// Setting the parameter
		theQuery.setParameter("empId", theId);
		
		theQuery.executeUpdate();
		
	}

}











