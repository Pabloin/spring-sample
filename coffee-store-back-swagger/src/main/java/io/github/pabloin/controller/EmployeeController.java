package io.github.pabloin.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.pabloin.model.Employee;
import io.github.pabloin.model.User;

// import in.bushansirgur.springboot.repository.Employeemployeessitory;

@RestController
public class EmployeeController {
	
    private List<Employee> employees = new ArrayList<>();
	
    public EmployeeController() {
        this.employees = new ArrayList<>();
        this.employees.add(new Employee(0, "Hello World!"));
        this.employees.add(new Employee(1, "Welcome to Coffee Store!"));
    }

	
	// @PostMapping("/employees")
	// public Employee save (@RequestBody Employee employee) {
	// 	return employees.save(employee);
	// }
	
	// @GetMapping("/employees")
	// public List<Employee> get () {
	// 	return employees.findAll();
	// }
	
	// @GetMapping("/employees/{id}")
	// public Employee get (@PathVariable Long id) {
	// 	Optional<Employee> employee = employees.findById(id);
	// 	if (employee.isPresent()) {
	// 		return employee.get();
	// 	}
	// 	throw new RuntimeException("Not found for the id "+id);
	// }
	
	// @PutMapping("/employees/{id}")
	// public Employee update (@PathVariable Long id, @RequestBody Employee employee) {
	// 	employee.setId(id);
	// 	return employees.save(employee);
	// }
	
	// @DeleteMapping("/employees/{id}")
	// public ResponseEntity<HttpStatus> delete (@PathVariable Long id) {
	// 	employees.deleteById(id);
	// 	return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	// }
}