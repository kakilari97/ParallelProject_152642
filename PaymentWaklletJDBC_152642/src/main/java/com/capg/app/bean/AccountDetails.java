package com.capg.app.bean;

public class AccountDetails {

	private long accNo;
	private String username;
	private String password;
	private double balance;
	private String accType;
	private CustomerDetails details;
	
	public CustomerDetails getDetails() {
		return details;
	}
	public void setDetails(CustomerDetails details) {
		this.details = details;
	}
	public long getAccNo() {
		return accNo;
	}
	public void setAccNo(long accNo) {
		this.accNo = accNo;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getAccType() {
		return accType;
	}
	public void setAccType(String accType) {
		this.accType = accType;
	}
	@Override
	public String toString() {
		return "AccountDetails [accNo=" + accNo + ", username=" + username + ", password=" + password + ", balance="
				+ balance + ", accType=" + accType + "]";
	}
	
	
}
