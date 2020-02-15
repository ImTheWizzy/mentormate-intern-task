package main;

import java.util.Scanner;

public class DrawLogo {

	public static boolean numberIsOdd(int numberToCheck) {
		if(numberToCheck % 2 != 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidLetterThickness(int letterThickness) {
		if((letterThickness > 2 && letterThickness < 10000) && numberIsOdd(letterThickness)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner inputStream = new Scanner(System.in);
		
		int letterThickness = inputStream.nextInt();
		
		if(isValidLetterThickness(letterThickness)) {
			System.out.println("VALID!");
		} else {
			System.out.println("INVALID!");	
		}
		
		inputStream.close();
	}

}
