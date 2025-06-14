package com.spring.qa.prac.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.qa.prac.custom.exceptiom.BusinessException;
import com.spring.qa.prac.custom.exceptiom.ControllerException;
import com.spring.qa.prac.entity.Employee;
import com.spring.qa.prac.repos.EmployeeCrudRepo;
import com.spring.qa.prac.service.EmployeeServiceInterface;

@RestController
@RequestMapping("/prac")
public class EmployeeController {

	@Autowired
	EmployeeCrudRepo empCrud;

	@Autowired
	EmployeeServiceInterface emp;

	@GetMapping("/allEmployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		try {
		 	System.out.println("All Employees are getting");
			List<Employee> allEmps = emp.getAllEmployees();
			return new ResponseEntity<List<Employee>>(allEmps, HttpStatus.OK);
		} catch (BusinessException e) {
			ControllerException ce = new ControllerException(e.getErrorCode(), e.getErrorMsg());
			return new ResponseEntity(ce, HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			ControllerException ce = new ControllerException("611", "Something went wrong in controller");
			return new ResponseEntity(ce, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addEmployee")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = emp.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}

	@GetMapping("/emp/{empid}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("empid") Long empid) {
		Employee empById = emp.getEmpById(empid);
		return new ResponseEntity<Employee>(empById, HttpStatus.OK);
	}

	@DeleteMapping("/emp/{id}")
	public ResponseEntity<Void> deleteEmployeeByid(@PathVariable("id") Long id) {
		emp.delByEmpId(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = emp.addEmployee(employee);
		return new ResponseEntity<Employee>(savedEmployee, HttpStatus.CREATED);
	}
}
