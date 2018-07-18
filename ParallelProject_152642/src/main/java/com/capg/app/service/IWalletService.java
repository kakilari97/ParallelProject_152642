package com.capg.app.service;

import com.capg.app.bean.AccountDetails;
import com.capg.app.bean.CustomerDetails;

public interface IWalletService {

	public boolean createAccount(AccountDetails account);

	public AccountDetails showBalance(AccountDetails account);

	public AccountDetails depositBalance(double deposit, AccountDetails account);

	public AccountDetails withdrawBalance(double withdraw,AccountDetails account);
	
	public AccountDetails transferFund(long bankaccount2, double amount, AccountDetails account);

	public AccountDetails printTransaction();

}
