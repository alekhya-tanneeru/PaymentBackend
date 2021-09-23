package com.dbs.beans;





import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity(name="customer")
public class Customer {
	@Id
	String id;
	String holder_name;
	double clear_balance;
	String type;
	String overdraft;
	
	public String getId() {
		return id;
	}
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String holder_name, double clear_balance,String type,String overdraft) {
		super();
		this.id = id;
		this.holder_name = holder_name;
		this.clear_balance = clear_balance;
		this.type=type;
		this.overdraft=overdraft;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(String overdraft) {
		this.overdraft = overdraft;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getHolder_name() {
		return holder_name;
	}
	public void setHolder_name(String holder_name) {
		this.holder_name = holder_name;
	}
	public double getClear_balance() {
		return clear_balance;
	}
	public void setClear_balance(double clear_balance) {
		this.clear_balance = clear_balance;
	}
	
	
}
