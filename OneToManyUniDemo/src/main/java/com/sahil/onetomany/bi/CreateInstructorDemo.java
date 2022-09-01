package com.sahil.onetomany.bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.sahil.hibernate.entity.Student;
import com.sahil.mapping.entity.Course;
import com.sahil.mapping.entity.Instructor;
import com.sahil.mapping.entity.InstructorDetail;

public class CreateInstructorDemo {

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
			
			// Object creation
			
			Instructor instructor = new Instructor("Lionel",
					"Messi", "lm10@gmail.com"); 
			
			InstructorDetail instructorDetail = 
					new InstructorDetail("lm10Academy", "playmaker");
			
			// Associate the objects
			
			instructor.setInstructorDetail(instructorDetail);
			
			// Start a transaction
			session.beginTransaction();
			
			System.out.println("Saving the instructor : " + instructor);
			// Save the object - This will also save the instructorDetails because of cascade
			session.save(instructor);
			
			// Commit transaction
			session.getTransaction().commit();
			
			System.out.println("Instructor saved.");
			
		}finally {
			
			session.close();
			factory.close();
			
		}
		

	}

}
