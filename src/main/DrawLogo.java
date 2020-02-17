package main;

import java.util.Scanner;

public class DrawLogo {
	
	class DrawLetterM {
		int letterThicknessMin;
		int letterThicknessMax;
		int letterThickness;
		int chunkSize;
		
		char emptySpaceChar;
		char fillSpaceChar;
	}

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
		int counter2 = 0;
		
		boolean counterReachedZero = false;
		
		boolean midPointReached = false;
		
		for(int columnCount = 0; columnCount < letterThickness * 5; columnCount++) { //FOR EACH CHUNK OF N SIZED CHARACTERS
			for(int rowCountUp = 0, rowCountDown = letterThickness; rowCountUp < letterThickness + 1; rowCountUp++, rowCountDown--) { //FOR VERTICAL LINES
				if(counterReachedZero || columnCount + letterThickness >= letterThickness * 5) {
					if(rowCountUp < counter) {
						asciiGrid[rowCountDown][columnCount] = "*";
					} else {
						asciiGrid[rowCountDown][columnCount] = "-";
					}
				} else if(midPointReached) {
					if(rowCountUp >= counter2) {
						asciiGrid[rowCountDown][columnCount] = "*";
					} else {
						asciiGrid[rowCountDown][columnCount] = "-";
					}
				} else if(counter > 0) {
					if(rowCountUp >= counter) {
						asciiGrid[rowCountUp][columnCount] = "*";
					} else {
						asciiGrid[rowCountUp][columnCount] = "-";
					}
				} else {
					if(rowCountUp > counter2) {
						asciiGrid[rowCountDown][columnCount] = "*";
					} else {
						asciiGrid[rowCountDown][columnCount] = "-";
					}
				}
			}
			
			if(counter > 0) {
				counter--;
				if(counter == (letterThickness + 1) / 2) {
					counterReachedZero = false;
				}
				if(counter == 0) {
					counter2 = 0;
				}
			} else if(midPointReached) {
				counter2--;
				if(counter2 == 0) {
					counter = letterThickness;
					midPointReached = false;
					counterReachedZero = true;
				}
			} else {
				if(counter2 + 1 == (letterThickness + 1) / 2) {
					midPointReached = true;
				} else {
					counter2++;
				}
			}
		}
		
		for(String[] rows : asciiGrid) {
			for(String column : rows) {
				System.out.print(column);
			}
			
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
