package com.rushi.merchant.processor;

import java.util.Map;

import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.util.RomanNumberUtil;
import com.rushi.merchant.validator.CreditsLineValidator;
import com.rushi.merchant.vo.Messages;

public class CreditsProcessor implements QueryProcessor{

	public void process(String line, Map<String, String> romanLiterals,
			Map<String, String> arabicLiterals) {
		CreditsLineValidator creditsLineValidator  = new CreditsLineValidator();
		if(creditsLineValidator.isValid(line)) {
			
			try {
				String formatted = line.replaceAll("(is\\s+)|([c|C]redits\\s*)", "").trim();
				
				String[] literals = formatted.split("\\s");
				
				String arabicLiteral = literals[literals.length - 2];
				Double value = Double.parseDouble(literals[literals.length - 1]);
				
				String roman = "";
				
				for(int literalIterator =  0 ; literalIterator < literals.length - 2 ; literalIterator++) {
					roman += romanLiterals.get(literals[literalIterator]);
				}
				
				int arabicNumber = RomanNumberUtil.converToArabic(roman);
				Double credits = value / arabicNumber;
				arabicLiterals.put(arabicLiteral, credits.toString());
			}
			catch(Exception exception) {
				PrintQueue.getPrintQueue().add(Messages.INVALID_INPUT.getMessage());
			}
			
		}
		else {
			PrintQueue.getPrintQueue().add(Messages.INVALID_INPUT.getMessage());
		}
		
	}

}
