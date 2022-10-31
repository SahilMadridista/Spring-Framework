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

	public Employee findById(int theId) {
		
		// Get the current hibernate session
		Session curr = entityManager.unwrap(Session.class);
		
		// Get the employee
		Employee theEmployee = curr.get(Employee.class, theId);
		
		// return
		return theEmployee;
	}

	public void save(Employee theEmployee) {
		
		Session curr = entityManager.unwrap(Session.class);
		curr.saveOrUpdate(theEmployee);
		
	}

	public void deleteById(int theId) {
		
		Session curr = entityManager.unwrap(Session.class);
		
		Query tq = curr.createQuery("delete from Employee where id=:employeeId");
		
		tq.setParameter("employeeId", theId);
		
		tq.executeUpdate();
		
	}

}



















