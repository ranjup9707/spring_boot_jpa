package com.springboot.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.jpa.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
