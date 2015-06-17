package com.rushi.merchant.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.vo.Messages;

public class HowMuchProcessorTest {

	private HowMuchProcessor howMuchProcessor;
	private Map<String, String> romanLiterals, arabicLiterals;
	
	@Before
	public void setUp() {
		howMuchProcessor = new HowMuchProcessor();
		romanLiterals = new HashMap<String, String>();
		arabicLiterals = new HashMap<String, String>();
	}
	
	@Test
	public void proceeWithValidLineUnknownLiteral() {
		romanLiterals.put("abc", "X");
		romanLiterals.put("xyz", "II");
		howMuchProcessor.process("how much is abc pqr?", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.NO_IDEA.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void proceeWithValidLineOnlyRomanLiterals() {
		romanLiterals.put("abc", "X");
		romanLiterals.put("xyz", "II");
		howMuchProcessor.process("how much is abc xyz?", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals("abc xyz is 12", printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithInvalidLineTypeWithRequiredLiterals() {
		howMuchProcessor.process("how much is abc 123?", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithInvalidLineTypeWithLessLiterals() {
		howMuchProcessor.process("", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithNull() {
		howMuchProcessor.process(null, romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}

}
