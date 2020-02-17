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
		String [][] asciiGrid = new String[letterThickness + 1][letterThickness * 5];
		
		int counter = letterThickness;
		
		boolean counterReachedZero = false;
		
		boolean midPointReached = false;
		
		for(int columnCount = 0; columnCount < letterThickness * 5; columnCount++) { //FOR EACH CHUNK OF N SIZED CHARACTERS
			for(int rowCount = 0; rowCount < letterThickness + 1; rowCount++) { //FOR VERTICAL LINES
//				if(!counterReachedZero && counter >= (letterThickness + 1) / 2) {
//					if(rowCount < letterThickness - counter) {
//						asciiGrid[rowCount][columnCount] = "*";
//					} else {
//						asciiGrid[rowCount][columnCount] = "-";
//					}
//					counter--;
//				}
//				else
				if(midPointReached) {
					if(rowCount <= counter) {
						asciiGrid[rowCount][columnCount] = "*";
					} else {
						asciiGrid[rowCount][columnCount] = "-";
					}
				} else if(counterReachedZero) {
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
			
			if(counter > 0 && !counterReachedZero) {
				counter--;
				if(counter <= 0) {
					counterReachedZero = true;
				}
			} else {
				counter++;
//				if(counter >= (letterThickness + 1) / 2) {
//					counterReachedZero = false;
//				}
				if(counter >= (letterThickness + 1) / 2) {
					midPointReached = true;
				}
				if(counter >= letterThickness) {
					counterReachedZero = false;
					midPointReached = false;
				}
			}
		}
		
		for(String[] rows : asciiGrid) {
			for(String column : rows) {
				System.out.print(column);
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
