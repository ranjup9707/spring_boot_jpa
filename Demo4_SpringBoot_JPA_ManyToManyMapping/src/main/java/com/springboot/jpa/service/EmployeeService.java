package com.springboot.jpa.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.jpa.entity.Employee;
import com.springboot.jpa.entity.Project;
import com.springboot.jpa.repository.EmployeeRepository;
import com.springboot.jpa.repository.ProjectRepository;

@Service
public class EmployeeService 
{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ProjectRepository projectRepository;

	public void saveEmployee(Employee empData) {
		employeeRepository.save(empData);
	}
	
	public List<Employee> getEmployeeDetails(Long empId){
		if(null != empId) {
			return employeeRepository.findAllByEmpId(empId);
		}
		else {
			return employeeRepository.findAll();
		}
	}

	public void deleteEmployee(Long empId) {
		employeeRepository.deleteById(empId);
	}

	public Employee assignProjectToEmployee(Long empId, Long projectId) {
		Employee employee = employeeRepository.findById(empId).get();
		Project project = projectRepository.findById(projectId).get();
		Set<Project> projectAssigned = employee.getProjects();
		projectAssigned.add(project);
		employee.setProjects(projectAssigned);
		return employeeRepository.save(employee);
	}
	
}
