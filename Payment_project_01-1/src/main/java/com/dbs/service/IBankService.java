package com.dbs.service;

import java.util.List;

import com.dbs.beans.Bank;



public interface IBankService {
	public Bank findByIdBank(String id);
	public List<Bank> findAll();

}
