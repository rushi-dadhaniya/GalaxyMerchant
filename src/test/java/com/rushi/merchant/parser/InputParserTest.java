package com.rushi.merchant.parser;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rushi.merchant.vo.LineTypes;

public class InputParserTest {

	private InputParser inputParser;
	
	@Before()
	public void setUp() {
		inputParser = new InputParser();
	}
	
	@Test
	public void parseWithHowManyLineType() {
		LineTypes type = inputParser.parse("how many credits is abc xyz?");
		Assert.assertEquals(LineTypes.HOW_MANY, type);
	}
	
	@Test
	public void parseWithHowMuchLineType() {
		LineTypes type = inputParser.parse("how much is abc xyz?");
		Assert.assertEquals(LineTypes.HOW_MUCH, type);
	}
	
	@Test
	public void parseWithCreditsLineType() {
		LineTypes type = inputParser.parse("abc xyz is 123 credits");
		Assert.assertEquals(LineTypes.CREDITS, type);
	}
	
	@Test
	public void parseWithAssignmentLineType() {
		LineTypes type = inputParser.parse("abc is X");
		Assert.assertEquals(LineTypes.ASSIGNMENT, type);
	}
	
	@Test
	public void parseWithInvalidLineType() {
		LineTypes type = inputParser.parse("");
		Assert.assertNull(type);
	}
	
	@Test
	public void parseWithNull() {
		LineTypes type = inputParser.parse(null);
		Assert.assertNull(type);
	}

}
