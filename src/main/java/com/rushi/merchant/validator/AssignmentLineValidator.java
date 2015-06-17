package com.rushi.merchant.validator;

import com.rushi.merchant.vo.LineTypes;

public class AssignmentLineValidator implements LineValidator{

	public boolean isValid(String line) {
		return line != null ? line.matches(LineTypes.ASSIGNMENT.getPattern()) : false;
	}


}
