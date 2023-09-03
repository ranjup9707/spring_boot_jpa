package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dto.EmployeeRequest;
import com.springboot.entity.Employee;
import com.springboot.repository.EmployeeRepository;

@Service
public class EmployeeService 
{
	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(EmployeeRequest employeeRequest) {
		Employee employee = new Employee();
		employee.setAge(employeeRequest.getAge());
		employee.setName(employeeRequest.getName());
		employee.setDesignation(employeeRequest.getDesignation());
		employee.setActive(employeeRequest.getActive());
		employee.setPhoneNumber(employeeRequest.getPhoneNumber());
		employee.setSalary(employeeRequest.getSalary());
		return employeeRepository.save(employee);
	}

	public List<Employee> getAllEmployees() {
		return employeeRepository.getAllEmployees();
	}

	public List<Employee> getEmployeeByDesignationAndStatus(boolean status, List<String> designationList) {
		return employeeRepository.getEmployeeByDesignationAndStatus(status, designationList);
	}

	public int updateEmployee(boolean status, List<Long> empList) {
		return employeeRepository.updateEmployeeStateByEmployeeId(status, empList);
	}

	public int deleteEmployee(List<Long> empListId) {
		return employeeRepository.deleteEmployee(empListId);
	}
}
