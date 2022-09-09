package com.sahil.onetomany.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;
import com.sahil.mapping.entity.Review;

public class DeleteCourseAndReviewDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the course
			int id = 10;
			Course course = session.get(Course.class, id);
			
			// Print the course
			System.out.println("Course details: " + course);
			
			// Print reviews
			System.out.println("Reviews are: " + course.getReviews());
			
			// Deleting course
			
			System.out.println("Deleting the course...");
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
