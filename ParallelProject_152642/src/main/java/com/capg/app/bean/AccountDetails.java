package com.capg.app.bean;

import java.util.ArrayList;

public class AccountDetails {

	private double balance;
	private String userName;
	private String password;
	private long bankAccount;
	private long bankAccount2;
	private double amount;
	private long transactionId;
	private ArrayList<String> transactionDetails;
	private CustomerDetails details;
	public double getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "AccountDetails:\nBalance=" + balance + ", \nUserName=" + userName+" \nBankAccount=" + bankAccount;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getBankAccount() {
		return bankAccount;
	}
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public ArrayList<String> getTransactionDetails() {
		return transactionDetails;
	}
	public void setTransactionDetails(ArrayList<String> transactionDetails) {
		this.transactionDetails = transactionDetails;
	}
	public void setBankAccount(long bankAccount) {
		this.bankAccount = bankAccount;
	}
	public long getBankAccount2() {
		return bankAccount2;
	}
	public void setBankAccount2(long bankAccount2) {
		this.bankAccount2 = bankAccount2;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public CustomerDetails getDetails() {
		return details;
	}
	public void setDetails(CustomerDetails details) {
		this.details = details;
	}
	
}