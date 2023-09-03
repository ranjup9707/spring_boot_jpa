package com.springboot.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_mapping_jpa_tbl")
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employee_id")
	private Long empId;
	private String empName;
	private Integer empAge;
	// OneToOne annotation will create a foreign key column in my employee class with name address_address_id
	@OneToOne(cascade = CascadeType.ALL) //When employee data is saved then it saved address data as well
	//@JoinColumn(name = "fk_address_id") // If custom name is required and not default name which is address_address_id
	private Address address;
}
