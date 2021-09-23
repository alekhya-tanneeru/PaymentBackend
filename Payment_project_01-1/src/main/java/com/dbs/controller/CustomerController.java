package com.dbs.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.beans.Customer;
import com.dbs.service.ICustomerService;
import com.dbs.service.ITransactionService;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class CustomerController {

	@Autowired
	ICustomerService customerService;
	
	@GetMapping(value="customer/{id}")
	public  ResponseEntity<Customer> getCustomer(@PathVariable String id) {
		 Customer cus=customerService.findByIdCust(id);
		 return new ResponseEntity<Customer>(cus,HttpStatus.OK);
	}
	@GetMapping(value="customr/{id}")
	public  ResponseEntity<List<Customer>> getBankCustomer(@PathVariable String id) {
		 List<Customer> cus=customerService.findCustomer(id);
		 return new ResponseEntity<List<Customer>>(cus,HttpStatus.OK);
	}
}
