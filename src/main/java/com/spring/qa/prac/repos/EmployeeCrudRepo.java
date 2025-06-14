package com.spring.qa.prac.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.qa.prac.entity.Employee;

@Repository
public interface EmployeeCrudRepo extends JpaRepository<Employee, Long> {
	public List<Employee> findAll();
}
