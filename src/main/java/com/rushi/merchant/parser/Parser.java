package com.rushi.merchant.parser;

import com.rushi.merchant.vo.LineTypes;

public interface Parser {

	public LineTypes parse(String string);
	
}
