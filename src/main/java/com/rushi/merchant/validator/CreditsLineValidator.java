package com.rushi.merchant.validator;

import com.rushi.merchant.vo.LineTypes;

public class CreditsLineValidator implements LineValidator{

	public boolean isValid(String line) {
		return line != null ? line.matches(LineTypes.CREDITS.getPattern()) : false;
	}


}
