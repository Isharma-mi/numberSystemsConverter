package com.example.NumberSystemsConverter.logic;

public class OctalConverter {
	public String octalToBinary(String input) {
		// TODO: Implement conversion
		// Will store the converted results
		String result = "";
		boolean isNegative = false;
		
		if (input.charAt(0) == '-') {
			// Checks whether or not the octal number is a negative
			isNegative = true;
			result = "-";
		}
		
		// Loop variable start from first char or second digit depending on if there is a - sign
		int i = isNegative ? 1:0;
		// Loop thru each digit of input and convert to binary
		for (; i < input.length(); i++) {
			result += digitToOctal(input.charAt(i));
		}
		
		// Returns converted value as a String
		return result;
	}
	
	
	/* 
	 * Helper method to convert a digit into the octal form
	 * Done to make octalToBinary method more clean to read
	 * Don't need to verify input since its a helper method, just need to make sure it receives valid arguments
	 */
	private String digitToOctal(char digit) {
		// Will store converted results
		String result = "";
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
