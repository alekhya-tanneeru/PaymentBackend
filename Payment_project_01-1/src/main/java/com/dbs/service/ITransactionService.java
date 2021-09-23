package com.dbs.service;

import java.util.List;

import com.dbs.beans.Bank;
import com.dbs.beans.Customer;
import com.dbs.beans.Transaction;

public interface ITransactionService {
	
	public Transaction addCustomerTransaction(Transaction transaction);
	public Transaction addBankTransaction(Transaction transaction);
	public Transaction addTransaction(Transaction transaction);
	

}
