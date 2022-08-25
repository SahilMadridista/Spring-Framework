package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;

public class UpdateAllStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Use the session to update the java objects
			System.out.println("----Updating all student objects----");
			
			// Start a transaction
			session.beginTransaction();
			
			session.createQuery("update Student set email = 'player@rm.com'")
			.executeUpdate();
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Objects updated.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
