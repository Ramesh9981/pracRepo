package com.spring.qa.prac.service;

import java.util.List;

import com.spring.qa.prac.entity.Employee;

public interface EmployeeServiceInterface {
	public Employee addEmployee(Employee emp);
	public List<Employee> getAllEmployees();
	public Employee getEmpById(Long empId);
	public void delByEmpId(Long empId);
}
