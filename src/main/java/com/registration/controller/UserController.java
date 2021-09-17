package com.registration.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.registration.model.User;
import com.registration.repositorie.UserRepository;

@CrossOrigin( origins = "*")
@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping(produces = "application/json")
	public ResponseEntity<User> getAll(){
		List<User> list = userRepository.findAll();
		
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<User> getId(@PathVariable("id") String id){
		Optional<User> listId = userRepository.findById(id);
		
		return new ResponseEntity<User>(listId.get(), HttpStatus.OK);
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<User> post(@RequestBody User user){
		User saveUser = userRepository.save(user);
		
		return new ResponseEntity<User>(saveUser, HttpStatus.OK);
	}	
	
	@DeleteMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<User> delete(@PathVariable("id") String id){
		   userRepository.deleteById(id);
		
		return new ResponseEntity<User>(HttpStatus.OK);
	}
}
































