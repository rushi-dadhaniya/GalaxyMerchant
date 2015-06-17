package com.rushi.merchant.parser;

import com.rushi.merchant.vo.LineTypes;

public class InputParser implements Parser {

	public LineTypes parse(String inputLine) {
		if(inputLine != null) {
			
			for(LineTypes lineType : LineTypes.values()) {
				if(inputLine.matches(lineType.getPattern())) {
					return lineType;
				}
			}
		}
		return null;
	}

}
