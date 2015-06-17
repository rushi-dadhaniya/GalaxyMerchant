package com.rushi.merchant.processor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.util.RomanNumberUtil;
import com.rushi.merchant.validator.HowManyLineValidator;
import com.rushi.merchant.vo.Messages;

public class HowManyProcessor implements QueryProcessor {

	public void process(String line, Map<String, String> romanLiterals,
			Map<String, String> arabicLiterals) {
		
		HowManyLineValidator howManylineValidator = new HowManyLineValidator();
		
		if(howManylineValidator.isValid(line)) {
			
			try {
				
				String formatted = line.split("(\\sis\\s)")[1].replace("?", "").trim();
				String[] literals = formatted.split("\\s");
				
				boolean literalNotfound = false;
				String roman = "";
				List<Double> arabicValues = new ArrayList<Double>();
				for(String literal : literals) {
					String romanValue = romanLiterals.get(literal);
					String arabicValue = arabicLiterals.get(literal);
					if(romanValue != null) {
						roman += romanValue;
					}
					else if(arabicValue != null){
						arabicValues.add(Double.parseDouble(arabicValue));
					}
					else
						literalNotfound = true;
				}
				
				if(!literalNotfound) {
					Double totalArabicValue = (double) 1;
					for(Double arabicValue : arabicValues) {
						totalArabicValue *= arabicValue;
					}
					int credits = (int) (RomanNumberUtil.converToArabic(roman) * totalArabicValue);
					PrintQueue.getPrintQueue().add((formatted + " is " + credits + " Credits"));
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
