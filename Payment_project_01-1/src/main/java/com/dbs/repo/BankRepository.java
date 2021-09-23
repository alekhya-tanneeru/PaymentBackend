package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.beans.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, String>{

}
