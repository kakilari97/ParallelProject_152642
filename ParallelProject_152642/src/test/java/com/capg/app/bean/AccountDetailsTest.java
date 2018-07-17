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
		account.setUserName("Oppo");
		assertEquals("Oppo",account.getUserName());
		assertTrue("Oppo".equals(account.getUserName()));
		assertEquals("Oppo",account.getUserName());
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
		account.setBankAccount(106756);
		assertTrue(106756==account.getBankAccount());
		assertFalse(10676==account.getBankAccount());
		assertFalse(3==account.getBankAccount());
	}

	@Test
	public void testGetTransactionId() {
		account.setTransactionId(170975);
		assertTrue(170975==account.getTransactionId());
		assertFalse(98776==account.getTransactionId());
		assertFalse(12==account.getTransactionId());
		assertFalse(896==account.getTransactionId());
		
	}

	@Test
	public void testGetBankAccount2() {
		account.setBankAccount2(109886);
		assertTrue(109886==account.getBankAccount2());
		assertFalse(9867==account.getBankAccount2());
		assertFalse(222==account.getBankAccount2());
		assertFalse(7887==account.getBankAccount2());
	}

	@Test
	public void testGetAmount() {
		account.setAmount(300);
		assertTrue(300==account.getAmount());
		assertFalse(4000==account.getAmount());		
		assertFalse(7456==account.getAmount());
		assertFalse(486300==account.getAmount());
	}

}
