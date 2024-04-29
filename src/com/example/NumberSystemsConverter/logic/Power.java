package com.example.NumberSystemsConverter.logic;

public class Power {
	/**
	 * Helper method used to calculate a number raised to a power (for 
	 * int values). Done to take less time that Math.pow() and to avoid 
	 * data conversion loss. 
	 * @param base number that will be raised to an exponent 
	 * @param exponent number that is the exponent to which base is raised
	 * @return int  contains the resulting power of base to the exponent
	 */
	public static int powerInt(int base, int exponent) {
		// Used to store the result
		int result = 1;
		
		// Calculates the result of base raised to the exponent
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
	public static long powerLong(int base, int exponent) {
		// Used to store the result
		long result = 1;

		// Calculates the result of base raised to the exponent
		for (int i = 0; i < exponent; i++) {
			result *= base;
		}
		return result;
	}
}
