package com.sahil.onetomany.uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;
import com.sahil.mapping.entity.Review;

public class CreateCourseAndReviewDemo {

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
			
			// Create a course
			
			Course course = new Course("How to shoot");
			
			// Add some reviews
			
			course.addReview(new Review("Great course"));
			course.addReview(new Review("I like it"));
			course.addReview(new Review("Top class"));
			
			// Save the course and leverage the cascade ALL
			System.out.println("Saving the course...");
			session.save(course);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
		

	}

}
