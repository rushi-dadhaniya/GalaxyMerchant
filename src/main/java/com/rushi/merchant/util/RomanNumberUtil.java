package com.rushi.merchant.util;

import com.rushi.merchant.vo.RomanNumbers;

public class RomanNumberUtil {

	private static final String ROMAN_PATTERN = "^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
	
	public static Integer converToArabic(String roman) {

		if(isRoman(roman) && !roman.isEmpty()) {
			
			int romanLength = roman.length();
			int last = 0;
			int arabicValue = 0;
			for(int romanIterator = romanLength - 1 ; romanIterator >= 0 ; romanIterator--) {
				Character romanChar = roman.charAt(romanIterator);
				Integer value = RomanNumbers.valueOf(romanChar.toString()).getValue();
				arabicValue = findRomanValue(value, last, arabicValue);
				last = value;
			}
			return arabicValue;
		}
		else {
			return null;
		}
		
	}
	
	private static boolean isRoman(String romanNumber) {
		return romanNumber != null ? romanNumber.matches(ROMAN_PATTERN) : false;
	}
	
	private static int findRomanValue(int currentValue, int last, int romanValue) {
		if(last > currentValue) {
			return romanValue - currentValue;
		}
		return romanValue + currentValue;
	}
	
}
