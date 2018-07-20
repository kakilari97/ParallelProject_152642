package com.capg.app.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capg.app.bean.AccountDetails;
import com.capg.app.util.WalletDBUtil;

public class WalletDAO implements IWalletDAO {

	static Connection connect;
	static double balance;
	static long aadharNo, accNo;

	// create Account
	public int createAccount(AccountDetails details) {
		int x = 0, y = 0;
		try {
			connect = WalletDBUtil.getConnection();
			String insertCustomer = "insert into customerdetails values(?,?,?,?,?)";
			java.sql.PreparedStatement pstmtCust = connect.prepareStatement(insertCustomer);
			pstmtCust.setString(1, details.getDetails().getName());
			pstmtCust.setInt(2, details.getDetails().getAge());
			pstmtCust.setString(3, details.getDetails().getGender());
			pstmtCust.setLong(4, details.getDetails().getPhoneNo());
			pstmtCust.setLong(5, details.getDetails().getAadhar());
			x = pstmtCust.executeUpdate();
			String insertAccount = "insert into accountdetails values(?,?,?,?,?,?)";
			java.sql.PreparedStatement pstmtAcc = connect.prepareStatement(insertAccount);
			pstmtAcc.setLong(1, details.getAccNo());
			pstmtAcc.setString(2, details.getUsername());
			pstmtAcc.setString(3, details.getPassword());
			pstmtAcc.setDouble(4, details.getBalance());
			pstmtAcc.setLong(5, details.getDetails().getAadhar());
			pstmtAcc.setString(6, details.getAccType());
			y = pstmtAcc.executeUpdate();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (x == 1 && y == 1) {
			return 1;
		}
		return 0;
	}

	// login
	public boolean login(AccountDetails details) {
		int x = 0;
		try {
			connect = WalletDBUtil.getConnection();
			String loginQuery = "select * from accountdetails where username= '" + details.getUsername()
					+ "'and Password='" + details.getPassword() + "'";
			java.sql.Statement stmtLogin = connect.createStatement();
			ResultSet resultLogin = stmtLogin.executeQuery(loginQuery);
			if (resultLogin.first())
				x = 1;
			aadharNo = resultLogin.getLong(5);
			balance = resultLogin.getDouble(4);
			accNo = resultLogin.getLong(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (x == 1)
			return true;
		else
			return false;
	}

	// show balance
	public double showBalance() {
		return balance;
	}

	// deposit
	public int deposit(double amount) {

		try {
			String depositQuery = "update accountdetails set balance=" + (balance + amount) + " where aadharNo="
					+ aadharNo;
			java.sql.PreparedStatement deposit = connect.prepareStatement(depositQuery);
			if (deposit.executeUpdate() == 1) {
				String transaction = "Deposited " + Double.toString(amount) + "to " + accNo;
				balance = balance + amount;
				String inserttransaction = "insert into printtransactions values(" + aadharNo + ",'" + transaction
						+ "')";
				java.sql.PreparedStatement trans = connect.prepareStatement(inserttransaction);
				trans.executeUpdate();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// withdraw
	public int withdraw(double amount) {
		try {
			String withdrawQuery = "update accountdetails set balance=" + (balance - amount) + "where aadharNo="
					+ aadharNo;
			java.sql.PreparedStatement deposit = connect.prepareStatement(withdrawQuery);

			if (deposit.executeUpdate() == 1) {
				String transaction = "withdrawn " + Double.toString(amount) + "from " + Long.toString(accNo);
				balance = balance - amount;
				String insertTransaction = "insert into printtransactions values(" + aadharNo + ",'" + transaction
						+ "')";
				java.sql.PreparedStatement trans = connect.prepareStatement(insertTransaction);
				trans.executeUpdate();
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// fund transfer
	public int fundTransfer(long toAccNo, double amount) {
		try {
			String receiver = "select * from accountdetails where accNo=" + toAccNo;
			java.sql.PreparedStatement toAcc = connect.prepareStatement(receiver);
			ResultSet tempTransaction = toAcc.executeQuery();

			if (tempTransaction.first()) {
				String withdrawQuery = "update accountdetails set balance=" + (balance - amount) + "where aadharNo="
						+ aadharNo;
				balance = balance - amount;
				java.sql.PreparedStatement deposit = connect.prepareStatement(withdrawQuery);
				if (deposit.executeUpdate() == 1) {
					String transaction = "Transferred " + Double.toString(amount) + "to " + Long.toString(toAccNo);
					String insertTransaction = "insert into printtransactions values(" + aadharNo + ",'" + transaction
							+ "')";
					java.sql.PreparedStatement trans = connect.prepareStatement(insertTransaction);
					trans.executeUpdate();
				}
				double bal = tempTransaction.getDouble(4) + amount;
				String depositQuery = "update accountdetails set balance=" + bal + "where aadharNo="
						+ tempTransaction.getLong(5);
				java.sql.PreparedStatement deposit1 = connect.prepareStatement(depositQuery);
				if (deposit1.executeUpdate() == 1) {
					String transaction = "Received " + Double.toString(amount) + "from " + Long.toString(accNo);
					String inserttransaction = "insert into printtransactions values(" + tempTransaction.getLong(5)
							+ ",'" + transaction + "')";
					java.sql.PreparedStatement trans = connect.prepareStatement(inserttransaction);
					trans.executeUpdate();
					return 1;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// print transactions
	public void printTransaction() {
		try {
			String printQuery = "select transactionInfo from printtransactions where aadharNo=" + aadharNo;
			java.sql.PreparedStatement print = connect.prepareStatement(printQuery);
			ResultSet transaction = print.executeQuery();
			while (transaction.next()) {
				System.out.println(transaction.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// logout
	public void logout() {
		try {
			connect.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
