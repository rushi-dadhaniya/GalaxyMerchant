package com.rushi.merchant.validator;

import com.rushi.merchant.vo.LineTypes;

public class HowManyLineValidator implements LineValidator{

	public boolean isValid(String line) {
		return line != null ? line.matches(LineTypes.HOW_MANY.getPattern()) : false;
	}


}
