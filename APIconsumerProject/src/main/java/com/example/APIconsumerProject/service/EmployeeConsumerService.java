package com.example.APIconsumerProject.service;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;


@Service
public class EmployeeConsumerService {
	
	private final RestTemplate restTemplate;
	
	 @Autowired
	 public EmployeeConsumerService(RestTemplate restTemplate) 
	 {
		 this.restTemplate = restTemplate;
	 }
	 
	 
	 public String allEmployeeDetails(String authHeader) 
	 {
		 String url = "http://localhost:8080/employees";
		 
		 HttpHeaders headers = new HttpHeaders();
		 headers.set("Authorization", authHeader);
		 
		 HttpEntity<String> entity = new HttpEntity<>(headers);
		 
		 return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();    
	 }
	 
	 public String getEmployeeDetails(int id) 
	 {
		 String url = "http://localhost:8080/employees/"+id;
	     return restTemplate.getForObject(url, String.class,id);    
	 }
	 
	 public String getHello(String authHeader)
	 {
		 String url = "http://localhost:8080/employees/hello";
		 
		 HttpHeaders headers = new HttpHeaders();
		 headers.set("Authorization", authHeader);
		 
		 HttpEntity<String> entity = new HttpEntity<>(headers);
		 
		 return restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	 }
	 
	 public ResponseEntity<Map> getLogin(String username, String password)
	 {
		 String url = "http://localhost:8080/login";
		 
		 HttpHeaders headers = new HttpHeaders();
	     headers.set("Content-Type", "application/json");
	     
	     Map<String, String> body = new HashMap<>();
	        body.put("username", username);
	        body.put("password", password);
	        
	     HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(body, headers);
	     
	     ResponseEntity<Map> response = restTemplate.exchange(
	              	url,
	                HttpMethod.POST,
	                requestEntity,
	                Map.class
	        );
		 return response;
	 }

}
