package com.capg.app.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.capg.app.bean.AccountDetails;
import com.capg.app.service.WalletService;

public class WalletDAOTest {
	WalletService service=new WalletService();
	AccountDetails details=new AccountDetails();
	@Test
	public void testCreateAccount() {
		assertTrue(true);
		assertEquals(0,service.createAccount(details));
		assertNull(details);
		assertNotSame(1,service.createAccount(details));
	}

	@Test
	public void testShowBalance() {
		fail("Not yet implemented");
	}

	@Test
	public void testDepositBalance() {
		assertEquals(0,service.depositBalance(4000, details));
		assertTrue(true);
		assertNull(details);
		assertNotSame(4000,details.getBalance());
	}

	@Test
	public void testWithdrawBalance() {
		assertEquals(0,service.withdrawBalance(2000, details));
		assertFalse(false);
		assertTrue(true);
		assertNull(details);
	}

	@Test
	public void testGetList() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransferFund() {
		assertEquals(0,service.transferFund(107895, 3000, details));
		assertTrue(true);
		assertNull(details.getBalance());
		assertNotSame(1,service.transferFund(90, 0, details));
	}

	@Test
	public void testPrintTransaction() {
		fail("Not yet implemented");
	}

}
