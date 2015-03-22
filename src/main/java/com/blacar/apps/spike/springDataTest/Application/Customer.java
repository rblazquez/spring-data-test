package com.blacar.apps.spike.springDataTest.Application;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue
	Long id;

	String firstname, lastname;
	
	public Customer() {}
	
	public Customer(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}
}
