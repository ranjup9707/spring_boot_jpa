package com.springboot.jpa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_emp_id", referencedColumnName = "employee_id")
	private List<Address> address;
}
