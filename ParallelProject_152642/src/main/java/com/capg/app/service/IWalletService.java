package com.capg.app.service;

import com.capg.app.bean.CustomerDetails;

public interface IWalletService {
		public boolean createAccount(CustomerDetails details);
		public boolean walletLogin(CustomerDetails details);
		public boolean deposit();
		public boolean withdraw();
		public void showBalance();
		public boolean fundTransfer();
		public boolean printTransactions();
}
