package com.blacar.apps.spike.springDataTest.Application;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastname(String lastname);

}
