package com.InterviewSpringboot.springbootproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InterviewSpringboot.springbootproject.Service.EmployeeService;
import com.InterviewSpringboot.springbootproject.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@GetMapping(value="get")
	public String get()
	{
		return "Welcome employee";
	}
	
	@Autowired	
	private EmployeeService employeeService;
	
	@GetMapping(value="saveEmployee")
	public Employee saveEmployee()
	{
		return employeeService.employeeSave();
	}
}
