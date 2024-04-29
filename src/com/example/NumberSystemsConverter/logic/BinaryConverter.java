package com.example.NumberSystemsConverter.logic;

public class BinaryConverter {
	/**
	 * Converts a binary number into a decimal number as a long. Done when
	 * to show knowledge of when to use int vs long
	 * @param binaryNum binary number that is to be converted
	 * @return long contains the decimal result from conversion
	 */
	public long binaryToLongDecimal(String binaryNum) {
		// Array that will contain each digit of binary number sep'ly
		byte[] arrayOfDigits = this.createDigitsArray(binaryNum);
		
		// Keeps track of which exponent we are on
		int exponent = 0;
		// Used to store converted result
		long result = 0;
		
		// Loop thru each byte starting from last number
		for (int i = arrayOfDigits.length - 1; i >= 0; i--) {
			if (arrayOfDigits[i] == 1) {
				// Check if digit at current index is 1, don't need to do any calculations for 0s
				
				// Update result w/ binary digit converted to decimal 
				result += Power.powerLong(2, exponent);
			}
			// Increment exponent
			exponent++;
		}
		
		if (binaryNum.charAt(0) == '-') {
			// Checks if binary num is negative
			
			// Makes converted result negative
			result = -result;
		}
		return result;
	}
	
	/**
	 * Converts a binary number into a decimal number as a long. Done to
	 * show knowledge of when to use int vs long
	 * @param binaryNum binary number that is to be converted
	 * @return int contains the decimal result from conversion
	 */
	public int binaryToIntDecimal(String binaryNum) {
		// Array that will contain each digit of binary number sep'ly
		byte[] arrayOfDigits = this.createDigitsArray(binaryNum);
		
		// Keeps track of which exponent we are on
		int exponent = 0;
		// Used to store converted result
		int result = 0;
		
		//Loop through each byte starting from last number
		for (int i = arrayOfDigits.length - 1; i >= 0; i--) {
			if (arrayOfDigits[i] == 1) {
				//Check if digit at current index is 1, don't need to do any calculations for 0s
				
				// Update result w/binary digit converted to decimal
				result += Power.powerInt(2, exponent);
			}
			
			// Increment exponent 
			exponent++;
		}
		
		if (binaryNum.charAt(0) == '-') {
			// Checks if binary num is negative
			
			// Makes converted result negative
			result = -result;
		}
		
		// Returns converted result
		return result;
	}
	
	/**
	 * Helper method to break down a String of binaryNums to an array of
	 * bytes containing each digit separately. Separate method since it 
	 * will be used for both long and int decimal outcomes from binary
	 * conversion
	 * @param binaryNum binaryNum that will be broken by each digit
	 * @return byte[] each digit of binaryNumb stored sep'ly in an array
	 */
	private byte[] createDigitsArray(String binaryNum) {
		// Array that will contain each digit of the binaryNum
		byte[] arrayOfDigits = new byte[binaryNum.length()];
		
		// Break down binary number into separate digits that will be stored in an arrayOfDigits
		for (int i = 0; i < binaryNum.length(); i++) {
			/*
			 * Takes each number from String as char and converts it to byte
			 * In ASCII '0'  is 48 while '1' is 49
			 * Subtract by '0' since binaryNum.charAt(i) will either be 49 or 48   
			 * Ignores negative signs
			 */		
			arrayOfDigits[i] = (byte) (binaryNum.charAt(i) - '0');
		}
		
		// Returns each digit converted into a byte
		return arrayOfDigits;
	}
	

}
