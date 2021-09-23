package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbs.beans.Transaction;

public interface TransactionRepo extends JpaRepository<Transaction,Integer > {

}
