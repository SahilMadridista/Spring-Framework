package com.sahil.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;
import com.sahil.mapping.entity.Review;

public class GetCoursesForStudent {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get student from the DB
			Student student = session.get(Student.class, 3);
			
			System.out.println("Student loaded " + student + student.getCourses());
			
			// Create more courses
			
			Course c1 = new Course("Real Madrid Academy");
			Course c2 = new Course("Learn dribbling");
			
			// Add student to course
			
			c1.addStudent(student);
			c2.addStudent(student);
			
			// Save the courses
			System.out.println("Saving the course...");
			session.save(c1);
			session.save(c2);
			
			System.out.println("Course saved...");
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
		

	}

}
