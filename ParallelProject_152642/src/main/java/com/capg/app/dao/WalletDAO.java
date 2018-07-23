package com.capg.app.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capg.app.bean.AccountDetails;
import com.capg.app.bean.CustomerDetails;

public class WalletDAO implements IWalletDAO {

	 long transId;
		static AccountDetails temp=new AccountDetails();
		static List<AccountDetails> list=new ArrayList<AccountDetails>();
	
		public int createAccount(AccountDetails details) {
			
			if(list.add(details)) {
				temp=details;
				return 1;
			}
			else
				return 0;
		}

		public boolean login(AccountDetails details) {
			
			Iterator<AccountDetails> it=list.iterator();
			while(it.hasNext()) {
				
				AccountDetails itDetails=it.next();
				if(details.getUsername().equals(itDetails.getUsername()) && details.getPassword().equals(itDetails.getPassword())) {
					temp=itDetails;
					return true;
				}
			}
			return false;
		}

		public double showBalance() {
			
			Iterator<AccountDetails> it=list.iterator();
			while(it.hasNext()) {
				
				AccountDetails accountit=it.next();
				if(temp.getUsername().equals(accountit.getUsername())) {
					
					double balance=accountit.getBalance();
					System.out.println("Username:"+temp.getUsername());
					System.out.println("Account number:"+temp.getAccNo());
					return balance;
				}
					
			}
			return -1;
		}

		public int deposit(double amount) {
			
			
			
			Iterator<AccountDetails> it=list.iterator();
			while(it.hasNext()) {
				
				AccountDetails accountit=it.next();
				
				if(temp.getUsername().equals(accountit.getUsername())) {
					
					accountit.setBalance(accountit.getBalance()+amount);
					//set transaction 
					transId=(long)(Math.random()*12345+678);
					String s=Long.toString(transId)+":\tDeposited "+Double.toString(amount)+" to "+Long.toString(accountit.getAccNo())+" Balance: "+accountit.getBalance();
					accountit.getTransId().add(s);
					
					//transactions.put(transId, s);
					return 1;
				}
				
			}
			return 0;
		}

		public int withdraw(double amount) {
			
			
			if(temp.getBalance()>amount) {
			Iterator<AccountDetails> it=list.iterator();
			while(it.hasNext()) {
				
				AccountDetails accountit=it.next();
				if(temp.getUsername().equals(accountit.getUsername())) {
					
					accountit.setBalance(accountit.getBalance()-amount);
					//set transaction
					transId=(long)(Math.random()*10000+999);
					String s=Long.toString(transId)+":\tWithdrew "+Double.toString(amount)+" from "+Long.toString(accountit.getAccNo())+" Balance: "+accountit.getBalance();
					accountit.getTransId().add(s);
					//transactions.put(transId, s);
					return 1;
				}
			}
			}
			return 0;
		}

		

		public int fundTransfer(long toAccNo, double amount) {
			
			
			
			Iterator<AccountDetails> it=list.iterator();
			Iterator<AccountDetails> it1=list.iterator();
			while(it.hasNext()) {
				
				AccountDetails accountit=it.next();
				if(temp.getUsername().equals(accountit.getUsername())) {
					// debit from user account
					transId=(long)(Math.random()*12345+234);
					accountit.setBalance(accountit.getBalance()-amount);
					//credit to recipient if xyz bank account holder
					
					while(it1.hasNext()) {
						
						AccountDetails accountit1=it1.next();
						if( accountit1.getAccNo()==toAccNo) {
							
							 accountit1.setBalance( accountit1.getBalance()+amount);	
							String s1=Long.toString(transId)+"Recieved :"+Double.toString(amount)+" from "+Long.toString( accountit.getAccNo())+"\t Balance :"+ accountit1.getBalance();
							 accountit1.getTransId().add(s1);
						}
						
					}
					
					String s=Long.toString(transId)+":\tTransfered "+Double.toString(amount)+" to "+Long.toString(toAccNo)+" from "+Long.toString( accountit.getAccNo())+" Balance :"+ accountit.getBalance();
					 accountit.getTransId().add(s);
					//transactions.put(transId, s);
					return 1;		
				}	
			}
			return 0;
		}

		public List<String> printTransaction() {
			
			Iterator<AccountDetails> it=list.iterator();
			while(it.hasNext()) {
				
				AccountDetails  accountit=it.next();
				if(temp.getUsername().equals( accountit.getUsername())) {
					
					return  accountit.getTransId();
					
				}
				
			}
			return null;
	}

}

