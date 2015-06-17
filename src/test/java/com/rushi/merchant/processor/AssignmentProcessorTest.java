package com.rushi.merchant.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.vo.Messages;

public class AssignmentProcessorTest {

	private AssignmentProcessor assignmentProcessor;
	private Map<String, String> romanLiterals, arabicLiterals;
	@Before
	public void setUp() {
		assignmentProcessor = new AssignmentProcessor();
		romanLiterals = new HashMap<String, String>();
		arabicLiterals = new HashMap<String, String>();
	}
	
	@Test
	public void proceeWithValidLineType() {
		assignmentProcessor.process("abc is X", romanLiterals, arabicLiterals);
		String value = romanLiterals.get("abc");
		Assert.assertEquals("X", value);
	}
	
	@Test
	public void proceeWithInavlidLineTypeLessLiterals() {
		assignmentProcessor.process("abcxyz", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void proceeWithInavlidLineType() {
		assignmentProcessor.process("", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void proceeWithNull() {
		assignmentProcessor.process(null, romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}

}
