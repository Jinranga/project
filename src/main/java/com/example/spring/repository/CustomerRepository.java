package com.example.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>{
	
	

}
