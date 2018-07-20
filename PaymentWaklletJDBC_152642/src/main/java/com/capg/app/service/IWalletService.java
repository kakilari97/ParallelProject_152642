package com.capg.app.service;

import com.capg.app.bean.AccountDetails;

public interface IWalletService {

	public int createAccount(AccountDetails details);
	
	public boolean login(AccountDetails details);
	
	public double showBalance();
	
	public int deposit(double amount);
	
	public int withdraw(double amount);
	
	public int fundTransfer(long toAccNo,double amount);
	
	public void printTransaction();
}
