package com.sahil.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;

public class DeleteInstructorCourseDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get a course
			
			int id = 11;
			
			Course course = session.get(Course.class, id);
			
			// Delete course
			System.out.println("Deleting course : " + course);
			
			session.delete(course);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
		

	}

}
