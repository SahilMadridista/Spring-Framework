package com.sahil.springboot.cruddemo.dao;

import java.util.List;
import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sahil.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOHibernameImpl implements EmployeeDAO {

	// Define field for Entity manager
	private EntityManager entityManager;
	
	// Set up constructor injection
	
	@Autowired
	public EmployeeDAOHibernameImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	@Transactional
	public List<Employee> findAll() {
		
		// Get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// Create a query
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee",Employee.class);
		
		// Execute
		List<Employee> emp = theQuery.getResultList();
		
		// Return results
		return emp;
	}

}
