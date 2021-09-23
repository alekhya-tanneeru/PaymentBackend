package com.dbs.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dbs.beans.Customer;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,String>{
	@Query("from customer where type='bank' and id!=:id")
	public List<Customer> findAllByType(@Param("id") String id); 
	
}
