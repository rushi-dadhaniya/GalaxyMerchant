package com.rushi.merchant.validator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AssignmentLineValidatorTest {

	private AssignmentLineValidator assignmentLineValidator; 
	
	@Before
	public void setUp() {
		assignmentLineValidator = new AssignmentLineValidator();
	}
	
	@Test
	public void isValidWithValidLine() {
		Assert.assertTrue(assignmentLineValidator.isValid("abc is X"));
	}
	
	@Test
	public void isValidWithInvalidLine() {
		Assert.assertFalse(assignmentLineValidator.isValid("abc is"));
	}
	
	@Test
	public void isValidWithEmptyLine() {
		Assert.assertFalse(assignmentLineValidator.isValid(""));
	}
	
	@Test
	public void isValidWithNull() {
		Assert.assertFalse(assignmentLineValidator.isValid(null));
	}

}
