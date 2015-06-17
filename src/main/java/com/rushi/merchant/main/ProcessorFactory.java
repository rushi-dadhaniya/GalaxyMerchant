package com.rushi.merchant.main;

import java.util.HashMap;
import java.util.Map;

import com.rushi.merchant.parser.InputParser;
import com.rushi.merchant.processor.AssignmentProcessor;
import com.rushi.merchant.processor.CreditsProcessor;
import com.rushi.merchant.processor.HowManyProcessor;
import com.rushi.merchant.processor.HowMuchProcessor;
import com.rushi.merchant.processor.QueryProcessor;
import com.rushi.merchant.vo.LineTypes;

public class ProcessorFactory {

	private static Map<LineTypes, QueryProcessor> processorMap;
	
	public QueryProcessor getProcessor(String line) {
		InputParser inputParser = new InputParser();
		LineTypes type = inputParser.parse(line);
 		return processorMap.get(type);
	}

	public static ProcessorFactory getIntsance() {
		processorMap = new HashMap<LineTypes, QueryProcessor>();
		processorMap.put(LineTypes.ASSIGNMENT, new AssignmentProcessor());
		processorMap.put(LineTypes.CREDITS, new CreditsProcessor());
		processorMap.put(LineTypes.HOW_MUCH, new HowMuchProcessor());
		processorMap.put(LineTypes.HOW_MANY, new HowManyProcessor());
		return new ProcessorFactory();
	}
	
}
