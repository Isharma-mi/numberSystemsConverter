package com.example.NumberSystemsConverter.logic;
import java.util.List;
import java.util.ArrayList;


public class DecimalConverter {
	// Gets a decimal num as a String and converts it into a binary num
	public String decimalToBinary(String decimalNumber) {
		// String that will store the converted result, initialize to be empty
		String result = "";
		boolean isNegative = false;
		
		if (decimalNumber.contains("-")) {
			isNegative = true;
			// Gets the input w/o negative sgn
			decimalNumber = decimalNumber.substring(1);
		}
		// Converts string input into long type (helps deal w/numbers that might not fit int)
		long num = Long.parseLong(decimalNumber); 
		
		while (num != 0) {
			// Keep looping until completed division
			
			// Updates string w/remainder value
			result = num%2 + result;
			// Divides num by 2
			num /= 2;
		}
		
		if (isNegative) {
			// If the decimalNumber was negative
			
			// Have string result have the - sign in front
			result = "-" + result;
		}
		
		// Returns converted value as a String
		return result;
	}
}
