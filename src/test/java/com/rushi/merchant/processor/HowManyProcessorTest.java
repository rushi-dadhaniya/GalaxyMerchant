package com.rushi.merchant.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.vo.Messages;

public class HowManyProcessorTest {

	private HowManyProcessor howManyProcessor;
	private Map<String, String> romanLiterals, arabicLiterals;
	
	@Before
	public void setUp() {
		howManyProcessor = new HowManyProcessor();
		romanLiterals = new HashMap<String, String>();
		arabicLiterals = new HashMap<String, String>();
	}
	
	@Test
	public void processWithValidLine(){
		romanLiterals.put("abc", "X");
		romanLiterals.put("xyz", "II");
		arabicLiterals.put("pqr", "12");
		howManyProcessor.process("how many credits is abc xyz pqr?", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals("abc xyz pqr is 144 Credits", printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithValidLineOnlyRomanLiterals(){
		romanLiterals.put("abc", "X");
		romanLiterals.put("xyz", "II");
		howManyProcessor.process("how many credits is abc xyz?", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals("abc xyz is 12 Credits", printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithInvalidLineTypeRequiredLiterals() {
		howManyProcessor.process("how many credits is 123 abc", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithInvalidLineTypeLessLiterals() {
		howManyProcessor.process("", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithNull() {
		howManyProcessor.process(null, romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}

}
