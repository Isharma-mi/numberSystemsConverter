package com.example.NumberSystemsConverter.logic;

public class Converter {

	
	/*
	 * Method that will contain all the code that is involved in converting a binary num to decimal num
	 * Specifically helps determine if conversion will be calculated as an int or long
	 * void since dealing with either an int or long result -> Printing out result in a string
	 */
	public String binaryConversion(String input) {
		BinaryConverter binaryConverter = new BinaryConverter();
		boolean isNegative = false;
		// Set return var to this to know if error occurred during conversion
		String result = "No calculation done";

		if (input.contains("-")) {
			// Checks if input is a negative binary numbers
			
			// Used since negative inputs will have their length modified by the - sign as well
			isNegative = true;
		}
		
		if (!isNegative) {
			// If dealing with a positive binary number
			
			if (input.length() < 32) {
				// If there are 31 digits in our positive input -> int
				result = Integer.toString(binaryConverter.binaryToIntDecimal(input));		
			} else {
				// If there are 32 or more digits in our positive input -> long
				
				result = Long.toString(binaryConverter.binaryToLongDecimal(input));
			}
		} else {
			// If dealing with a negative binary number
			
			if (input.length() < 32) {
				// If input is 31 digits and 1 - sign -> int
				
				result = Integer.toString(binaryConverter.binaryToIntDecimal(input));
			} else if (input.length() == 33) {
				// If input is 32 digits and 1 - sign
				
				boolean convertToLong = false;
				int numOfOnes = 0;
				
				// Loop thru each character of the input to check if there is atelast1 1s
				for (int i = 1; i < input.length(); i++) {
					if (input.charAt(i) == '1') {
						// If the current char is a 1
						numOfOnes++;
						
						if (numOfOnes > 1) {
							// If there are multiple 1s in the num -> long
							
							// Need to convert input to a long
							convertToLong = true;
							break;
						}
					}
				}
				
				if (convertToLong) {
					result = Long.toString(binaryConverter.binaryToLongDecimal(input));
				} else {

					result = Integer.toString(binaryConverter.binaryToIntDecimal(input));
				}
			} else {
				// If there are more than 32 digits in our negative input
				
				result = Long.toString(binaryConverter.binaryToLongDecimal(input));
			}
				
		}
		
		// Prints out Result: Converted #
		return result;
	}
}
