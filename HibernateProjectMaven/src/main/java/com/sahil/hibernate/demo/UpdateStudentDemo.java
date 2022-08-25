package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			// Use the session to update the java object
			System.out.println("----Updating student object----");
			
			int id = 1;
			
			System.out.println("Entered student's ID is : "+ id);
			
			// Start a transaction
			session.beginTransaction();
			
			System.out.println("Getting student with ID " + id);
			
			Student stu = session.get(Student.class, id);
			
			System.out.println("Student details with ID " + id);
			
			System.out.println(stu);
			
			System.out.println("Updating student with ID " + id);
			
			stu.setEmail("sr4@rm.com");
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Object updated.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
