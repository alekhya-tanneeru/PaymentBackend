package com.dbs.beans;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	Timestamp dateandtime=Timestamp.from(Instant.now());
	String sender_acc_id;
	String reciever_acc_bic;
	String reciever_name;
	String reciever_acc_no;
	double amount;
	String message;
	String msg_inst;
	String transfer_type;
	int status;
	String reason;
	public Transaction() {
		super();
	}
	public Transaction(String sender_acc,String reciever_acc,String reciever_name,String reciver_acc_no, double amount,
			String message, String transfer_type, int status, String reason) {
		super();


		this.sender_acc_id=sender_acc;
		this.reciever_acc_bic=reciever_acc;
		this.reciever_name=reciever_name;
		this.reciever_acc_no=reciver_acc_no;
		this.amount = amount;
		this.message = message;
		this.transfer_type = transfer_type;
		this.status = status;
		this.reason = reason;
	}

	
	
	
	public int getId() {
		return id;
	}
	
	public String getReciever_name() {
		return reciever_name;
	}
	public void setReciever_name(String reciever_name) {
		this.reciever_name = reciever_name;
	}
	public Timestamp getDateandtime() {
		return dateandtime;
	}
	
	public String getSender_acc_id() {
		return sender_acc_id;
	}
	public void setSender_acc_id(String sender_acc) {
		this.sender_acc_id = sender_acc;
	}
	public String getReciever_acc_bic() {
		return reciever_acc_bic;
	}
	public void setReciever_acc_bic(String reciever_acc) {
		this.reciever_acc_bic = reciever_acc;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getReason() {
		return reason;
	}
	
	public String getReciever_acc_no() {
		return reciever_acc_no;
	}
	public void setReciever_acc_no(String reciever_acc_no) {
		this.reciever_acc_no = reciever_acc_no;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getTransfer_type() {
		return transfer_type;
	}
	public void setTransfer_type(String transfer_type) {
		this.transfer_type = transfer_type;
	}
	public int getStatus() {
		return status;
	}
	public String getMsg_inst() {
		return msg_inst;
	}
	public void setMsg_inst(String msg_inst) {
		this.msg_inst = msg_inst;
	}
	

}
