package com.utils;

import org.junit.Assert;

public class CustomAssertion {

	public static void assertEquals(String passingMessage, Object expected, Object actual) {
		try {
			Assert.assertEquals(expected, actual);
			System.out.println(passingMessage);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static void assertTrue(String passingMessage, boolean condition) {
		try {
			Assert.assertTrue(condition);
			System.out.println(passingMessage);
		} catch (AssertionError e) {
			System.out.println(e.getMessage());
		}
	}

}
