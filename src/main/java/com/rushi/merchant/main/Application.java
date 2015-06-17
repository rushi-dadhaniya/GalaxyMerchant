package com.rushi.merchant.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rushi.merchant.processor.QueryProcessor;
import com.rushi.merchant.reader.InputReader;
import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.util.PrintUtil;
import com.rushi.merchant.vo.Messages;

public class Application {

	private static Map<String, String> romanLiterals, arabicLiterals;
	
	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to the galaxy merchant");
		
		List<String> inputLines = readData();
		processData(inputLines);
		displayOutput();
	}

	private static List<String> readData() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		InputReader inputReader = new InputReader();
		List<String> inputLines = inputReader.readData(bufferedReader);
		return inputLines;
	}

	private static void processData(List<String> inputLines) {
		romanLiterals = new HashMap<String, String>();
		arabicLiterals = new HashMap<String, String>();
		
		for(String line : inputLines) {
			ProcessorFactory processFactory = ProcessorFactory.getIntsance();
			QueryProcessor processor = processFactory.getProcessor(line);
			if(processor != null) {
				processor.process(line, romanLiterals, arabicLiterals);
			}
			else {
				PrintQueue.getPrintQueue().add((Messages.NO_IDEA.getMessage()));
			}
		}
		
	}

	private static void displayOutput() {
		for(String message : PrintQueue.getPrintQueue()) {
			PrintUtil.print(message);
		}
	}
	
}
