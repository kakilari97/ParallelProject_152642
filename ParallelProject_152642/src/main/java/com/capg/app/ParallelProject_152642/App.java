
package com.capg.app.ParallelProject_152642;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capg.app.bean.AccountDetails;
import com.capg.app.bean.CustomerDetails;
import com.capg.app.exception.MinTransferAmountException;
import com.capg.app.service.CustomerDetailsValidation;
import com.capg.app.service.WalletService;

public class App {

	public static void main(String[] args) {

		System.out.println("\t*****Welcome to XYZ E-Wallet******");
		Scanner s = new Scanner(System.in);

		mainMenu();

	}

	public static void mainMenu() {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int choice = 0;

		do {
			System.out.println("\n");
			System.out.println("----------------------------------");
			System.out.println("   PAYMENT WALLET APPLICATION     ");
			System.out.println("----------------------------------");
			System.out.println("     1. Create Account            ");
			System.out.println("     2.Log in                     ");
			System.out.println("     3.Exit.                      ");
			System.out.println("----------------------------------");
			System.out.println("Enter your option:");
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
				System.out.println("Thank you :)");
				System.exit(0);				
				break;
			default:
				System.out.println("Invalid choice");
				break;
			}
		} while (choice != 3);
	}

	public static void createAccount() {

		List<String> transId = new ArrayList<String>();
		CustomerDetails customer = new CustomerDetails();
		AccountDetails details = new AccountDetails();
		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter details");
		System.out.println("----------------------------------");
		try {

			// Getting input or details from user
			System.out.println("Enter your name:");
			String name = br.readLine();

			System.out.println("Enter age:");
			int age = Integer.parseInt(br.readLine());

			System.out.println("Enter gender:");
			String gender = br.readLine();

			System.out.println("Enter mobile number:");
			String mobileNo = br.readLine();

			System.out.println("Enter email:");
			String email = br.readLine();

			System.out.println("Enter username:");
			String username = br.readLine();

			System.out.println("Create Password(min 8 characters):");
			String password = br.readLine();

			// Validation of input
			CustomerDetailsValidation validate = new CustomerDetailsValidation();

			boolean Vname = validate.validateUserName(name);
			boolean Vgender = validate.validateGender(gender);
			boolean Vemail = validate.validateEmailID(email);
			boolean Vmobile = validate.validatePhoneNo(mobileNo);
			boolean Vage = validate.validateAge(age);
			boolean Vuser = validate.validateConsumerName(username);
			boolean Vpass = validate.validatePassword(password);
			
			if (Vname && Vgender && Vemail && Vmobile && Vage && Vuser && Vpass) {

				// Setting the values to bean class object

				long accNo = (long) (Math.random() * 123456789 + 1000);

				customer.setFirstName(name);
				customer.setEmail(email);
				customer.setAge(age);
				customer.setGender(gender);
				customer.setMobileNo(mobileNo);
				details.setCustomer(customer);

				details.setTransId(transId);
				details.setAccNo(accNo);
				details.setUsername(username);
				details.setPassword(password);

				details.setBalance(1000);

				if (service.createAccount(details) == 1) {
					System.out.println("\n");
					System.out.println("Account successfully created!\nAccount number:" + details.getAccNo());
					mainMenu();
				} else
					System.err.println("Account creation failed");
			}else if(!Vname)
				System.err.println("Invalid Name format!");
			else if(!Vgender)
				System.err.println("Invalid gender!");
			else if(!Vmobile)
				System.err.println("Invalid Mobile number format!");
			else if(!Vemail)
				System.err.println("Invalid Email format!");
			else if(!Vage)
				System.err.println("Invalid age!");
			else if(!Vuser)
				System.err.println("Invalid Username format!");
			else if(!Vpass)
				System.err.println("Invalid Password format!");
			else
				System.out.println("Invalid details");

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
			CustomerDetailsValidation validate = new CustomerDetailsValidation();
			boolean Vuser = validate.validateConsumerName(username);
			boolean Vpass = validate.validatePassword(password);

			if (Vuser && Vpass) {
				details.setUsername(username);
				details.setPassword(password);

				if (service.login(details)) {
					System.out.println("Successfully logged in !");
					extendedMenu(details);
				} else
					System.err.println("Login failed");

			} else
				System.err.println("Invalid username or password");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void extendedMenu(AccountDetails details) {

		WalletService service = new WalletService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = 0;
		try {

			do {
				System.out.println("\n");
				System.out.println("----------------------------------");
				System.out.println("            YOUR WALLET           ");
				System.out.println("----------------------------------");
				System.out.println("     1. Show Balance              ");
				System.out.println("     2. Deposit                   ");
				System.out.println("     3. Withdraw                  ");
				System.out.println("     4. Fund Transfer             ");
				System.out.println("     5. Print Transactions        ");
				System.out.println("     6. Log out                   ");
				System.out.println("----------------------------------");
				System.out.println("Enter your choice:");
				choice = Integer.parseInt(br.readLine());
				switch (choice) {

				case 1:
					double balance = service.showBalance();
					if (balance != -1)
						System.out.println("Balance: " + balance);
					break;

				case 2:

					System.out.println("Enter amount to deposit:");
					double depositAmount = Double.parseDouble(br.readLine());
					if (service.deposit(depositAmount) == 1)
						System.out.println("Amount successfully deposited !");
					else
						System.err.println("Deposit failed. Try again with proper input.");
					break;
				case 3:

					System.out.println("Enter amount to withdraw: ");
					double withdrawAmount = Double.parseDouble(br.readLine());
					if (service.withdraw(withdrawAmount) == 1)
						System.out.println("Amount sucessfully withdrawn !");
					else
						System.err.println("Withdraw failed. Insufficient balance.");
					break;
				case 4:

					System.out.println("Enter the account number to transfer amount to:");
					long toAccNo = Long.parseLong(br.readLine());
					System.out.println("Enter amount to transfer:");
					double transferAmount = Double.parseDouble(br.readLine());
					try {

						if (transferAmount > 50000) {
							throw new MinTransferAmountException("Transfer amount should be less than 50000");
						}

					} catch (MinTransferAmountException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if (service.fundTransfer(toAccNo, transferAmount) == 1)
						System.out.println("Transfer successful!");
					else
						System.err.println("Transfer failed! Enter valid account details.");
					break;
				case 5:
					Iterator<String> it = service.printTransaction().iterator();
					while (it.hasNext()) {

						System.out.println(it.next());
					}

					break;

				case 6:
					System.out.println("Logged out of the account! Thank you :)");
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
