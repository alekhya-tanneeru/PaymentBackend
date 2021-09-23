package com.dbs.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="message_code")
public class Message_code {
	@Id
	String msg_code;
	String instruction;
	public Message_code() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Message_code(String msg_code, String instruction) {
		super();
		this.msg_code = msg_code;
		this.instruction = instruction;
	}
	public String getMsg_code() {
		return msg_code;
	}
	public void setMsg_code(String msg_code) {
		this.msg_code = msg_code;
	}
	public String getInstruction() {
		return instruction;
	}
	public void setInstruction(String instruction) {
		this.instruction = instruction;
	}
	

}
