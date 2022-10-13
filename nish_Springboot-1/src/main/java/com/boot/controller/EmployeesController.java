package com.boot.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Employees;
import com.boot.exception.ResourceNotFoundException;
import com.boot.repository.EmployeesRepo;



@RestController
@RequestMapping("/api/v1/")
public class EmployeesController {

	Logger logger = LoggerFactory.getLogger(EmployeesController.class);
	
	@Autowired
	EmployeesRepo employeesRepo;
	
	
	// get all employees
	@GetMapping("/allemp")
	public List<Employees> getAllEmployees(){
		logger.info("GET ALL Employee .....getAllEmployees");
		return  employeesRepo.findAll();
	}
	
	
	  
	  
	//Save Employee
	@PostMapping("/employees")
	public Employees createEmp(@RequestBody Employees employees) {
		System.out.println("Model Data..........."+employees);
		logger.info("Save Employee................createEmp");
		System.out.println("Model Data..........."+employees);
		return employeesRepo.save(employees);
	}
	
	
	    // get employee by id rest api
		@GetMapping("/employees/{id}")
		public ResponseEntity<Employees> getEmployeeById(@PathVariable Long id) {
			logger.info("Get Employee by ID ...........getEmployeeById");
			Employees employees = employeesRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			return ResponseEntity.ok(employees);
		}
		
		
		
		// update employee rest api		
		@PutMapping("/employees/{id}")
		public ResponseEntity<Employees> updateEmployee(@PathVariable Long id, @RequestBody Employees employeeDetails){
			logger.info("Update Employee .........updateEmployee");
			Employees employee = employeesRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			employee.setFirstName(employeeDetails.getFirstName());
			employee.setLastName(employeeDetails.getLastName());
			employee.setEmailId(employeeDetails.getEmailId());
			
			Employees updatedEmployee = employeesRepo.save(employee);
			return ResponseEntity.ok(updatedEmployee);
		}
		
		
		
		// delete employee rest api
		@DeleteMapping("/employees/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
			logger.info("Delete Employee ..........deleteEmployee");
			Employees employee = employeesRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
			
			employeesRepo.delete(employee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return ResponseEntity.ok(response);
		}
}
