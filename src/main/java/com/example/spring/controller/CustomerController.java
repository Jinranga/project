package com.example.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.entity.Customer;
import com.example.spring.service.CustomerService;



@RestController

public class CustomerController {
	@Autowired
	private CustomerService  customerService;
	
	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllProduct(){
		return ResponseEntity.ok().body(customerService.getAllProduct());
		
	}
	
	@GetMapping("/customers/{id}")
	public ResponseEntity<Customer> getProductById(@PathVariable long id){
		return ResponseEntity.ok().body(customerService.getProductById(id));
	}
	@PostMapping("/customers")
	public ResponseEntity<Customer> createProduct(@RequestBody Customer customer){
		return ResponseEntity.ok().body(this.customerService.createProduct(customer));
	}
	@PutMapping("/customers/{id}")
	public ResponseEntity<Customer> updateProduct(@PathVariable Long id, @RequestBody Customer customer){
		customer.setId(id);
		return ResponseEntity.ok().body(this.customerService.updateProduct(customer));
	}
	@DeleteMapping("/customers/{id}")
	public HttpStatus deleteProduct(@PathVariable long id)
	{
		this.customerService.deleteProduct(id);
		return HttpStatus.OK;
	}
	

	

}
