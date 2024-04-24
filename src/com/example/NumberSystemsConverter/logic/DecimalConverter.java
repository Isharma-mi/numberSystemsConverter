package com.example.NumberSystemsConverter.logic;


public class DecimalConverter {
	/**
	 * Converts a decimal number into a binary number
	 * @param decimalNumber decimal number that is to be converted
	 * @return result string that will contain the binary result from conversion
	 */
	public String decimalToBinary(String decimalNumber) {
		// Used to store converted result
		String result = "";
		boolean isNegative = false;
		
		if (decimalNumber.contains("-")) {
			// Checks if number to convert is negative
			isNegative = true;
			// Gets the decimal number w/o negative sign
			decimalNumber = decimalNumber.substring(1);
		}
		
		// Converts string input into long type 
		// Helps deal w/numbers that might not fit in an int
		long num = Long.parseLong(decimalNumber); 
		
		while (num != 0) {
			// Keep looping until completed division
			
			// Stores each remainder value w/new remainder value being put in front of old
			result = num%2 + result;
			// Divides num by 2
			num /= 2;
		}
		
		if (isNegative) {
			// Checks if the decimal number is negative
			
			// Puts - sign back in front of converted result
			result = "-" + result;
		}
		
		// Returns converted value as a String
		return result;
	}
}
