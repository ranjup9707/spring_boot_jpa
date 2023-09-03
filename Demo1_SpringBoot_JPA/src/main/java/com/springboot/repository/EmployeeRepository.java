package com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.entity.Employee;

import jakarta.transaction.Transactional;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	@Query("select e from Employee e")
	List<Employee> getAllEmployees();

	//Name Parameters
	@Query("select e from Employee e where e.active=:status and e.designation in :designationList")
	List<Employee> getEmployeeByDesignationAndStatus(@Param("status") boolean status, 
													 @Param("designationList") List<String> designationList);
	
	//Index Parameters
	@Transactional
	@Modifying //This is not a select query but a DML query. This annotation can have int, Integer or void as return type
	@Query("update Employee e set e.active=?1 where e.empId in ?2")
	//The return type int is the no of records updated
	int updateEmployeeStateByEmployeeId(boolean active, List<Long> empIdList);
	
	@Transactional
	@Modifying
	@Query("delete from Employee e where e.empId in ?1")
	int deleteEmployee(List<Long> empIdList);
}
