package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {
	
	public static String getNumericValues(String string) {
		String numValue = "";
		
		Pattern p = Pattern.compile("[0-9.]+");	// to get only numeric values including dot (.)
		Matcher m = p.matcher(string);
		while (m.find()) {
			numValue = numValue + m.group();
		}
		
		return numValue;
	}
}
