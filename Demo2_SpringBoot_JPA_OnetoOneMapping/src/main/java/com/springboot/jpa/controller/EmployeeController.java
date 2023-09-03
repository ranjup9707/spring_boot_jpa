package com.springboot.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.jpa.entity.Employee;
import com.springboot.jpa.repository.EmployeeRepository;

@RestController
public class EmployeeController 
{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/saveEmployees")
	private ResponseEntity<String> saveEmployee(@RequestBody List<Employee> empData){
		employeeRepository.saveAll(empData);
		return ResponseEntity.ok("Data Saved");
	}
	
}
