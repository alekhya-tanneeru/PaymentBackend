package com.dbs.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Bank;

import com.dbs.repo.BankRepository;



@Service
public class BankService implements IBankService {

	@Autowired
	BankRepository bankRepository;
	@Override
	public Bank findByIdBank(String id) {
		return bankRepository.findById(id).get();
		
	}
	@Override
	public List<Bank> findAll() {
		return bankRepository.findAll();
	}
	
	
}	