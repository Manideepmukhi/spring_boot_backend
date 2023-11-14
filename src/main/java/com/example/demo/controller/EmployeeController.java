package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.resource_not_found_exception;
import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("springbootbackend-production-24b9.up.railway.app")
@ComponentScan(basePackages={"com.example.repository"})
public class EmployeeController{
	
  @Autowired
  private EmployeeRepository employeeRepository;

  //get all employee
  @GetMapping("/employees")
  public List<Employee> getAllEmployees()
  {
	  return employeeRepository.findAll();
  }
  //create employee rest api 
  @PostMapping("/employees")
  public Employee createEmployee(@RequestBody Employee employee)
  {
	  return employeeRepository.save(employee);
  }
  //get employee by id rest api
  @GetMapping("/employees/{id}")
  public ResponseEntity<Employee> getEmoployeeId(@PathVariable Long id)
  {
	  Employee employee=employeeRepository.findById(id).orElseThrow(() -> new resource_not_found_exception("Employee not exists with id:" +id));
	  return ResponseEntity.ok(employee);
			  }
  // update employee rest API
  @PutMapping("/employees/{id}")
  public ResponseEntity<Employee> updateEmoployee(@PathVariable Long id,@RequestBody Employee employeeDetails)
  {
	  Employee employee=employeeRepository.findById(id).orElseThrow(() -> new resource_not_found_exception("Employee not exists with id:" +id));
	  employee.setFirstname(employeeDetails.getFirstname());
	  employee.setLastname(employeeDetails.getLastname());
	  employee.setEmailId(employee.getEmailId());
	  
	 Employee updateEmployee= employeeRepository.save(employee);
	  return ResponseEntity.ok(updateEmployee);
	  
			  }
  //delete employee rest api
  @DeleteMapping("/employees/{id}")
  public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id)
  {
	  Employee employee=employeeRepository.findById(id).
			  orElseThrow(() -> new resource_not_found_exception("Employee not exists with id:" +id));
	  employeeRepository.delete(employee);
	  Map<String, Boolean> response =new HashMap<>();
	  response.put("deleted", Boolean.TRUE);
	  return ResponseEntity.ok(response);
  }
}
