package com.rushi.merchant.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.vo.Messages;

public class CreditsProcessorTest {

	private CreditsProcessor creditsProcessor;
	private Map<String, String> romanLiterals, arabicLiterals;
	
	@Before
	public void setUp() {
		creditsProcessor = new CreditsProcessor();
		romanLiterals = new HashMap<String, String>();
		arabicLiterals = new HashMap<String, String>();
	}
	
	@Test
	public void processWithValidLineType() {
		romanLiterals.put("abc", "X");
		romanLiterals.put("xyz", "II");
		creditsProcessor.process("abc xyz arabic is 144 credits", romanLiterals, arabicLiterals);
		String value = arabicLiterals.get("arabic");
		Assert.assertEquals("12.0", value);
	}
	
	@Test
	public void processWithMissingArabic() {
		creditsProcessor.process("abc is credits", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithInvalidLineTypeRequiredLiterals() {
		creditsProcessor.process("abc xyz is pqr credits", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithInvalidLineTypeLessLiterals() {
		creditsProcessor.process("", romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}
	
	@Test
	public void processWithNull() {
		creditsProcessor.process(null, romanLiterals, arabicLiterals);
		List<String> printQueue = PrintQueue.getPrintQueue();
		Assert.assertEquals(Messages.INVALID_INPUT.getMessage(), printQueue.get(printQueue.size() - 1));
	}

}
