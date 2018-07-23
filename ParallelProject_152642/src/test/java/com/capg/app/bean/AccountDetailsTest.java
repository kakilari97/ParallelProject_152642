package com.capg.app.bean;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AccountDetailsTest {
	AccountDetails account=new AccountDetails();
	@Test
	public void testGetBalance() {
		account.setBalance(3000);
		assertTrue(3000==account.getBalance());
		assertFalse(573567==account.getBalance());
		assertFalse(7456==account.getBalance());
		assertFalse(48637868==account.getBalance());
	}

	@Test
	public void testGetUserName() {
		account.setUsername("Oppo");
		assertEquals("Oppo",account.getUsername());
		assertTrue("Oppo".equals(account.getUsername()));
		assertEquals("Oppo",account.getUsername());
		//assertFalse("1yuf4".equals(account.getUserName()));
	}

	@Test
	public void testGetPassword() {
		account.setPassword("oppo12345");
		assertTrue("oppo12345".equalsIgnoreCase(account.getPassword()));
		assertFalse("9876aana".equals(account.getPassword()));
	}

	@Test
	public void testGetBankAccount() {
		account.setAccNo(106756);
		assertTrue(106756==account.getAccNo());
		assertFalse(10676==account.getAccNo());
		assertFalse(3==account.getAccNo());
	}


	@Test
	public void testGetAmount() {
		account.setBalance(300);
		assertTrue(300==account.getBalance());
		assertFalse(4000==account.getBalance());		
		assertFalse(7456==account.getBalance());
		assertFalse(486300==account.getBalance());
	}

}
