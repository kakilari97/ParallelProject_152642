package com.capg.app.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.capg.app.bean.AccountDetails;
import com.capg.app.bean.CustomerDetails;

public class WalletDAO implements IWalletDAO {

	public static List<AccountDetails> accountInfo = new ArrayList<AccountDetails>();
	List<String> list=new ArrayList<String>();
	public boolean createAccount(AccountDetails account) {
		return accountInfo.add(account);
	}

	public AccountDetails showBalance(AccountDetails account) {
		return account;
	}

	public AccountDetails depositBalance(double deposit, AccountDetails account) {

		
		account.setBalance(account.getBalance() + deposit);
		list.add("Amount deposited is :"+deposit);
		return account;
	}

	public AccountDetails withdrawBalance(double withdraw,AccountDetails account) {

		double remainder = account.getBalance() - withdraw;
		list.add("Amount withdrawn is: "+withdraw);
		if (remainder >= 0) {
			account.setBalance(remainder);
			return account;
		}
		return null;
	}

	public static List<AccountDetails> getList() {
		return accountInfo;
	}

	public AccountDetails transferFund(long bankaccount2, double amount, AccountDetails account) {
		AccountDetails acc2=new AccountDetails();
		double userOneBalance =account.getBalance();
		list.add("Amount transfered:"+amount);
		for (AccountDetails obj : accountInfo) {

			if (account.getBankAccount() == bankaccount2) {
				System.err.println("Cannot transfer funds to yourself!");
				break;
			}
			

			if (obj.getBankAccount() == (bankaccount2)) {
				if (userOneBalance >= amount) {

					acc2.setBalance(obj.getBalance() + amount);
					obj.setBalance(userOneBalance - amount);
					double userbal=obj.getBalance();
					account.setBalance(userbal);
					obj.setAmount(amount);
					return account;
				}

				else {
					System.err.println("Insufficient funds!");
				}
			}
		}
		
		return null;
	}


	public AccountDetails printTransaction() {	
		System.out.println(list);
		return null;
	}
}

