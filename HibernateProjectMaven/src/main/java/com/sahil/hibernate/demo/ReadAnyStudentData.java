package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Student;

public class ReadAnyStudentData {

	public static void main(String[] args) {
		
		// Create session factory
				SessionFactory factory = new Configuration()
						.configure("hibernate.cfg.xml")
						.addAnnotatedClass(Student.class)
						.buildSessionFactory();
				
				// Create session
				Session session = factory.getCurrentSession();
				
				
				try {
					
					// Use the session to read the java object
					System.out.println("----Reading the student object----");
					
					
					// Start a transaction
					session.beginTransaction();
					
					System.out.println("----Getting student with ID: 3");
					
					Student myStudent = session.get(Student.class, 3);
					
					System.out.println("Object read complete: " + myStudent);
					
					// Commit transaction
					session.getTransaction().commit();
					
					
				}finally {
					
					factory.close();
					
				}

	}

}
