package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON  file and map/convert to Java POJO: 
			// data/sample-lite.json
			
			Student theStudent = mapper.readValue(
						new File("data/sample-full.json"), Student.class);
			
			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			
			// Print address
			
			Address theAddress = theStudent.getAddress();
			
			System.out.println("Street: " + theAddress.getStreet());
			System.out.println("City: " + theAddress.getCity());
			System.out.println("State: " + theAddress.getState());
			System.out.println("Zip: " + theAddress.getZip());
			System.out.println("Country: " + theAddress.getCountry());
			
			// Print the languages array
			
			for(String lang: theStudent.getLanguages()) {
				System.out.println(lang);
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}




