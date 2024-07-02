package com.feed.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.feed.dto.RegisterDto;
import com.feed.model.Post;
import com.feed.model.Register;
import com.feed.model.Role;
import com.feed.repository.PostRepository;
import com.feed.repository.RegisterRepository;

import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Service
class RegisterServiceImpl implements RegisterService {

	@Autowired
	public RegisterRepository registerRepository;
	
	@Autowired
	PostRepository postRepository;
	
	
	
	public Register createRegister(Register register) {
		Register reg =  registerRepository.save(register);
		return reg;
	}

	 
	@Override
	public Register getRegister(long registerId) {
		    Register register = this.registerRepository.findById(registerId).orElseThrow(() -> new RuntimeException("id not found"));
		    return register;
	}

	@Override
	public List<Register> getAllRegister() {
		List<Register> register = this.registerRepository.findAll();
		return register;
	}

	@Override
	public Register updateRegister1(long registerId, Register register) {
		Register registers = this.registerRepository.findById(registerId).orElseThrow(() -> new RuntimeException("Post not found"));
		register.setUserName(register.getUserName());
		register.setEmailId(register.getEmailId());
		register.setPhoneNo(register.getPhoneNo());
		register.setRole(register.getRole());
		Register updateRegister = registerRepository.save(register);
		return updateRegister;
	}

	

	@Override
	public Register deletePost(Long id) {
		Register register = registerRepository.findById(id).orElseThrow(()->new RuntimeException("Register not found"));
		
		registerRepository.deleteById(id);
		return register;
        
	}


	@Override
	public Register findByRegisterName(String name) {
		Register register =registerRepository.findByRegisterName(name);

	    List<Post> posts = postRepository.findByRegister(register);
		return register;
	}


	@Override
	public Register updateRegister(long registerId, Register register) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
