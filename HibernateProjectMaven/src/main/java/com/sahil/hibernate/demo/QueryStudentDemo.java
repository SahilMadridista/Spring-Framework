package com.sahil.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {

			System.out.println("----Retrieving the student object----");
			
			// Start a transaction
			session.beginTransaction();
			
			// Query all students
			
			List<Student> theStudents = session.createQuery("from Student").getResultList();
			
			// List<Student> theStudents = session.createQuery("from Student s where s.lastName= 'Alonso' OR s.firstName = 'Luka'").list();

			// List<Student> theStudents = session.createQuery("from Student s where s.email LIKE '%@rm.com'").getResultList();
			
			// Display the students
			for(Student tempStudent : theStudents) {
				System.out.println(tempStudent);
			}
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Object retrieved.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
