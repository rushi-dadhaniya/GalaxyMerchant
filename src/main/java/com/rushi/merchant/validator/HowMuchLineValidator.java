package com.rushi.merchant.validator;

import com.rushi.merchant.vo.LineTypes;

public class HowMuchLineValidator implements LineValidator{

	public boolean isValid(String line) {
		return line != null ? line.matches(LineTypes.HOW_MUCH.getPattern()) : false;
	}


}
