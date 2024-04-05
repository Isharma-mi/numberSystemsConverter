package com.example.NumberSystemsConverter.logic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Converter converter = new Converter();
		
		// For repeatedly asking for input
		while (true) {
			System.out.println("What number would you like to convert from binary to decimal?");
			
			// Gets user input
			String input = scanner.nextLine();
			
			// Breaks program if user wants to end it
			if (input.equals("end")) {
				break;
			}
			
			System.out.println(converter.power(2, 9));
			// Prints out converted binary to decimal
			// TODO: Verify that input given is of correct format, keep as string but make sure its technically right
			System.out.println(converter.binaryToDecimal(input));
			
		}
	}
}
