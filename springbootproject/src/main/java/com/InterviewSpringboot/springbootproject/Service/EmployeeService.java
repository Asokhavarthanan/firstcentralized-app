package com.InterviewSpringboot.springbootproject.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.InterviewSpringboot.springbootproject.d2model.User;
import com.InterviewSpringboot.springbootproject.d2repository.UserRepository;
import com.InterviewSpringboot.springbootproject.model.Employee;
import com.InterviewSpringboot.springbootproject.repository.EmployeeRepository;

@Component
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Employee employeeSave()
	{
		Employee emp = new Employee();		
		emp.setId(4);
		emp.setName("Ashok");
		emp.setRole("LTC");
		
		employeeRepository.save(emp);
		
		
		User user = new User();
		user.setId(1);
		user.setName("Ashok");
		user.setRole("LTC");
		userRepository.save(user);
		
		return emp;
	}
}
