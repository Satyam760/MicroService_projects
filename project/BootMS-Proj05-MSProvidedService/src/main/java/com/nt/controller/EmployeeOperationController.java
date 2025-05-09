package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emp")
public class EmployeeOperationController {
	
	@Value("${dbuser}")
	private String user;
	@Value("${dbpwd}")
	private String pass;
	
	@GetMapping("/show")
	public String showData() {
		return "Data collected through Config Server :: "+user+"----"+pass;
	}
	

}
