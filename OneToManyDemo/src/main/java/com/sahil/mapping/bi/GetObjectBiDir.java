package com.sahil.mapping.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;

public class GetObjectBiDir {

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
			
			// Get the instructor detail object
			
			int id = 3;
			
			InstructorDetail instructorDetail = session
					.get(InstructorDetail.class, id);
			
			System.out.println("Instructor details are : " + instructorDetail);
			
			System.out.println("Linked instructor is : " + instructorDetail.getInstructor());
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Operation done.");
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
			
			// Handle the connection leak issue
			session.close();
			
			factory.close();
			
		}
		

	}

}
