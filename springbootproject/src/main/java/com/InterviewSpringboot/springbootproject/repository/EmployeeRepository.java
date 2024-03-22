package com.InterviewSpringboot.springbootproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InterviewSpringboot.springbootproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
