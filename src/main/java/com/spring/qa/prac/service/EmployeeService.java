package com.spring.qa.prac.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.qa.prac.custom.exceptiom.BusinessException;
import com.spring.qa.prac.entity.Employee;
import com.spring.qa.prac.repos.EmployeeCrudRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	EmployeeCrudRepo empCrud;

	@Override
	public Employee addEmployee(Employee emp) {

		if (emp.getName().isEmpty() || emp.getName().length() == 0) {
			throw new BusinessException("601", "Please send a valid Employee Name");
		}

		try {
			Employee savedEmployee = empCrud.save(emp);
			return savedEmployee;
		} catch (IllegalArgumentException ex) {
			throw new BusinessException("602", "Given Employee is null, Need valid Employee");
		} catch (Exception ex) {
			throw new BusinessException("603", "Something is wrong in Service layer");
		}

	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			List<Employee> allEmp = empCrud.findAll();

			if (allEmp.isEmpty()) {
				throw new BusinessException("604", "List is Empty, we don't have any employees ");
			}
			return allEmp;
		} catch (Exception e) {
			throw new BusinessException("603",
					"Something is wrong in Service layer when fetching all employees" + e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmpById(Long empId) {
		try {
			Employee emp = empCrud.findById(empId).get();
			return emp;
		} catch (IllegalArgumentException ex) {
			throw new BusinessException("602", "Given Employee is null, Need valid Employee to be searched");
		} catch (NoSuchElementException e) {
			throw new BusinessException("607", "No Such Element Exist in the Data Base" + e.getMessage());
		}
	}

	@Override
	public void delByEmpId(Long empId) {
		try {
			empCrud.deleteById(empId);
		} catch (IllegalArgumentException ex) {
			throw new BusinessException("602", "Given Employee is null, Need valid Employee to be searched");
		} catch (NoSuchElementException e) {
			throw new BusinessException("607", "No Such Element Exist in the Data Base" + e.getMessage());
		}
	}

}
