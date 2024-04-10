package com.example.NumberSystemsConverter.logic;
import java.util.List;
import java.util.ArrayList;


public class DecimalConverter {

	// TODO: Deal w/negative, see if negative number deal w/as positive -> add negative at end of conversion
	// TODO: Verify parameter is correct in Main
	public String decimalToBinary(String decimalNumber) {
		// String that will store the converted result, initialize to be empty
		String result = "";
		
		// Converts string input into long type
		long num = Long.parseLong(decimalNumber); 
		
		while (num != 0) {
			// Keep looping until completed division
			
			// Updates string w/remainder value
			result = num%2 + result;
			// Divides long num by 2
			num /= 2;
		}
		
		return "Result: " + result;
	}
}
