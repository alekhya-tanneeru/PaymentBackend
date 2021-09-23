package com.dbs.service;

import java.util.List;

import com.dbs.beans.Customer;


public interface ICustomerService {
	public Customer findByIdCust(String id);
	public List<Customer> findCustomer(String u);

}
