package com.example.NumberSystemsConverter.logic;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// For repeatedly asking for input
		while (true) {
			System.out.println("What number would you like to convert from decimal to binary?");
			
			// Gets user input
			String input = scanner.nextLine();
			
			// Breaks program if user wants to end it
			if (input.equals("end")) {
				break;
			}
			
			
		}
		
	}
}
