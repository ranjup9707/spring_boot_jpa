package com.springboot.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.jpa.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>
{
	
	@Query("select p from Project p where projectId=:projectId")
	List<Project> findAllByProjectId(Long projectId);

}
