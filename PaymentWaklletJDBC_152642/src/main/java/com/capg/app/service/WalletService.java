package com.capg.app.service;

import com.capg.app.bean.AccountDetails;
import com.capg.app.dao.WalletDAO;

public class WalletService implements IWalletService{

	WalletDAO dao=new WalletDAO();
	
	public int createAccount(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.createAccount(details) ;
		
	}

	public int deposit(double amount) {
		// TODO Auto-generated method stub
		return dao.deposit(amount);
	}

	public int withdraw(double amount) {
		// TODO Auto-generated method stub
		return dao.withdraw(amount);
	}

	public int fundTransfer(long toAccNo,double amount) {
		// TODO Auto-generated method stub
		return dao.fundTransfer(toAccNo, amount);
	}

	public boolean login(AccountDetails details) {
		// TODO Auto-generated method stub
		return dao.login(details);
		
	}

	public double showBalance() {
		// TODO Auto-generated method stub
		return dao.showBalance();
	}

	public void printTransaction() {
		dao.printTransaction();
		}
	public void logout() {
		dao.logout();
	}
}
