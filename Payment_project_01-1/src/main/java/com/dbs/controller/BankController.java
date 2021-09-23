package com.dbs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.beans.Bank;
import com.dbs.beans.Customer;
import com.dbs.service.IBankService;
import com.dbs.service.ICustomerService;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class BankController {

	@Autowired
	IBankService bankService;
	
	@GetMapping(value = "bank/{id}")
	public ResponseEntity<Bank> getBank(@PathVariable String id) {
		Bank bank= bankService.findByIdBank(id);
		return new ResponseEntity<Bank>(bank,HttpStatus.OK);
	}
}

