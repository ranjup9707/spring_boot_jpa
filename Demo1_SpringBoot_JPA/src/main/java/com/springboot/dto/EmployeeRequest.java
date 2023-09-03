package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest 
{
	private String name;
	private Integer age;
	private Boolean active;
	private String designation;	
	private Long phoneNumber = (long)(Math.random()*Math.pow(10, 10));
	private Double Salary = Math.random()*100000;
}
