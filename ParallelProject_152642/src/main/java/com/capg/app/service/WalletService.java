package com.capg.app.service;

import com.capg.app.bean.AccountDetails;
//import com.capg.app.bean.CustomerDetails;
import com.capg.app.dao.WalletDAO;



public class WalletService implements IWalletService {

	WalletDAO pd = new WalletDAO();

	public boolean createAccount(AccountDetails details) {

		return pd.createAccount(details);
	}

	public AccountDetails showBalance(AccountDetails details) {

		return pd.showBalance(details);
	}

	public AccountDetails depositBalance(double deposit, AccountDetails details) {

		return pd.depositBalance(deposit, details);

	}

	public AccountDetails withdrawBalance(double withdraw, AccountDetails details) {

		return pd.withdrawBalance(withdraw, details);
	}

	public AccountDetails transferFund(long bankaccount2, double amount, AccountDetails details) {
		
		return pd.transferFund(bankaccount2, amount, details);
		
	}


		public AccountDetails printTransaction() {
		
		return pd.printTransaction();
		
	}

	

}