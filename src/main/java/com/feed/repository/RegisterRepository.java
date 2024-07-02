package com.feed.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feed.model.Register;

public interface  RegisterRepository extends JpaRepository<Register, Long> {
	
	Register findByRegisterName(String register);

}
