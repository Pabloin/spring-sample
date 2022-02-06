package io.github.pabloin.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import io.github.pabloin.model.User;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
public class UserController {
	
	private List<User> users = new ArrayList<>();
	
	public UserController() {
		users.add(new User(1, "admin"));
		users.add(new User(2, "supervisor"));
		users.add(new User(3, "cajero"));
	}

	@GetMapping(value = "users")
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(users); 
	}
	
	@GetMapping(value = "users/{userId}")
	public ResponseEntity<?> find( @PathVariable("userId") long userId ) {
	
		User user = users.stream()
		.filter(currentUser -> currentUser.getId() == userId)
		.findFirst()
		.orElseThrow(() -> new RuntimeException("No existe el usuario"));

		return ResponseEntity.ok(user); 
	};
	
	@PutMapping(value = "users")
	public ResponseEntity<User> update(User request){
		User user = users.stream()
				.filter(currentUser -> currentUser.getId() == request.getId())
				.findFirst()
				.orElseThrow(() -> new RuntimeException("No existe el usuario"));
		user.setName(request.getName());
		return ResponseEntity.ok(user);
	}
	
	@PostMapping(value = "users")
	public ResponseEntity<User> create(User request){
		users.add(request);
		return ResponseEntity.ok(request);
	}
	
	@DeleteMapping(value = "users/{userId}")
	public ResponseEntity<?> delete( @PathVariable("userId") long userId ) {
		User user = users.stream()
		.filter(currentUser -> currentUser.getId() == userId)
		.findFirst()
		.orElseThrow(() -> new RuntimeException("No existe el usuario"));
		users.remove(user);
		return ResponseEntity.ok().build();	
	}
}