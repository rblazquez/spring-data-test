package com.blacar.apps.spike.springDataTest.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

@SpringBootApplication
@ComponentScan({ "com.blacar.apps.spike.springDataTest.*" })
public class Application implements CommandLineRunner {

	@Autowired
	CustomerJpaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class);
	}

	@Override
	public void run(String... strings) throws Exception {
		// save a couple of customers
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer by ID
		Customer customer = repository.findOne(1L);
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		// fetch customers by last name
		System.out.println("Customer found with findByLastName('Bauer'):");
		System.out.println("--------------------------------------------");
		for (Customer bauer : repository.findByLastname("Bauer")) {
			System.out.println(bauer);
		}

		// fetch all customers PAGED
		System.out.println("Customers PAGED:");
		System.out.println("-------------------------------");

		Page<Customer> users = repository.findAll(new PageRequest(0, 4));
		System.out.println("Number: " + users.getNumber());
		System.out.println("Number of elements: " + users.getNumberOfElements());
		System.out.println("Total elements: " + users.getTotalElements());
		System.out.println("Total pages: " + users.getTotalPages());
		System.out.println("Size: " + users.getSize());
		for (Customer user : users.getContent()) {
			System.out.println(user);
		}
		
		// fetch all customers PAGED
		System.out.println("First 2 Customers PAGED:");
		System.out.println("-------------------------------");

		users = repository.findByLastname("Bauer", new PageRequest(0, 1));
		System.out.println("Number: " + users.getNumber());
		System.out.println("Number of elements: " + users.getNumberOfElements());
		System.out.println("Total elements: " + users.getTotalElements());
		System.out.println("Total pages: " + users.getTotalPages());
		System.out.println("Size: " + users.getSize());
		for (Customer user : users.getContent()) {
			System.out.println(user);
		}

		System.out.println();
	}
}
