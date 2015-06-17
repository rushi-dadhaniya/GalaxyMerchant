package com.rushi.merchant.processor;

import java.util.Map;

import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.util.RomanNumberUtil;
import com.rushi.merchant.validator.HowMuchLineValidator;
import com.rushi.merchant.vo.Messages;

public class HowMuchProcessor implements QueryProcessor {

	public void process(String line, Map<String, String> romanLiterals,
			Map<String, String> arabicLiterals) {
		HowMuchLineValidator howMuchLineValidator = new HowMuchLineValidator();
		if(howMuchLineValidator.isValid(line)) {
			
			try {
				String formatted = line.split("\\sis\\s")[1].trim().replace("?", "").trim();
				String[] literals = formatted.split("\\s+");
				
				String roman = "";
				boolean literalNotFound = false;
				
				for(String literal : literals) {
					String romanValue = romanLiterals.get(literal);
					if(romanValue == null) {
						PrintQueue.getPrintQueue().add((Messages.NO_IDEA.getMessage()));
						literalNotFound = true;
						break;
					}
					roman += romanValue;
				}
				if(!literalNotFound) {
					int result = RomanNumberUtil.converToArabic(roman);
					PrintQueue.getPrintQueue().add((formatted + " is " + (int)result));
				}
			}
			catch(Exception exception) {
				PrintQueue.getPrintQueue().add((Messages.INVALID_INPUT.getMessage()));
			}
			
		}
		else {
			PrintQueue.getPrintQueue().add((Messages.INVALID_INPUT.getMessage()));
		}
	}
	

}
