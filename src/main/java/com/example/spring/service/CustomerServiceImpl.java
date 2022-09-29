package com.example.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.spring.entity.Customer;
import com.example.spring.exception.CustomerException;
import com.example.spring.repository.CustomerRepository;


@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{
   
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer createProduct(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer updateProduct(Customer customer) {
		Optional<Customer> customerDb =this.customerRepository.findById(customer.getId());
		if(customerDb.isPresent()) {
			Customer customerUpdate = customerDb.get();
			customerUpdate.setId(customer.getId());
			customerUpdate.setName(customer.getName());
			customerUpdate.setLocation(customer.getLocation());
			customerRepository.save(customer);
			return customerUpdate;
		}else
		{
			throw new CustomerException("Record not found with id:" +customer.getId());
		}
		
			
	}

	@Override
	public List<Customer> getAllProduct() {
		// TODO Auto-generated method stub
		return this.customerRepository.findAll();
	}

	@Override
	public Customer getProductById(long customerId) {
		Optional<Customer> customerDb= this.customerRepository.findById(customerId);
		
		if(customerDb.isPresent()) {
			return customerDb.get();
			
		}else {
			throw new CustomerException("record not found with id:" +customerId);
		}
		
		
	}
	

	@Override
	public void deleteProduct(long productId) {
Optional<Customer> productDb= this.customerRepository.findById(productId);
		
		if(productDb.isPresent()) {
			this.customerRepository.delete(productDb.get());
			
		}else {
			throw new CustomerException("record not found with id:" +productId);
		}
		
		
	}
}
