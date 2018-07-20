package com.capg.app.PaymentWalletJDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

import com.capg.app.bean.AccountDetails;
import com.capg.app.bean.CustomerDetails;
import com.capg.app.exception.MinTransferAmountException;
import com.capg.app.service.WalletService;
import com.capg.app.service.WalletServiceValidation;

public class Wallet_JDBC {
	public static void main(String[] args) {

		System.out.println("    PAYMENT WALLET APPLICATION    ");
		System.out.println("----------------------------------");
		Scanner s = new Scanner(System.in);
		mainMenu();
	}

	// Main Menu
	public static void mainMenu() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;

		do {
			System.out.println("----------------------------------");
			System.out.println("\t WALLET OPTIONS");
			System.out.println("----------------------------------");
			System.out.println("\t1.Create Account");
			System.out.println("\t2.Login");
			System.out.println("\t3.Exit");
			System.out.println("----------------------------------");
			System.out.println("Enter choice:");

			try {
				choice = Integer.parseInt(br.readLine());

			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			switch (choice) {
			case 1:
				createAccount();
				break;
			case 2:
				login();
				break;
			case 3:
				System.out.println("Thank you! Have a nice day.");
				System.exit(0);
				break;
			default:
				System.out.println("Choose a valid option!");
				break;
			}
		} while (choice != 3);
	}

	// create Account
	public static void createAccount() {

		CustomerDetails customer = new CustomerDetails();
		AccountDetails details = new AccountDetails();
		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter your details");
		System.out.println("------------------");
		try {

			// Getting details from user
			System.out.println("Enter NAME:");
			String name = br.readLine();

			System.out.println("Enter AGE:");
			int age = Integer.parseInt(br.readLine());

			System.out.println("Enter GENDER:");
			String gender = br.readLine();

			System.out.println("Enter PHONE NUMBER: --(10 digit)--");
			long phoneNo = Long.parseLong(br.readLine());

			System.out.println("Enter your AADHAR NUMBER: --(12 digit)--");
			long aadhar = Long.parseLong(br.readLine());

			System.out.println("Enter USERNAME:");
			String username = br.readLine();

			System.out.println("Create PASSWORD: --(min 8 characters)--");
			String password = br.readLine();

			System.out.println("Enter ACCOUNT TYPE:  --(savings or current)--");
			String accType = br.readLine();

			// Validation of user input
			WalletServiceValidation validate = new WalletServiceValidation();
			boolean Vname = validate.validName(name);
			boolean Vgender = validate.validGender(gender);
			boolean Vphone = validate.validPhoneNo(phoneNo);
			boolean Vage = validate.validAge(age);
			boolean Vuser = validate.validUsername(username);
			boolean Vpass = validate.validPassword(password);

			boolean Vaad = validate.validAadhar(aadhar);

			boolean Vtype = validate.validType(accType);

			if (Vname && Vgender && Vphone && Vage && Vuser && Vpass && Vaad && Vtype) {

				// Setting the values to bean class object

				long accNo = (long) (Math.random() * 123456789 + 1000);

				customer.setName(name);
				customer.setAge(age);
				customer.setGender(gender);
				customer.setPhoneNo(phoneNo);
				customer.setAadhar(aadhar);
				details.setDetails(customer);

				// details.setTransId(transId);
				details.setAccNo(accNo);
				details.setUsername(username);
				details.setPassword(password);
				details.setAccType(accType);
				details.setBalance(1000);

				if (service.createAccount(details) == 1) {
					System.out.println("Account successfully created!\nAccount number:" + details.getAccNo());
					mainMenu();

				} else
					System.err.println("Account creation failed");

			} else
				System.out.println("Invalid details. Try again!");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void login() {

		AccountDetails details = new AccountDetails();
		WalletService service = new WalletService();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {

			System.out.println("Enter username: ");
			String username = br.readLine();
			System.out.println("Enter password:");
			String password = br.readLine();

			// validate username and password
			WalletServiceValidation validate = new WalletServiceValidation();
			boolean Vuser = validate.validUsername(username);
			boolean Vpass = validate.validPassword(password);

			if (Vuser && Vpass) {
				details.setUsername(username);
				details.setPassword(password);

				if (service.login(details)) {
					System.out.println("Successfully logged in !");
					loginMenu(details);
				} else
					System.err.println("Login failed");

			} else
				System.err.println("Invalid username or password");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// login menu
	public static void loginMenu(AccountDetails details) {

		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		try {

			do {
				System.out.println("-----------------------------");
				System.out.println("         YOUR WALLET         ");
				System.out.println("-----------------------------");
				System.out.println("\t1.Show balance");
				System.out.println("\t2.Deposit");
				System.out.println("\t3.Withdraw");
				System.out.println("\t4.Fund transfer");
				System.out.println("\t5.Print transaction");
				System.out.println("\t6.Exit");
				System.out.println("------------------------------");
				System.out.println("Select an option:");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {

				case 1:
					// show balance
					double balance = service.showBalance();
					if (balance != -1)
						System.out.println("Account Balance: " + balance);
					break;

				case 2:
					// Deposit
					System.out.println("Enter amount to deposit:");
					double depositAmount = Double.parseDouble(br.readLine());
					if (service.deposit(depositAmount) == 1)
						System.out.println("Amount successfully deposited !");
					else
						System.err.println("Deposit failed!");
					break;

				case 3:
					// Withdraw
					System.out.println("Enter amount to withdraw: ");
					double withdrawAmount = Double.parseDouble(br.readLine());
					if (service.withdraw(withdrawAmount) == 1)
						System.out.println("Amount sucessfully withdrawn !");
					else
						System.err.println("Withdraw failed!");
					break;

				case 4:
					// Fund Transfer
					System.out.println("Enter the account number to transfer amount to:");
					long toAccNo = Long.parseLong(br.readLine());
					System.out.println("Enter amount to transfer:");
					double transferAmount = Double.parseDouble(br.readLine());
					try {
						if (transferAmount > 50000) {
							throw new MinTransferAmountException(
									"Transfer limit exceeded. Please enter amount less than 50000");
						}
					} catch (MinTransferAmountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (service.fundTransfer(toAccNo, transferAmount) == 1)
						System.out.println("Transfer successfull");
					else
						System.err.println("Transfer failed!");
					break;

				case 5:
					// print transactions
					service.printTransaction();
					break;

				case 6:
					// Log out of the account
					System.out.println("Logged out of your account!");
					service.logout();
					mainMenu();
					break;

				default:
					System.out.println("Invalid choice");
					break;
				}
			} while (choice != 6);

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
