package com.rushi.merchant.vo;

public enum RomanNumbers {

	I("I", 1),
	V("V", 5),
	X("X", 10),
	L("L", 50),
	C("C", 100),
	D("D", 500),
	M("M", 1000);
	
	String roman;
	Integer value;
	
	private RomanNumbers(String roman, Integer value) {
		this.roman = roman;
		this.value = value;
	}

	public String getRoman() {
		return roman;
	}

	public Integer getValue() {
		return value;
	}
	
}
