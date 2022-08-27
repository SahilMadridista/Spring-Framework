package com.sahil.mapping.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;

public class ReadDetailsDemo {

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
			
			int id =2;
			
			// Start a transaction
			session.beginTransaction();
			
			Instructor instructor = session.get(Instructor.class, id);
			
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, 
					instructor.getInstructorDetail().getId());
			
			System.out.println(instructor);
			
			System.out.println(instructorDetail);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Instructor saved.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
