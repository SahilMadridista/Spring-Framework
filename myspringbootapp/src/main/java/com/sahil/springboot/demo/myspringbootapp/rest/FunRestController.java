package com.sahil.springboot.demo.myspringbootapp.rest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// Expose "/" that return "Hello World"

	@GetMapping("/")
	public String sayHello() {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		LocalDateTime now = LocalDateTime.now();

		String msg = "The date and time on server is: " + dtf.format(now);

		return "Hello World! " + msg;
	}

}
