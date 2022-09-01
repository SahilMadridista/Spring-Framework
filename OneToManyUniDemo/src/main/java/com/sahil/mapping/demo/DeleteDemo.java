package com.sahil.mapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get object using primary key 
			int id = 2 ;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			System.out.println("Instructor found : " + instructor);
			
			if(instructor != null) {
				
				System.out.println("Deleting the instructor...");
				
				// This will also delete the details
				
				session.delete(instructor);
				
			}else {
				
				System.out.println("Instructor not found in the database");
			
			}
			
			// Commit transaction
			session.getTransaction().commit();
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
