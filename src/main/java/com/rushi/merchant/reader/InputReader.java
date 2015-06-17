package com.rushi.merchant.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {

	private static final String END_OF_INPUT = "end";
	
	public List<String> readData(BufferedReader bufferedReader) throws IOException {
		
		List<String> inputLines;
		if(bufferedReader != null) {
			inputLines = new ArrayList<String>();
			String inputLine;
			
			while(!(inputLine = bufferedReader.readLine()).equalsIgnoreCase(END_OF_INPUT)) {
				inputLines.add(inputLine);
			}
			return inputLines;
		}
		return null;
	}
	
}
