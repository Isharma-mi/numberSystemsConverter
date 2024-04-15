package com.example.NumberSystemsConverter.logic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// For repeatedly asking for input
		while (true) {
			System.out.println("------------What kind of conversion are you wanting to perform?------------");
			System.out.println("1: Binary to Decimal"
					+ "\n2: Decimal to Binary"
					+ "\n3: Octal to Binary"
					+ "\nEnd: Type end to stop program");
			
			// Gets user input
			String input = scanner.nextLine();
			

			if (input.equals("end")) {
				// Breaks program if user wants to end it
				
				scanner.close();
				break;
			} else if (input.equals("1")) {
				// Performs decimal to binary conversion
				
				// Asks for binary number
				System.out.println("What is the binary number?");
				// Gets number input as string
				String binaryNumberInString = scanner.nextLine();
				
				if (binaryNumberInString.matches("[-01]+")) {
					// Makes sure input is a binary number by checking it only contains 0s and 1s
					
					// Performs calculations and will print output
					binaryConversion(binaryNumberInString);
				} else {
					System.out.println("ERROR: Binary number was not given.");
				}
			} else if (input.equals("2")) {
				// Performs binary to decimal conversion
				
				// Asks for decimal number
				System.out.println("What is the decimal number?");
				// Gets binary number input as string
				String decimalNumberInString = scanner.nextLine();
				
				if (decimalNumberInString.matches("[-0123456789]+")) {
					// Makes sure input is a decimal number and does not contain any letters

					// Performs calculations and will print output
					decimalConversion(decimalNumberInString);					
				} else {
					System.out.println("ERROR: Decimal number was not given.");
				}
			} else if (input.equals("3")){
				// TODO: Verify input is correct for octal number
				// Performs octal to binary conversion
				octalConversion(input);
				
			} else {
				// For invalid options

				System.out.println("Please pick a valid option!");
			}
			
			// For adding gap in console to make it more readable
			System.out.println();
		}
	}
	
	/*
	 * Method that will contain all the code that is involved in converting a binary num to decimal num
	 * Used to help reduce clutter in main method
	 * void since dealing with either an int or long result -> Printing out result in a string
	 */
	public static void binaryConversion(String input) {
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
				
				result = "Result: " + binaryConverter.binaryToIntDecimal(input);		
			} else {
				// If there are 32 or more digits in our positive input -> long
				
				result = "Result: " + binaryConverter.binaryToLongDecimal(input);
			}
		} else {
			// If dealing with a negative binary number
			
			if (input.length() < 32) {
				// If input is 31 digits and 1 - sign -> int
				
				result = "Result: " + binaryConverter.binaryToIntDecimal(input);
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
					result = "Result: " + binaryConverter.binaryToLongDecimal(input);
				} else {

					result = "Result: " + binaryConverter.binaryToIntDecimal(input);
				}
			} else {
				// If there are more than 32 digits in our negative input
				
				result = "Result: " + binaryConverter.binaryToLongDecimal(input);
			}
				
		}
		
		// Prints out Result: Converted #
		System.out.println(result);
	}

	/*
	 * Method that will contain all the code that is involved in converting a decimal num to binary num
	 * Used to help reduce clutter in main method
	 * void since dealing with either an int or long result -> Printing out result in a string
	 */
	public static void decimalConversion(String input) {
		DecimalConverter deci = new DecimalConverter();
		
		System.out.println("Result: "+ deci.decimalToBinary(input));
	}

	/*
	 * Method that will contain all the code that is involved in converting an octal num to binary num
	 * Used to help reduce clutter in main method
	 * void since dealing with either an int or long result -> Printing out result in a string
	 */	
	public static void octalConversion(String input) {
		// TODO: Put converter here and do conversion with it
	}
}
