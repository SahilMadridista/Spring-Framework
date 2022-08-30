package com.sahil.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;

public class CreateCourseDemo {

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
			
			// Get the instructor from DB
			
			int id = 2;
			
			Instructor instructor = session.get(Instructor.class, id);
			
			// Create some courses
			
			Course course1 = new Course("Passing masterclass"); 
			
			Course course2 = new Course("Let's learn dribbling");
			
			// Add courses to instructor
			
			instructor.add(course1);
			
			instructor.add(course2);
			
			// Save the courses
			
			session.save(course1);
			session.save(course2);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
		

	}

}
