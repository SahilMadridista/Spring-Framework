package com.sahil.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

	// Need a controller method to show the initial form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	// Need a controller method to process the HTML form
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	
	// Need a controller method to read form data and add data to model
	
//	@RequestMapping("/processFormTwo")
//	public String letsShout(HttpServletRequest request, Model model) {
//		
//		// Read the request name from the HTML form
//		String name = request.getParameter("studentName");
//		
//		// Convert name to upper case
//		name = name.toUpperCase();
//		
//		// Create a message
//		String result = "Yo!! " + name;
//		
//		// Add message to model
//		model.addAttribute("msg",result);
//		
//		return "helloworld";
//		
//	}
	
	@RequestMapping("/processFormTwo")
	public String letsGo(@RequestParam("studentName") String name, Model model) {
		
		String res = "Hello !! " + name.toUpperCase();
		
		model.addAttribute("msg",res);
		
		return "helloworld";
	}
	
	
	
}
