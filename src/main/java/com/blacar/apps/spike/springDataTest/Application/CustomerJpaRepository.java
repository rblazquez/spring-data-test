package com.blacar.apps.spike.springDataTest.Application;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerJpaRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLastname(String lastname);
    
    Page<Customer> findByLastname(String lastname, Pageable pageable);
}
