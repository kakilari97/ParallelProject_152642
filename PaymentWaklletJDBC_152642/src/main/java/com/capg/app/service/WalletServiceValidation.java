package com.capg.app.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WalletServiceValidation {
	private Pattern pattern;
	private Matcher matcher;

	public enum Gender {
		Male, Female, M, F
	}

	public boolean validName(String Name) {
		String name_pattern = "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$";
		this.pattern = Pattern.compile(name_pattern);
		matcher = pattern.matcher(Name);
		return matcher.matches();
		// if(!Name.isEmpty())
		// return true;
		// else
		// return false;

	}

	public boolean validGender(String gender) {

		for (Gender g : Gender.values()) {
			if (g.name().equalsIgnoreCase(gender)) {
				return true;
			}
		}
		return false;

	}

	public boolean validUsername(String username) {
		String username_pattern = "^[a-zA-Z0-9._-]{3,25}$";
		this.pattern = Pattern.compile(username_pattern);
		matcher = pattern.matcher(username);
		return matcher.matches();
		// if(!username.isEmpty())
		// return true;
		// else
		// return false;

	}

	public boolean validPassword(String password) {
		boolean c = false;
		if (password.length() > 5 && password.length() < 20) {
			c = true;

		} else if (password.length() < 8) {
			System.err.println("Password should be of a minimum length of 8 and a maximum length of 20.");
		}
		return c;
		// if(!password.isEmpty() && password.length()>=8)
		// return true;
		// else
		// return false;
		//
	}

	public boolean validAge(int age) {

		if (age > 0 && age < 120) {
			return true;
		} else
			return false;
	}

	public boolean validPhoneNo(long phoneNo) {
		String p = Long.toString(phoneNo);
		if (p.length() != 10) {
			return false;
		}else
			return true;
	}

	public boolean validAadhar(long aadhar) {

		String a = Long.toString(aadhar);
		if (a.length() != 12) {
			return false;
		}
		else
		 return true;

	}

	public boolean validType(String accType) {

		if (accType.equalsIgnoreCase("savings") || accType.equalsIgnoreCase("current"))
			return true;
		else
			return false;
	}
}
