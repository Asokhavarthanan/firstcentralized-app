package com.InterviewSpringboot.springbootproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

	@GetMapping(value = "get")
	public String get() {
		return "Welcome boy";
	}

	@GetMapping(value = { "/pathVariable/", "/pathVariable/{firstName}/{lastName}" })
	public String getPathVariable(@PathVariable(value = "firstName") String firstName
			,@PathVariable(value = "lastName", required = false) String lastName) {
		return "Welcome " + firstName+ " "+lastName;
	}
	
	
	/*
	 * @GetMapping(value = { "/pathVariable/", "/pathVariable/{firstName}" }) public
	 * String getPathVariable(@PathVariable Optional<String> firstName) {
	 * 
	 * if (firstName.isPresent()) { return "Welcome " + firstName.get(); } else {
	 * return "Welcome Nobody"; }
	 * 
	 * }
	 */

	@GetMapping(value = "requestParam")
	public String getRequestParam(@RequestParam String name) {
		return "Welcome " + name;
	}
}