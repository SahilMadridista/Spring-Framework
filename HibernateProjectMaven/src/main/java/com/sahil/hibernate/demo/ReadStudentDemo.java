package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;

public class ReadStudentDemo {

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
			Student theStudent = new Student("Xabi","Alonso","xa14@rm.com");
			
			// Start a transaction
			session.beginTransaction();
			
			// Save the student object
			System.out.println("----Saving the student object----");
			System.out.println("---------------------------------");
			System.out.println(theStudent);
			session.save(theStudent);
			
			// Commit transaction
			session.getTransaction().commit();
			
			// New code
			
			// Find out the student's ID: Primary key

			System.out.println("Saved student with ID: " + theStudent.getId());
			
			// Now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on ID primary key
			System.out.println("----Getting student with ID: " + theStudent.getId());
			
			Student myStudent = session.get(Student.class, theStudent.getId());
			
			System.out.println("Get complete: " + myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
