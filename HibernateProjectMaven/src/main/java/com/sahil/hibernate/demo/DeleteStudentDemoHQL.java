package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;

public class DeleteStudentDemoHQL {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Use the session to delete the java object
			
			// Start a transaction
			session.beginTransaction();

			session.createQuery("delete from Student where id=7")
			.executeUpdate();
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Object deleted.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
