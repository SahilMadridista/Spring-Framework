package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Use the session to save the java object
			System.out.println("----Creating new student object----");
			
			// Create a student object
			Student theStudent = new Student("Isco","Alarcon","ia22@rm.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("----Saving the student object----");
			session.save(theStudent);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Object saved.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
