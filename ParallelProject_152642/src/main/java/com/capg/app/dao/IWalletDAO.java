package com.capg.app.dao;

import com.capg.app.bean.AccountDetails;
//import com.capg.app.bean.CustomerDetails;

public interface IWalletDAO {
	public boolean createAccount(AccountDetails account);

	public AccountDetails showBalance(AccountDetails account);

	public AccountDetails depositBalance(double deposit, AccountDetails account);

	public AccountDetails withdrawBalance(double withdraw,AccountDetails account);
	
	public AccountDetails transferFund(long bankaccount2, double amount, AccountDetails account);
	
	//public AccountDetails printTransaction(long transId, AccountDetails account);
	public AccountDetails printTransaction();
}
