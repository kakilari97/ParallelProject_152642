package com.capg.app.bean;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerDetailsTest {
CustomerDetails details=new CustomerDetails();
	@Test
	public void testGetConsumerName() {
		details.setConsumerName("Oppo");
		assertEquals("Oppo",details.getConsumerName());
		assertTrue("Oppo".equals(details.getConsumerName()));
		assertFalse("opopo897".equals(details.getConsumerName()));		
		assertFalse("1yuf4".equals(details.getConsumerName()));
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
		details.setEmailId("oppo@gmail.com");
		assertEquals("oppo@gmail.com",details.getEmailId());
		assertTrue("oppo@gmail.com".equals(details.getEmailId()));
		assertFalse("opopo897".equals(details.getEmailId()));	
		assertFalse("oppo@gmailcom".equals(details.getEmailId()));
	}

	@Test
	public void testGetPhoneNo() {
		details.setPhoneNo("9898989898");
		assertEquals("9898989898",details.getPhoneNo());
		assertTrue("9898989898".equals(details.getPhoneNo()));
		assertFalse("009998979".equals(details.getPhoneNo()));		
		assertFalse("64565477fyfd".equals(details.getPhoneNo()));
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
