package com.example7.springbootnosqlmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example7.springbootnosqlmongodb.model.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Long>{
	

}
