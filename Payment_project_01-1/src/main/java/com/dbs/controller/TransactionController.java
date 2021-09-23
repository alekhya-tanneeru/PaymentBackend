package com.dbs.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dbs.beans.Bank;
import com.dbs.beans.Customer;
import com.dbs.beans.Transaction;
import com.dbs.service.ITransactionService;


@RestController
@CrossOrigin(origins="http://localhost:4200")  
public class TransactionController {

	@Autowired
	ITransactionService transactionService;

	
	@PostMapping(value="transaction")
	public ResponseEntity<Transaction> getbcDetails(@RequestBody Transaction transaction) {
		Transaction transaction2= transactionService.addTransaction(transaction);
		return new ResponseEntity<Transaction>(transaction2,HttpStatus.OK);
		
	}
	
}
