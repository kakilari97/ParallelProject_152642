package com.capg.app.dao;

import java.util.List;

import com.capg.app.bean.AccountDetails;
//import com.capg.app.bean.CustomerDetails;

public interface IWalletDAO {
	
public int createAccount(AccountDetails details);
	
	public boolean login(AccountDetails details);
	
	public double showBalance();
	
	public int deposit(double amount);
	
	public int withdraw(double amount);
	
	public int fundTransfer(long toAccNo,double amount);
	
	public List<String> printTransaction();
//	public boolean createAccount(AccountDetails account);
//
//	public AccountDetails showBalance(AccountDetails account);
//
//	public AccountDetails depositBalance(double deposit, AccountDetails account);
//
//	public AccountDetails withdrawBalance(double withdraw,AccountDetails account);
//	
//	public AccountDetails transferFund(long bankaccount2, double amount, AccountDetails account);
//	
//	//public AccountDetails printTransaction(long transId, AccountDetails account);
//	public AccountDetails printTransaction();
}
