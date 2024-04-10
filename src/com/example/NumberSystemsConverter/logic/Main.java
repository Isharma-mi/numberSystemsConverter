package com.example.NumberSystemsConverter.logic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

// TESTING CODE START 
		DecimalConverter deci = new DecimalConverter();
		
		String num = "-437626";
		System.out.println(deci.decimalToBinary(num));
// TESTING CODE END
		
		// For repeatedly asking for input
		while (true) {
			System.out.println("------------What kind of conversion are you wanting to perform?------------");
			System.out.println("1: Binary to Decimal"
					+ "\n2: Decimal to Binary"
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
				// TODO: Verify that input given is of correct format (keep as string but make sure its technically right)
				// Gets number input as string
				String binaryNumberInString = scanner.nextLine();
				// Performs calculations and will print output
				binaryConversion(binaryNumberInString);
			} else if (input.equals("2")) {
				// Performs binary to decimal conversion
				System.out.println("What is the decimal number?");
				// TODO: Verify that input given is of correct format (keep as string but make sure its technically right)
				// Gets binary number input as string
				
			}else {
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
			
			System.out.println("TESTING: Positive input");
			if (input.length() < 32) {
				// If there are 31 digits in our positive input -> int
				
				System.out.println("TESTING: Converting to int");
				result = "Result: " + binaryConverter.binaryToIntDecimal(input);		
			} else {
				// If there are 32 or more digits in our positive input -> long
				
				System.out.println("TESTING: Converting to long");
				result = "Result: " + binaryConverter.binaryToLongDecimal(input);
			}
		} else {
			// If dealing with a negative binary number
			
			System.out.println("TESTING: Negative input");
			if (input.length() < 32) {
				// If input is 31 digits and 1 - sign -> int
				
				System.out.println("TESTING: Converting to int");
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
					System.out.println("TESTING: Converting to long");
					result = "Result: " + binaryConverter.binaryToLongDecimal(input);
				} else {
					System.out.println("TESTING: Converting to int");
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
}
