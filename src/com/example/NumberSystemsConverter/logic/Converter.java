package com.example.NumberSystemsConverter.logic;

public class Converter {
	// Gets a binary num as a string and converts it to be a decimal number
	public int binaryToDecimal(String binaryNum) {
		// Array that will contain each digit of the binaryNum, not needed but keep in case wanna show steps later
		byte[] arrayOfDigits = new byte[binaryNum.length()];
		
		// Break down binaryNum input into separate digits stored in arrayOfDigits
		for (int i = 0; i < binaryNum.length(); i++) {
			/*
			 * Takes each number from string as char and converts it to byte
			 * In ASCII '0'  is 48 while '1' is 49
			 * Subtract by '0' since binaryNum.charAt(i) will either be 49 or 48   
			 */		
			arrayOfDigits[i] = (byte) (binaryNum.charAt(i) - '0');
			System.out.println(arrayOfDigits[i]);
		}
		
		// Loop thru byte[] and convert each to an int
		int powerTracker = 0;
		for (int i = arrayOfDigits.length - 1; i >= 0; i--) {
			int digitToDecimal = arrayOfDigits[i] * (int) Math.pow(2, powerTracker++);
		}
		
		// TODO: Change to be actual converted number
		return -1;
	}
	
	/* 
	 * Helper method to calculate a number raised to a power
	 * Done to take less time than Math.pow() and to avoid data conversion loss
	 * Don't need to verify input since its a helper method, just need to make sure it receives valid arguments
	 */
	public int power(int base, int exponent) {
		// Initialize to the base
		int result = 1;
		// Start from 0 so if exponent is 0 won't loop
		for (int i = 0; i < exponent; i++) {
			result *= base ;
		}
		return result;
	}
}
