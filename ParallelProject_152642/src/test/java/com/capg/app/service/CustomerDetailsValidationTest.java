package com.capg.app.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.capg.app.bean.CustomerDetails;

public class CustomerDetailsValidationTest {
	CustomerDetails details=new CustomerDetails();
	CustomerDetailsValidation validate=new CustomerDetailsValidation();

	@Test
	public void testValidateConsumerName() {
		assertEquals(true, validate.validateConsumerName("KavyaKilari"));
		assertEquals(true, validate.validateConsumerName("Kavya Kilari"));
		assertEquals(true, validate.validateConsumerName("Kavya"));
		assertEquals(false, validate.validateConsumerName("5697kkavy"));
		assertEquals(false, validate.validateConsumerName(""));		
		assertEquals(false, validate.validateConsumerName("kavy@"));
	}

	@Test
	public void testValidateUserName() {
		assertEquals(true, validate.validateUserName("Kavya_5697"));
		assertEquals(true, validate.validateUserName("1997"));
		assertEquals(true,validate.validateUserName("Kavyakilari5697"));
		assertEquals(false,validate.validateUserName("pa"));
		assertEquals(false, validate.validateUserName("fg@#%h jjry"));
		assertEquals(false, validate.validateUserName(""));
	}

	@Test
	public void testValidatePassword() {
		assertEquals(true, validate.validatePassword("kavy@5697"));
		assertEquals(true, validate.validatePassword("5697kavya#"));
		assertEquals(true, validate.validatePassword("kk555597@"));
		assertEquals(false, validate.validatePassword("5697"));
		assertEquals(false, validate.validatePassword(""));
		assertEquals(false, validate.validatePassword("kavya"));
	}

	@Test
	public void testValidateEmailID() {
		assertEquals(true, validate.validateEmailID("kakilari@gmail.com"));
		assertEquals(true, validate.validateEmailID("kakilari@capg.com"));
		assertEquals(false, validate.validateEmailID(""));
		assertEquals(false, validate.validateEmailID("kakilari@gmailcom"));
		assertEquals(false, validate.validateEmailID("kkgmail.com"));
		assertEquals(false, validate.validateEmailID("kavya.gmail.com"));
	}

	@Test
	public void testValidatePhoneNo() {
		assertEquals(true, validate.validatePhoneNo("8008568147"));
		assertEquals(true, validate.validatePhoneNo("9999999999"));
		assertEquals(false, validate.validatePhoneNo(""));
		assertEquals(false, validate.validatePhoneNo("2323414141"));
		assertEquals(false, validate.validatePhoneNo("12345678901234"));

	}

	@Test
	public void testValidateAge() {
		assertEquals(true, validate.validateAge(21));
		assertEquals(true, validate.validateAge(9));
		assertEquals(true, validate.validateAge(45));
		assertEquals(false, validate.validateAge(-22));
		assertEquals(false, validate.validateAge(890));
	}

	@Test
	public void testValidateGender() {
		assertEquals(true, validate.validateGender("Female"));
		assertEquals(true,validate.validateGender("male"));
		assertEquals(true, validate.validateGender("M"));
		assertEquals(true, validate.validateGender("F"));
		assertEquals(false, validate.validateGender("i"));
		assertEquals(false, validate.validateGender("21"));
		assertEquals(false, validate.validateGender("#"));
	}

}
