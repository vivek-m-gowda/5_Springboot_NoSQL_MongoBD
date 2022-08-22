package com.example7.springbootnosqlmongodb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example7.springbootnosqlmongodb.model.Employee;
import com.example7.springbootnosqlmongodb.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/Save")
	public String saveEmployee(@RequestBody Employee employee) {
		employeeRepository.save(employee);
		return "Added a new employee with id : " +employee.getId();
	}
	
	@GetMapping("/AllEmployees")
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	
	@GetMapping("/GetById/{id}")
	public Optional<Employee> getEmployee(@PathVariable long id){
		return employeeRepository.findById(id);
	}
	
	@PutMapping("/Update/{id}")
	public Employee updateEmployee (@RequestBody Employee employee, @PathVariable ("id") long employeeId ) {
		Employee existingEmployee = this.employeeRepository.findById(employeeId)
				.orElseThrow();
		existingEmployee.setName(employee.getName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setGender(employee.getGender());
		existingEmployee.setAddress(employee.getAddress());
		return this.employeeRepository.save(existingEmployee);
		
	}
	

	
	@DeleteMapping("/Delete/{id}")
	public String deleteEmployee(@PathVariable long id) {
		employeeRepository.deleteById(id);
		return "Removed employee with id : "+id;
	}

}
