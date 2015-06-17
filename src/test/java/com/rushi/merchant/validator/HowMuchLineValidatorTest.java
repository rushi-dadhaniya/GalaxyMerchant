package com.rushi.merchant.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HowMuchLineValidatorTest {

	private HowMuchLineValidator howMuchLineValidator; 
	
	@Before
	public void setUp() {
		howMuchLineValidator = new HowMuchLineValidator();
	}
	
	@Test
	public void isValidWithValidLine() {
		Assert.assertTrue(howMuchLineValidator.isValid("how much is abc xyz?"));
	}
	
	@Test
	public void isValidWithInvalidLine3() {
		Assert.assertFalse(howMuchLineValidator.isValid("how are you?"));
	}
	
	@Test
	public void isValidWithInvalidLine2() {
		Assert.assertFalse(howMuchLineValidator.isValid("how many is abc"));
	}
	
	@Test
	public void isValidWithInvalidLine() {
		Assert.assertFalse(howMuchLineValidator.isValid("how much is abc"));
	}
	
	@Test
	public void isValidWithEmptyLine() {
		Assert.assertFalse(howMuchLineValidator.isValid(""));
	}
	
	@Test
	public void isValidWithNull() {
		Assert.assertFalse(howMuchLineValidator.isValid(null));
	}

}
