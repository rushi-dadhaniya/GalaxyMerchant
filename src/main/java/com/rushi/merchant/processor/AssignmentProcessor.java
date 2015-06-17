package com.rushi.merchant.processor;

import java.util.Map;

import com.rushi.merchant.util.PrintQueue;
import com.rushi.merchant.validator.AssignmentLineValidator;
import com.rushi.merchant.vo.Messages;

public class AssignmentProcessor implements QueryProcessor{

	public void process(String line, Map<String, String> romanLiterals,
			Map<String, String> arabicLiterals) {

		AssignmentLineValidator assigmentLineValidator = new AssignmentLineValidator();
		if(assigmentLineValidator.isValid(line)) {
			String[] split = line.split("\\s+");
			try {
				romanLiterals.put(split[0], split[2]);
			}
			catch(ArrayIndexOutOfBoundsException exception) {
				PrintQueue.getPrintQueue().add((Messages.INVALID_INPUT.getMessage()));
			}
		}
		else {
			PrintQueue.getPrintQueue().add((Messages.INVALID_INPUT.getMessage()));
		}
		
	}

}
