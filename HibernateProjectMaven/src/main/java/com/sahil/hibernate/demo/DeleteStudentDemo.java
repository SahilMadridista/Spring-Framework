package com.sahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		
		try {
			
			int id = 3;
			
			// Use the session to delete the java object
			
			System.out.println("Deleting student with ID " + id);
			
			// Start a transaction
			session.beginTransaction();

			Student stu = session.get(Student.class, id);
			
			session.delete(stu);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Object deleted.");
			
		}finally {
			
			factory.close();
			
		}
		

	}

}
