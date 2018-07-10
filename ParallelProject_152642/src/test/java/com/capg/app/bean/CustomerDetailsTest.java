package com.capg.app.bean;

import org.junit.Test;

import junit.framework.TestCase;

public class CustomerDetailsTest extends TestCase{
	CustomerDetails details=new CustomerDetails();
	@Test
	public void testGetGender() {
		details.setGender("Male");
		assertFalse("female".equalsIgnoreCase(details.getGender()));
		assertEquals("Male",details.getGender());
		assertFalse("fem".equalsIgnoreCase(details.getGender()));
		assertEquals("M",details.getGender());
	}

	@Test
	public void testGetAccountNumber() {
	details.setAccountNumber(100000);
	assertFalse(573567==details.getAccountNumber());
	assertTrue(100000==details.getAccountNumber());
	assertFalse(7456==details.getAccountNumber());
	assertFalse(48637868==details.getAccountNumber());
	}

	@Test
	public void testGetName() {
		details.setUsername("Cassie");
		assertEquals("Cassie",details.getUsername());
		assertFalse("amanda".equals(details.getUsername()));
		assertTrue("Cassie".equals(details.getUsername()));
		assertFalse("1yuf4".equals(details.getUsername()));
		
	}

	@Test
	public void testGetEmail() {
		details.setEmail("cassie@gmail.com");
		assertEquals("cassie@gmail.com",details.getEmail());
		assertTrue("cassie@gmail.com".equals(details.getEmail()));
		assertFalse("cassiegmail.com".equals(details.getEmail()));
		assertFalse("amanda@gmailcom".equals(details.getEmail()));
	}

	@Test
	public void testGetPhoneNumber() {
		details.setPhoneNumber("9898989898");
		assertFalse("9788467677".equals(details.getPhoneNumber()));
		assertTrue("9898989898".equals(details.getPhoneNumber()));
		assertFalse("989898989".equals(details.getPhoneNumber()));
		assertFalse(" ".equals(details.getPhoneNumber()));
	}

	@Test
	public void testGetAge() {
		details.setAge(21);
		assertEquals(21,21);
		assertNotSame(31,details.getAge());
		assertNotSame(0,details.getAge());
		assertEquals(21,details.getAge());
	}

	@Test
	public void testGetUsername() {
		details.setUsername("aanaelsa97");
		assertEquals("anaaelsa97",details.getUsername());
		assertFalse("aana97".equals(details.getUsername()));
		assertFalse("elsa97".equals(details.getUsername()));
		assertTrue("aanaelsa97".equals(details.getUsername()));
	}

	@Test
	public void testGetPassword() {
		details.setPassword("elsa9756");
		assertEquals("elsa9756",details.getPassword());
		assertFalse("aana98".equals(details.getPassword()));
		assertNull(details.getPassword());
		assertFalse("9876aana".equals(details.getPassword()));
	}

}
