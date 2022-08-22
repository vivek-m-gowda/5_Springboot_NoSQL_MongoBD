package com.example7.springbootnosqlmongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Address {
	private String city;
	private String pincode;
}
