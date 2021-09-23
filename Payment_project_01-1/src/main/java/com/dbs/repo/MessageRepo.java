package com.dbs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbs.beans.Message_code;

@Repository
public interface MessageRepo extends JpaRepository<Message_code,String>{

}
