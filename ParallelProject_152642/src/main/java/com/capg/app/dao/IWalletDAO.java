package com.capg.app.dao;

import com.capg.app.bean.CustomerDetails;

public interface IWalletDAO {
public boolean createAccount(CustomerDetails details);
public boolean walletLogin(CustomerDetails details);
public boolean deposit();
public boolean withdraw();
public void showBalance();
public boolean fundTransfer();
public boolean printTransactions();
}
