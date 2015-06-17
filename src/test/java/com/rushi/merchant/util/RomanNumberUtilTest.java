package com.rushi.merchant.util;

import org.junit.Assert;
import org.junit.Test;

public class RomanNumberUtilTest {

	@Test
	public void convertArabicUpperBound() {
		Integer arabic = RomanNumberUtil.converToArabic("MMMM");
		Assert.assertEquals(new Integer(4000), arabic);;
	}
	
	@Test
	public void convertArabicLowestNumber() {
		Integer arabic = RomanNumberUtil.converToArabic("I");
		Assert.assertEquals(new Integer(1), arabic);;
	}
	
	@Test
	public void convertToArabicInvalidNumber() {
		Integer arabic = RomanNumberUtil.converToArabic("XCDM");
		Assert.assertNull(arabic);
	}
	
	@Test
	public void convertToArabicValidNumber() {
		Integer arabic = RomanNumberUtil.converToArabic("XXX");
		Assert.assertEquals(new Integer(30), arabic);;
	}
	
	@Test
	public void convertToArabicInavlidNumber() {
		Integer arabic = RomanNumberUtil.converToArabic("XXXY");
		Assert.assertNull(arabic);
	}
	
	@Test
	public void convertToArabicWithEmptyString() {
		Integer arabic = RomanNumberUtil.converToArabic("");
		Assert.assertNull(arabic);
	}
	
	@Test
	public void convertToArabicWithNull() {
		Integer arabic = RomanNumberUtil.converToArabic(null);
		Assert.assertNull(arabic);
	}

}
