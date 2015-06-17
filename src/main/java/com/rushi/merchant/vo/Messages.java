package com.rushi.merchant.vo;

public enum Messages {

	INVALID_INPUT("Input is invalid"),
	INAVLID_ROMAN("Roman number is invalid"),
	NO_IDEA("I have no idea what you are talking about");

	String message;
	
	private Messages(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
}
