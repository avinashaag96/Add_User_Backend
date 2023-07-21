package com.example.Project_M.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project_M.entity.User;
import com.example.Project_M.exception.UserNotFoundException;
import com.example.Project_M.repositories.UserRepository;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

	@Autowired
	private UserRepository userRepo;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser){
		
		return userRepo.save(newUser);
	}
	
	@GetMapping("/users")
	List<User>getAllUsers(){
		return userRepo.findAll();
	}
	
	@GetMapping("/user/{id}")
	User getUserById(@PathVariable Integer id){
	  return userRepo.findById(id)
			  .orElseThrow(()->new UserNotFoundException(id));
	}
	
	@PutMapping("/user/{id}")
	User updateUser(@RequestBody User newUser,@PathVariable Integer id){
		return userRepo.findById(id)
				.map(user->{
			    user.setUsername(newUser.getUsername());
			    user.setName(newUser.getName());
			    user.setEmail(newUser.getEmail());
			    return userRepo.save(user);
		}).orElseThrow(()->new UserNotFoundException(id));
		
	}
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable Integer id){
		if(!userRepo.existsById(id)){
			throw new UserNotFoundException(id);
		}
		userRepo.deleteById(id);
		return "User with id "+id+" has been deleted succesfully.";
	}
	
}
