package com.example.NumberSystemsConverter.logic;

public class OctalConverter {
	/**
	 * Converts an octal number into a binary number
	 * @param input octal number that is to be converted
	 * @return String contains the binary result from conversion
	 */
	public String octalToBinary(String input) {
		// Used to store converted result
		String result = "";
		boolean isNegative = false;
		
		if (input.charAt(0) == '-') {
			// Checks if number to convert is negative
			
			isNegative = true;
			result = "-";
		}
		
		// Loop variable starts from first actual digit
		// Done since index of 1st digit dependent changes if number is negative
		int i = isNegative ? 1:0;

		// Loop thru each digit of input and convert to its binary equivalent
		for (; i < input.length(); i++) {
			result += digitToOctal(input.charAt(i));
		}
		
		if (result.matches("[0][0][01234567]+") ) {
			// Checks if the resulting conversion has 0s in front
			
			// Tries to remove extra 0s
			try {
				result = result.substring(2);				
			} catch (IndexOutOfBoundsException e) {
				e.printStackTrace();
			}
		}
		
		// Returns converted value as a String
		return result;
	}
	
	//public String octalToDecimal(String input) {}
	
	
	/**
	 * Helper method that converts a digit into the octal form
	 * @param digit octal digit that will be converted into its binary equivalent
	 * @return String contains the binary result from conversion
	 */
	private String digitToOctal(char digit) {
		// Used to store converted digit
		String result = "";
		
		// Sets result to whatever the digit's equivalent is in binary
		switch(digit) {
			case '0':
				result = "000";
				break;
			case '1':
				result = "001";
				break;
			case '2':
				result = "010";
				break;
			case '3':
				result = "011";
				break;
			case '4':
				result = "100";
				break;
			case '5':
				result = "101";
				break;
			case '6':
				result = "110";
				break;
			case '7':
				result = "111";
				break;
			default:
				result = "ERROR: Couldn't convert digit into octal equivalent";
				break;
		}
		return result;
	}

}
