package com.example.NumberSystemsConverter.logic;

public class Converter {
	// Gets a binary num as a string and converts it to be a decimal number
	public int binaryToDecimal(String binaryNum) {
		// Array that will contain each digit of the binaryNum
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
		
		// TODO: Change to be actual converted number
		return -1;
	}
}
