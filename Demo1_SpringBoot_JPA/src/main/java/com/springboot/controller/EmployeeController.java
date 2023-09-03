package com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.EmployeeRequest;
import com.springboot.entity.Employee;
import com.springboot.service.EmployeeService;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController 
{
	@Autowired 
	private EmployeeService employeeService;
	 
	@PostMapping
	public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
		return employeeService.createEmployee(employeeRequest);
	}
	
	@GetMapping
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/{status}/{designationList}")
	public List<Employee> getEmployeeByDesignationAndStatus(@PathVariable boolean status, @PathVariable List<String> designationList){
		return employeeService.getEmployeeByDesignationAndStatus(status, designationList);
	}
	
	@PutMapping("/{status}/{empIdList}")
	public int updateEmployee(@PathVariable boolean status, @PathVariable List<Long> empIdList) {
		return employeeService.updateEmployee(status, empIdList);
	}
	
	@DeleteMapping("/{empIdList}")
	public int deleteEmployee(@PathVariable List<Long> empIdList) {
		return employeeService.deleteEmployee(empIdList);
	}
	
}
