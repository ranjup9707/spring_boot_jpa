package com.springboot.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
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
	@ManyToMany
	/*
	 * Internally it creates a join table between employee and project entity. This
	 * table will have 2 column one for employee id and another for project id.
	 * If custom name is to passed for the Join Table then will use @JoinTable else default table will be created.
	 */
	@JoinTable(name = "employee_project_jpa_tbl",
			   joinColumns = {@JoinColumn(name = "emp_id", referencedColumnName = "employee_id")},
			   inverseJoinColumns = {@JoinColumn(name = "proj_id", referencedColumnName = "project_id")}
	)
	private Set<Project> projects = new HashSet<>(); //Set is used to avoid assigning duplicate project to a employee
}
