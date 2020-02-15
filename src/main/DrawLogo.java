package main;

import java.util.Arrays;
import java.util.Scanner;

public class DrawLogo {

	public static boolean isOdd(int numberToCheck) {
		if(numberToCheck % 2 != 0) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidLetterThickness(int letterThickness) {
		if((letterThickness > 2 && letterThickness < 10000) && isOdd(letterThickness)) {
			return true;
		}
		return false;
	}
	
	static void printAsciiLogo(int letterThickness) {
		String [][] asciiGrid = new String[letterThickness + 1][letterThickness * 10];
		
		int counter = letterThickness;
		
		boolean counterReachedZero = false;
		
		for(int columnCount = 0; columnCount < letterThickness * 10; columnCount++) { //FOR EACH CHUNK OF N SIZED CHARACTERS
			for(int rowCount = 0; rowCount < letterThickness + 1; rowCount++) { //FOR VERTICAL LINES
				if(counterReachedZero) {
					if(rowCount < letterThickness - counter) {
						asciiGrid[rowCount][columnCount] = "*";
					} else {
						asciiGrid[rowCount][columnCount] = "-";
					}
				} else {
					if(rowCount >= counter) {
						asciiGrid[rowCount][columnCount] = "*";
					} else {
						asciiGrid[rowCount][columnCount] = "-";
					}	
				}
			}
			
			if(!counterReachedZero) {
				counter--;
				if(counter == 0) {
					counterReachedZero = true;
				}
			} else if(counterReachedZero) {
				counter++;
				if(counter >= (letterThickness + 1) / 2) {
					counterReachedZero = false;
					counter--;
				}
//				if(counter == letterThickness) {
//					counterReachedZero = false;
//				}
			}
		}
		
		for(String[] x : asciiGrid) {
			for(String y : x) {
				System.out.print(y);
			}
			System.out.print('\n');
		}
	}
	
	public static void main(String[] args) {
		Scanner inputStream = new Scanner(System.in);
		
		int letterThickness = inputStream.nextInt();
		
		if(isValidLetterThickness(letterThickness)) {
			printAsciiLogo(letterThickness);
		}
		
		inputStream.close();
	}

}
