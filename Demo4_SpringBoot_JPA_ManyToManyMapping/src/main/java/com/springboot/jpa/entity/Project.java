package com.springboot.jpa.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity	
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "project_mapping_jpa_tbl")
public class Project 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "project_id")
	private Long projectId;
	private String projectName;
	/*
	 * In Many-to-Many relationship there is Circular Reference Problem In Employee
	 * will have set of project and Project has set of Employee and which can result
	 * into Stack Overflow issue when converting POJO object to JSON 
	 * and thus to break chain @JsonIgnore is used.
	 */
	@JsonIgnore
	@ManyToMany(mappedBy = "projects")
	private Set<Employee> employees = new HashSet<>();
}
