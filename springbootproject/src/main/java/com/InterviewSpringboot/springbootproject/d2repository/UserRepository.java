package com.InterviewSpringboot.springbootproject.d2repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.InterviewSpringboot.springbootproject.d2model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
