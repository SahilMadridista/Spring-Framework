package com.sahil.hibernate.entity;

import java.sql.Connection;
import java.sql.DriverManager;

public class App {
	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";

		String user = "hbstudent";

		String pass = "hbstudent";

		try {

			System.out.println("Connecting to database: " + jdbcUrl);

			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);

			System.out.println("Connection successful !!!");

			myConn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
