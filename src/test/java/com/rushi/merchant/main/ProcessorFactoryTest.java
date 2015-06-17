package com.rushi.merchant.main;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.rushi.merchant.processor.AssignmentProcessor;
import com.rushi.merchant.processor.CreditsProcessor;
import com.rushi.merchant.processor.HowManyProcessor;
import com.rushi.merchant.processor.HowMuchProcessor;
import com.rushi.merchant.processor.QueryProcessor;

public class ProcessorFactoryTest {

	private ProcessorFactory processorFactory;
	
	@Before
	public void setUp() {
		processorFactory = ProcessorFactory.getIntsance();
	}
	
	@Test
	public void getProcessorWithHowManyLineType() {
		QueryProcessor processor = processorFactory.getProcessor("how many credits is abc xyz?");
		assertNotNull(processor);
		Assert.assertEquals(processor.getClass(), HowManyProcessor.class);
	}
	
	@Test
	public void getProcessorWithHowMuchLineType() {
		QueryProcessor processor = processorFactory.getProcessor("how much is abc xyz?");
		assertNotNull(processor);
		Assert.assertEquals(processor.getClass(), HowMuchProcessor.class);
	}
	
	@Test
	public void getProcessorWithCreditsLineType() {
		QueryProcessor processor = processorFactory.getProcessor("abc xyz is 123 credits");
		assertNotNull(processor);
		Assert.assertEquals(processor.getClass(), CreditsProcessor.class);
	}
	
	@Test
	public void getProcessorWithAssignmentLineType() {
		QueryProcessor processor = processorFactory.getProcessor("abc is X");
		assertNotNull(processor);
		Assert.assertEquals(processor.getClass(), AssignmentProcessor.class);
	}
	
	@Test
	public void getProcessorWithInvalidLineType() {
		QueryProcessor processor = processorFactory.getProcessor("howw much is abc##");
		assertNull(processor);
	}
	
	@Test
	public void getProcessorWithNullLine() {
		QueryProcessor processor = processorFactory.getProcessor(null);
		assertNull(processor);
	}
	
	@Test
	public void getProcessorWithEmptyLine() {
		QueryProcessor processor = processorFactory.getProcessor("");
		assertNull(processor);
	}

}
