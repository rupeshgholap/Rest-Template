package com.example.APIconsumerProject.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.APIconsumerProject.service.EmployeeConsumerService;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {
	
	private final EmployeeConsumerService employeeConsumerService;
	
	@Autowired
	public ConsumerController(EmployeeConsumerService employeeConsumerService)
	{
		this.employeeConsumerService = employeeConsumerService;
	}
	
	 @GetMapping("employee/{id}")
	 public String fetchEmployeeDetails(@PathVariable("id") int id) 
	 {
	     return employeeConsumerService.getEmployeeDetails(id);  
	 }
	 
	 @GetMapping("/employee/all")
	 public String allEmployee(@RequestHeader("Authorization") String authHeader)
	 {
		 return employeeConsumerService.allEmployeeDetails(authHeader);
	 }
	 
	 @GetMapping("employee/helloo")
	 public String getHello(@RequestHeader("Authorization") String authHeader)
	 {
		 return employeeConsumerService.getHello(authHeader);
	 }
	 
	 @PostMapping("/login")
	    public ResponseEntity<Map> login(@RequestParam("username") String username, @RequestParam("password") String password) {
	        return employeeConsumerService.getLogin(username, password);
	    }

}
