package com.feed.service;

import java.util.List;

import com.feed.dto.RegisterDto;
import com.feed.model.Register;

public interface RegisterService {
	
	Register createRegister(Register register);
	
//	Register getRegister(long registerId);
	
//	 public User createUser(User user);
	  
	    
	 public Register getRegister(long registerId);
	 
	 public List<Register> getAllRegister();
	 
	 public Register updateRegister(long registerId,Register register);
	 
	 public Register deletePost(Long id);
	 
	 public Register  findByRegisterName(String name);

	Register updateRegister1(long registerId, Register register);
	 

}
