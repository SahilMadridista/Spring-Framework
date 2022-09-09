package com.sahil.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;
import com.sahil.mapping.entity.Review;

public class CreateCourseAndStudents {

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
			
			// Create a course
			
			Course course1 = new Course("How to be best at football");
			
			// Save the course and leverage the cascade ALL
			System.out.println("Saving the course...");
			session.save(course1);
			System.out.println("Save complete: " + course1);
			
			// Create student
			
			Student stu1 = new Student("Karim","Benzema","kb9@gmail.com");
			Student stu2 = new Student("Luka","Modric","lm10@gmail.com");
			
			// Add student to course
			course1.addStudent(stu1);
			course1.addStudent(stu2);
			
			// Save student
			System.out.println("Saving the students...");
			session.save(stu1);
			session.save(stu2);
			
			System.out.println("Saved students: " + course1.getStudents());
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
		

	}

}
