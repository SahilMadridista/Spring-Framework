package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sahil.hibernate.entity.Student;

public class PrimaryKeyDemo {

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
					System.out.println("----Creating new student objects----");
					
					// Create 3 student objects
					Student theStudent1 = new Student("Toni","Kroos","tk8@rm.com");
					Student theStudent2 = new Student("Luka","Modric","lm10@rm.com");
					Student theStudent3 = new Student("Cristiano","Ronaldo","cr7@rm.com");
					
					// Start a transaction
					session.beginTransaction();
					
					// Save the student object
					System.out.println("----Saving the student objects----");
					session.save(theStudent1);
					session.save(theStudent2);
					session.save(theStudent3);
					
					// Commit transaction
					session.getTransaction().commit();
					
					System.out.println("Object saved.");
					
				}finally {
					
					factory.close();
					
				}
		
	}
	
}
