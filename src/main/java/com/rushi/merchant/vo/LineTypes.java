package com.rushi.merchant.vo;

public enum LineTypes {

	ASSIGNMENT("^([A-Za-z]+) is ([I|V|X|L|C|D|M]*)$"),
	CREDITS("^([A-Za-z]+)([A-Za-z\\s]*) is ([0-9]+) ([c|C]redits)$"),
	HOW_MUCH("^how much is (([A-Za-z\\s])+)\\?$"),
	HOW_MANY("^how many [c|C]redits is (([A-Za-z\\s])+)\\?$");
	
	String pattern;
	
	private LineTypes(String pattern) {
		this.pattern = pattern;
	}

	public String getPattern() {
		return pattern;
	}
	
}
