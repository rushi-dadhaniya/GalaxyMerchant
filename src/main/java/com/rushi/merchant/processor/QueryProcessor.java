package com.rushi.merchant.processor;

import java.util.Map;

public interface QueryProcessor {

	public void process(String line, Map<String, String> romanLiterals,
			Map<String, String> arabicLiterals);
	
}
