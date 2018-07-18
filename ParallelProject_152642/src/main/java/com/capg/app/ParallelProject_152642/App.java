
package com.capg.app.ParallelProject_152642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import com.capg.app.bean.AccountDetails;
import com.capg.app.bean.CustomerDetails;
import com.capg.app.service.CustomerDetailsValidation;
import com.capg.app.service.WalletService;

public class App {

	public static void main(String[] args) {
		CustomerDetailsValidation validation = new CustomerDetailsValidation();
		WalletService service = new WalletService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			AccountDetails details = new AccountDetails();
			CustomerDetails cust = new CustomerDetails();
			System.out.println("----------------------------------");
			System.out.println("   PAYMENT WALLET APPLICATION     ");
			System.out.println("----------------------------------");
			System.out.println("     1. Create Account            ");
			System.out.println("     2.Log in                     ");
			System.out.println("----------------------------------");
			Scanner sc = new Scanner(System.in);
			int choice = sc.nextInt();
			int option;
			switch (choice) {
			case 1:
				System.out.println("Enter your details.");
				try {
					while (true) {

						System.out.println("Enter your Name");
						String customerName = br.readLine();
						cust.setConsumerName(customerName);
						if (!validation.validateConsumerName(customerName)) {
							System.err.println("Invalid Name format!");
							continue;
						} else
							break;
					}

					while (true) {
						System.out.println("Enter your age");
						int age = Integer.parseInt(br.readLine());
						cust.setAge(age);
						if (!validation.validateAge(age)) {
							System.err.println("Invalid Age!");
							continue;
						} else {
							break;
						}
					}

					while (true) {
						System.out.println("Enter your Gender");
						String gender = br.readLine();
						cust.setGender(gender);
						if (!validation.validateGender(gender)) {
							System.err.println("Invalid Gender!");
							continue;
						} else
							break;
					}

					while (true) {
						System.out.println("Enter Username");
						String userName = br.readLine();
						details.setUserName(userName);
						if (!validation.validateUserName(userName)) {
							System.err.println("Invalid Username!");
							continue;
						} else {
							break;
						}
					}
					while (true) {
						String password;
						System.out.println("Enter a Password");
						password = br.readLine();
						details.setPassword(password);
						if (validation.validatePassword(password)) {
							break;
						}
						;
					}
					while (true) {
						System.out.println(" Enter your Email");
						String email = br.readLine();
						cust.setEmailId(email);
						if (validation.validateEmailID(email)) {
							break;
						} else {
							System.err.println("Invalid Email Format!");
							continue;
						}
					}
					while (true) {
						System.out.println("Enter your Mobile Number");
						String phoneNumber = br.readLine();
						cust.setPhoneNo(phoneNumber);
						if (validation.validatePhoneNo(phoneNumber)) {
							break;
						} else {
							System.err.println("Please enter a valid mobile number.");
							continue;
						}
					}
					details.setDetails(cust);
					service.createAccount(details);
					System.out.println("Account has been created. Sign in to access your account\n");
					long bankAccount = (long) (Math.random() * 1000000 + 9999999);
					details.setBankAccount(bankAccount);
					System.out.println("Bank account number:" + details.getBankAccount());
					details.setBalance(0);
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			case 2:
				try {
					System.out.println("Enter your username");
					String username = br.readLine();
					System.out.println("Enter your password");
					String password = br.readLine();
					details = validation.validateLogIn(username, password);

					if (details != null) {
						do {
							System.out.println("----------------------------------");
							System.out.println("   Logged into APPLICATION     ");
							System.out.println("----------------------------------");
							System.out.println("     1. Show Balance              ");
							System.out.println("     2. Deposit                   ");
							System.out.println("     3. Withdraw                  ");
							System.out.println("     4. Fund Transfer             ");
							System.out.println("     5. Print Transactions        ");
							System.out.println("     6. Log out                ");
							System.out.println("----------------------------------");

							option = sc.nextInt();
							switch (option) {
							case 1:

								System.out.println(service.showBalance(details));

								break;
							case 2:

								details = validation.validateLogIn(username, password);

								if (details != null) {
									System.out.println("Enter the amount you want to deposit");
									double depo = sc.nextDouble();
									System.out.println(service.depositBalance(depo, details));
									long transactionId = (long) (Math.random() * 10000000 + 99999999);
									details.setTransactionId(transactionId);
									System.out.println("Successfuly Deposited.");
									System.out.println("Balance:" + details.getBalance());

								} else if (details == null) {
									System.err.println("Incorrect details!");
								}
								break;
							case 3:

								details = validation.validateLogIn(username, password);
								if (details != null) {
									System.out.println("Enter the amount you want to withdraw");
									double withdraw = sc.nextDouble();
									if (service.withdrawBalance(withdraw, details) != null) {
										System.out.println(details);
										long transactionId = (long) (Math.random() * 10000000 + 99999999);
										details.setTransactionId(transactionId);
										System.out.println("Successfuly Withdrawn.");
										System.out.println("Transaction ID: " + transactionId);
										System.out.println("Balance:" + details.getBalance());
										break;
									} else if (service.withdrawBalance(withdraw, details) == null) {
										System.err.println("Insufficient balance in the account!");
										break;
									}

								} else if (details == null) {
									System.err.println("Incorrect Username or Password!");
								}

								break;
							case 4:
								try {

									details = validation.validateLogIn(username, password);
									if (details != null) {

										System.out
												.println("Enter the bank account number of receiver to transfer fund");
										long bankAccount2 = Long.parseLong(br.readLine());
										System.out.println("Enter the amount");
										double amount = Double.parseDouble(br.readLine());
										details = service.transferFund(bankAccount2, amount, details);
										if (details != null) {
											details.setAmount(amount);
											long transactionId = (long) (Math.random() * 10000000 + 99999999);
											details.setTransactionId(transactionId);
											System.out.println("Amount transferred successfully.");
											System.out.println("Balance:" + details.getBalance());
											System.out.println("Transaction ID: " + transactionId);
											break;
										} else if (details == null) {
											break;
										}

									}
								}

								catch (IOException e) { // TODO Auto-generated catch block }
									e.printStackTrace();
								}

							case 5:

								details = validation.validateLogIn(username, password);
								if (details != null) {

									details = service.printTransaction();

								} else
									System.err.println("Enter valid details!");
								break;

							case 6:
								System.out.println("Succesfully signed out!");
								// System.exit(0);
								break;

							}
						} while (option != 6);
					} else if (details == null) {
						System.err.println("Incorrect details!");
					}
					// break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}

		}

	}
}
