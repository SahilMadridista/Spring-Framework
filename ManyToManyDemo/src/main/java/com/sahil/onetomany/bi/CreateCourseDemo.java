package com.sahil.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;
import com.sahil.mapping.entity.Review;

public class CreateCourseDemo {

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
			
			// Get the instructor from DB
			
			int id = 1;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			// Create some courses
			
			// Course course1 = new Course("Passing masterclass"); 
			
			// Course course2 = new Course("Let's learn dribbling");
			
			// So now we have already created a course and reviews using the OneToManyUniDemo but it is not linked with the instructor. So here we will fetch the course and add it to the instructor.
			
			int courseId = 11;
			
			Course course = session.get(Course.class, courseId);
			
			// Add courses to instructor
			
			instructor.add(course);
			
			// instructor.add(course2);
			
			// Save the courses
			
			session.save(course);
			// session.save(course2);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
		

	}

}
