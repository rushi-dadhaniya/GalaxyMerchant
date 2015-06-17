package com.rushi.merchant.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreditsLineValidatorTest {

	private CreditsLineValidator creditsLineValidator; 
	
	@Before
	public void setUp() {
		creditsLineValidator = new CreditsLineValidator();
	}
	
	@Test
	public void isValidWithValidLine() {
		Assert.assertTrue(creditsLineValidator.isValid("abc xyz is 30 credits"));
	}
	
	@Test
	public void isValidWithInvalidLine2() {
		Assert.assertFalse(creditsLineValidator.isValid("abc xyz is 30"));
	}
	
	@Test
	public void isValidWithInvalidLine() {
		Assert.assertFalse(creditsLineValidator.isValid("abc xyz is credits"));
	}
	
	@Test
	public void isValidWithEmptyLine() {
		Assert.assertFalse(creditsLineValidator.isValid(""));
	}
	
	@Test
	public void isValidWithNull() {
		Assert.assertFalse(creditsLineValidator.isValid(null));
	}

}
