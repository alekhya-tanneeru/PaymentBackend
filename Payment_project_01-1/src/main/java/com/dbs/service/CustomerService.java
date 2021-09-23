package com.dbs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Customer;
import com.dbs.repo.CustomerRepo;


@Service
public class CustomerService implements ICustomerService {

	@Autowired
	CustomerRepo custumerRepo;
	
	
	@Override
	public Customer findByIdCust(String id) {
		Optional<Customer> optCustomer=custumerRepo.findById(id);
		if(optCustomer.isPresent()) {
		return custumerRepo.findById(id).get();
		}
		return new Customer("400","",0.0,"","");
	}
	
	@Override
	public List<Customer> findCustomer(String u) {
		return custumerRepo.findAllByType(u);
	}
	
	
	
}
