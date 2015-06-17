package com.rushi.merchant.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HowManyLineValidatorTest {

	private HowManyLineValidator howManyLineValidator; 
	
	@Before
	public void setUp() {
		howManyLineValidator = new HowManyLineValidator();
	}
	
	@Test
	public void isValidWithValidLine() {
		Assert.assertTrue(howManyLineValidator.isValid("how many credits is abc xyz pqr?"));
	}
	
	@Test
	public void isValidWithInvalidLine3() {
		Assert.assertFalse(howManyLineValidator.isValid("how many credits abc xyz pqr?"));
	}
	
	@Test
	public void isValidWithInvalidLine2() {
		Assert.assertFalse(howManyLineValidator.isValid("how many is abc"));
	}
	
	@Test
	public void isValidWithInvalidLine() {
		Assert.assertFalse(howManyLineValidator.isValid("credits is abc"));
	}
	
	@Test
	public void isValidWithEmptyLine() {
		Assert.assertFalse(howManyLineValidator.isValid(""));
	}
	
	@Test
	public void isValidWithNull() {
		Assert.assertFalse(howManyLineValidator.isValid(null));
	}

}
