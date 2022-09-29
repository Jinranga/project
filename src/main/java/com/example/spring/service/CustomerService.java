package com.example.spring.service;

import java.util.List;

import com.example.spring.entity.Customer;

public interface CustomerService
{
	 Customer createProduct(Customer customer);
	  Customer updateProduct(Customer  customer);
	   
	   List<Customer> getAllProduct();
	   Customer getProductById(long productId);
	   void deleteProduct(long id);
}
