package com.springboot.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee_jpa_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	private String name;
	private Integer age;
	private Boolean active = true;
	private Long phoneNumber;
	private String designation;
	private Double salary;
	
}
