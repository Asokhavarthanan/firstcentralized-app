package com.InterviewSpringboot.springbootproject.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@Column(name = "empid")
	private int id;
	
	@Column(name = "empname")
	private String name;
	
	@Column(name = "emprole")
	private String role;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
