package com.example.NumberSystemsConverter.logic;

public class BinaryConverter {
	/**
	 * Converts a binary number into a decimal number as a long. Done when
	 * to show knowledge of when to use int vs long
	 * @param binaryNum binary number that is to be converted
	 * @return long contains the decimal result from conversion
	 */
	public long binaryToLongDecimal(String binaryNum) {
		// Array that will contain each digit of binaryNum
		byte[] arrayOfDigits = this.createDigitsArray(binaryNum);
		
		// Keeps track of which exponent we are on
		int powerTracker = 0;
		// Will store resulting value from conversion
		long result = 0;
		
		// Loop thru each byte starting from last number -> Exponent starts from 2^0s
		for (int i = arrayOfDigits.length - 1; i >= 0; i--) {
			if (arrayOfDigits[i] == 1) {
				// Check if value at current index is 1, don't need to do any calculations for 0s
				
				// Calculate value of current digit in decimal and add it to result
				result += this.powerLong(2, powerTracker);
			}
			// Increment powerTracker
			powerTracker++;
		}
		
		if (binaryNum.charAt(0) == '-') {
			// Checks if binary num is negative
			
			// Makes result negative
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
		// Array that will contain each digit of binaryNum
		byte[] arrayOfDigits = this.createDigitsArray(binaryNum);
		
		// Keeps track of which exponent we are on
		int powerTracker = 0;
		// Will store resulting value from conversion
		int result = 0;
		//Loop through each byte starting from last number -> Exponent starts from 2^0
		for (int i = arrayOfDigits.length - 1; i >= 0; i--) {
			// Check if value at current index is 1, don't need to do any calculations for 0s
			if (arrayOfDigits[i] == 1) {
				// Calculate value of current digit in decimal and add it to result 
				result += powerInt(2, powerTracker);
			}
			// Increment powerTracker 
			powerTracker++;
		}
		
		if (binaryNum.charAt(0) == '-') {
			// Checks if binary num is negative
			
			// Makes result negative
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
		// Break down binaryNum input into separate digits stored in arrayOfDigits
		for (int i = 0; i < binaryNum.length(); i++) {
			/*
			 * Takes each number from string as char and converts it to byte
			 * In ASCII '0'  is 48 while '1' is 49
			 * Subtract by '0' since binaryNum.charAt(i) will either be 49 or 48   
			 * Ignores negative signs
			 */		
			if (binaryNum.charAt(i) == 'i') {
				continue;
			}
			arrayOfDigits[i] = (byte) (binaryNum.charAt(i) - '0');
		}
		
		return arrayOfDigits;
	}
	
	/**
	 * Helper method used to calculate a number raised to a power (for 
	 * int values). Done to take less time that Math.pow() and to avoid 
	 * data conversion loss. 
	 * @param base number that will be raised to an exponent 
	 * @param exponent number that is the exponent to which base is raised
	 * @return int  contains the resulting power of base to the exponent
	 */
	private int powerInt(int base, int exponent) {
		// Will contain final result
		int result = 1;
		
		// Start from 0 so if exponent is 0 won't loop
		for (int i = 0; i < exponent; i++) {
			result *= base ;
		}
		return result;
	}
	
	/**
	 * Helper method used to calculate a number raised to a power (for 
	 * long values). Done to take less time that Math.pow() and to avoid 
	 * data conversion loss. 
	 * @param base number that will be raised to an exponent 
	 * @param exponent number that is the exponent to which base is raised
	 * @return long contains the resulting power of base to the exponent
	 */
	private long powerLong(int base, int exponent) {
		// Will contain final result
		long result = 1;

		// Start from 0, if exponent is 0 won't loop
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
}
