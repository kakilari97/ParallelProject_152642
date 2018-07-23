package com.capg.app.bean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerDetailsTest {
CustomerDetails details=new CustomerDetails();
	@Test
	public void testGetConsumerName() {
		details.setFirstName("Oppo");
		assertEquals("Oppo",details.getFirstName());
		assertTrue("Oppo".equals(details.getFirstName()));
		assertFalse("opopo897".equals(details.getFirstName()));		
		assertFalse("1yuf4".equals(details.getFirstName()));
	}

	@Test
	public void testGetAge() {
		details.setAge(21);
		assertTrue(21==details.getAge());
		assertFalse(98776==details.getAge());		
		assertFalse(12==details.getAge());
		assertFalse(0==details.getAge());
	}

	@Test
	public void testGetEmailId() {
		details.setEmail("oppo@gmail.com");
		assertEquals("oppo@gmail.com",details.getEmail());
		assertTrue("oppo@gmail.com".equals(details.getEmail()));
		assertFalse("opopo897".equals(details.getEmail()));	
		assertFalse("oppo@gmailcom".equals(details.getEmail()));
	}

	@Test
	public void testGetPhoneNo() {
		details.setMobileNo("9898989898");
		assertEquals("9898989898",details.getMobileNo());
		assertTrue("9898989898".equals(details.getMobileNo()));
		assertFalse("009998979".equals(details.getMobileNo()));		
		assertFalse("64565477fyfd".equals(details.getMobileNo()));
	}

	@Test
	public void testGetGender() {
		details.setGender("female");
		assertEquals("female",details.getGender());
		assertTrue("female".equalsIgnoreCase(details.getGender()));
		assertFalse("fem".equals(details.getGender()));
		assertFalse("tyu".equals(details.getGender()));
	}

}
