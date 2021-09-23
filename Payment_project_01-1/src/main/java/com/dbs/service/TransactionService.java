package com.dbs.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dbs.beans.Bank;
import com.dbs.beans.Customer;
import com.dbs.beans.Transaction;
import com.dbs.repo.BankRepository;
import com.dbs.repo.CustomerRepo;
import com.dbs.repo.MessageRepo;
import com.dbs.repo.TransactionRepo;


@Service
public class TransactionService implements ITransactionService {

	@Autowired
	CustomerRepo custumerRepo;
	@Autowired
	BankRepository bankRepository;
	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	MessageRepo messageRepo;
	
	@Override
	public Transaction addCustomerTransaction(Transaction transaction) {
		String tt=transaction.getTransfer_type();
		String id=transaction.getSender_acc_id();
		String bic=transaction.getReciever_acc_bic();
		Optional<Customer> optCustomer=custumerRepo.findById(id);
		Optional<Bank> optBank=bankRepository.findById(bic);
		boolean b=(transaction.getAmount())<=(optCustomer.get().getClear_balance());
		if((tt.equalsIgnoreCase("CT")&&(optCustomer.isPresent() && optBank.isPresent())) ) {
			if(b ||(optCustomer.get().getOverdraft().equals("yes")) ){
				double d=(custumerRepo.findById(id).get().getClear_balance())-((transaction.getAmount()*125)/100);
				transaction.setStatus(200);
			    transaction.setReason("Accepted");
			    transaction.setMsg_inst(messageRepo.findById(transaction.getMessage()).get().getInstruction());
			    custumerRepo.findById(id).get().setClear_balance(d);
			    return  transactionRepo.save(transaction);
				
				
				
			}
		    else {
			return new Transaction("","","","",0.0,"","",201,"Transaction failed:Insuficient balance");
		    }
		}
		return new Transaction("","","","",0.0,"","",203,"Transaction Failed");
		
}
	@Override
	public Transaction addBankTransaction(Transaction transaction) {
		String tt=transaction.getTransfer_type();
		String id=transaction.getSender_acc_id();
		String id1=transaction.getReciever_acc_bic();
		Optional<Customer> optCustomer=custumerRepo.findById(id);
		Optional<Customer> optCustomer1=custumerRepo.findById(id1);
		boolean s=(optCustomer.get().getType()).equals("bank");
		boolean s1=(optCustomer1.get().getType()).equals("bank");
		boolean b=(transaction.getAmount())<=(optCustomer.get().getClear_balance());
		if((tt.equalsIgnoreCase("BTO")&&(optCustomer.isPresent() && optCustomer1.isPresent()&& s&&s1))) {
		if((b ||(optCustomer.get().getOverdraft().equals("yes")))){
			 double d=custumerRepo.findById(id).get().getClear_balance()-((transaction.getAmount()*125)/100);
			  double d1=custumerRepo.findById(id1).get().getClear_balance()+transaction.getAmount();
			transaction.setStatus(200);
		    transaction.setReason("Accepted");
		    transaction.setMsg_inst(messageRepo.findById(transaction.getMessage()).get().getInstruction());
		    custumerRepo.findById(id).get().setClear_balance(d);
			   custumerRepo.findById(id1).get().setClear_balance(d1);
			   return transactionRepo.save(transaction);
			
			 
		}else	
			return new Transaction("","","","",0.0,"","",201,"Transaction failed:Insuficient balance");
		}
		return new Transaction("","","","",0.0,"","",203,"Transaction Failed");
	
}
	@Override
	public Transaction addTransaction(Transaction transaction) {
		String tt=transaction.getTransfer_type();
		if(tt.equalsIgnoreCase("CT")) {
		  String id=transaction.getSender_acc_id();
		  String bic=transaction.getReciever_acc_bic();
		  System.out.println("in ct");
		  Optional<Customer> optCustomer=custumerRepo.findById(id);
		  Optional<Bank> optBank=bankRepository.findById(bic);
		  boolean b=(transaction.getAmount())<=(optCustomer.get().getClear_balance());
		  double d=custumerRepo.findById(id).get().getClear_balance()-((transaction.getAmount()*125)/100);
		  
		  if(((optCustomer.isPresent() && optBank.isPresent())) ) {
			  if (optCustomer.get().getType().equals("cust")) {
			  if(b && d>0 ||(optCustomer.get().getOverdraft().equals("yes")) ) { 
				 transaction.setStatus(200);
				  transaction.setReason("Accepted");
				  transaction.setMsg_inst(messageRepo.findById(transaction.getMessage()).get().getInstruction());
				  System.out.println(d);
				  custumerRepo.findById(id).get().setClear_balance(d);
				  return transactionRepo.save(transaction);
				  
				
				 
			     
		      }
		      else
			     return new Transaction("","","","",0.0,"","",201,"Transaction failed:Insuficient balance");
			  }else
				  return new Transaction("","","","",0.0,"","",205,"Transaction failed: Invalid customer type");
				  }else
				return new Transaction("","","","",0.0,"","",202,"Transaction failed: Invalid Sender or Reciver accounts");
		}
		
		else if(tt.equalsIgnoreCase("BTO")) {
			String id=transaction.getSender_acc_id();
			String id1=transaction.getReciever_acc_bic();
			Optional<Customer> optCustomer=custumerRepo.findById(id);
			Optional<Customer> optCustomer1=custumerRepo.findById(id1);
			boolean s=(optCustomer.get().getType()).equals("bank");
			boolean s1=(optCustomer1.get().getType()).equals("bank");
			boolean b=(transaction.getAmount())<=(optCustomer.get().getClear_balance());
			double d=custumerRepo.findById(id).get().getClear_balance()-((transaction.getAmount()*125)/100);
			  double d1=custumerRepo.findById(id1).get().getClear_balance()+transaction.getAmount();
			if(s&& s1) {
				if(((optCustomer.isPresent() && optCustomer1.isPresent()))) {
			   if((b && d>0 ||(optCustomer.get().getOverdraft().equals("yes")))){
				  
				   transaction.setStatus(200);
				    transaction.setReason("Accepted");
				    transaction.setMsg_inst(messageRepo.findById(transaction.getMessage()).get().getInstruction());
				    custumerRepo.findById(id).get().setClear_balance(d);
					custumerRepo.findById(id1).get().setClear_balance(d1);
				    return transactionRepo.save(transaction);
				   
			        
			   }
			   else
				   return new Transaction("","","","",0.0,"","",201,"Transaction failed:Insuficient balance");
			}
			else
				return new Transaction("","","","",0.0,"","",202,"Transaction failed: Invalid Sender or Reciver accounts");
			}else
				return new Transaction("","","","",0.0,"","",204,"Transaction failed: Invalid reciever type (must be bank)");
		}
		return new Transaction("","","","",0.0,"","",203,"Transaction Failed");
		
	}
	
}
	
