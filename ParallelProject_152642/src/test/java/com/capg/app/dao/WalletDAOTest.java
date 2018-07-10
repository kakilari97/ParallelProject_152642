package com.capg.app.dao;

import org.junit.Test;

import com.capg.app.bean.CustomerDetails;
import com.capg.app.service.WalletService;

import junit.framework.TestCase;

public class WalletDAOTest extends TestCase{
WalletService service=new WalletService();
CustomerDetails details;
	@Test
	public void testCreateAccount() {
		assertEquals(0,service.createAccount(details));
		assertNull(details);
		assertTrue(true);
		assertNotSame(1,service.createAccount(details));
	}

	@Test
	public void testWalletLogin() {
		assertEquals(false,service.walletLogin(details));
		assertNull(details);
		assertTrue(true);
		assertNotSame(1,service.walletLogin(details));
		assertEquals(0,service.walletLogin(details));
	}

	@Test
	public void testDeposit() {
		assertEquals(0,service.deposit());
		assertTrue(true);
		assertNull(details);
		assertNotSame(4000,details.getBalance());
	}

	@Test
	public void testWithdraw() {
		assertEquals(0,service.withdraw(2000));
		assertFalse(false);
		assertTrue(true);
		assertNull(details);
	}
	@Test
	public void testShowBalance() {
		
	}

	@Test
	public void testFundTransfer() {
		assertEquals(0,service.fundTransfer(4000));
		assertTrue(true);
		assertNull(details.getBalance());
		assertNotSame(1,service.fundTransfer(3000));
		
	}

	@Test
	public void testPrintTransactions() {
		
	}

}
