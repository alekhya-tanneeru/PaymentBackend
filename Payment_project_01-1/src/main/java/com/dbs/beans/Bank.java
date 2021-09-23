package com.dbs.beans;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name="bank")
public class Bank {
	@Id
	String bic;
	String instname;
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bank(String bic, String instname) {
		super();
		this.bic = bic;
		this.instname = instname;
	}

	public String getBic() {
		return bic;
	}
	public void setBic(String bic) {
		this.bic = bic;
	}
	public String getInstname() {
		return instname;
	}
	public void setInstname(String instname) {
		this.instname = instname;
	}
	

}
