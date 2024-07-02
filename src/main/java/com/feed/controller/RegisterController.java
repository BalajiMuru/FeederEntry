package com.feed.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feed.dto.RegisterDto;
import com.feed.model.Register;
import com.feed.service.RegisterService;

@RestController
@RequestMapping("/register")
public class RegisterController {
	
	@Autowired
	RegisterService registerService;
	
	@PostMapping
	public Register createRegister(@RequestBody Register register)
	{
		return registerService.createRegister(register);
		
	}
	

	 @GetMapping("/{id}")
	    public ResponseEntity<Register> getUser(@PathVariable("id") long id){
		 Register register = this.registerService.getRegister(id);
	        return new ResponseEntity<Register>(register, HttpStatus.OK);
	    }
	
	 @GetMapping
	 public ResponseEntity<Register> getAllRegister(){
		List<Register> list = registerService.getAllRegister();
		return new ResponseEntity<Register>(HttpStatus.OK);
		 
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Register> updateRegister(@PathVariable("id") long id, @RequestBody Register register )
	 {
		Register Dto = this.registerService.updateRegister(id, register);
		return new ResponseEntity<Register>(register, HttpStatus.OK) ;
		 
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Void> deletePost(@PathVariable Long id){
		 registerService.deletePost(id);
		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	 }
	
	   
}
