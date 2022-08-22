package com.example7.springbootnosqlmongodb.model;


import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.Data;
import lombok.ToString;

@Data
@ToString

@Document ("employee")
public class Employee {
	
	@Id
	private long id;
	
	private String name;
	private String email;
	private Gender gender;
	private Address address;
	private LocalDateTime createdTime;

}
