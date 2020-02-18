package main;

import java.util.Scanner;

public class DrawLogo {
	int letterThicknessMin;
	int letterThicknessMax;
	int letterThickness;
	int chunkSize = 5;
	
	char emptySpaceChar;
	char fillSpaceChar;
	
	public DrawLogo() {
		letterThicknessMin = 2;
		letterThicknessMax = 10000;
		letterThickness = 3;
		
		emptySpaceChar = '-';
		fillSpaceChar = '*';
	}
	
	public DrawLogo(int letterThicknessMin, int letterThicknessMax, int letterThickness, char emptySpaceChar, char fillSpaceChar) {
		this.letterThicknessMin = letterThicknessMin;
		this.letterThicknessMax = letterThicknessMax;
		this.letterThickness = letterThickness;
		
		this.emptySpaceChar = emptySpaceChar;
		this.fillSpaceChar = fillSpaceChar;
	}
	
	public static boolean isOdd(int numberToCheck) {
		if(numberToCheck % 2 != 0) {
			return true;
		}
		return false;
	}
	
	public boolean isValidLetterThickness() {
		if((letterThickness > letterThicknessMin && letterThickness < letterThicknessMax) && isOdd(letterThickness)) {
			return true;
		}
		return false;
	}
	
	void printAsciiLogo() {
		char [][] asciiGrid = new char[letterThickness + 1][letterThickness * chunkSize];
		
		int counter = letterThickness;
		int counter2 = 0;
		
		boolean counterReachedZero = false;
		
		boolean midPointReached = false;
		
		for(int columnCount = 0; columnCount < letterThickness * chunkSize; columnCount++) { //FOR EACH CHUNK OF N SIZED CHARACTERS
			for(int rowCountUp = 0, rowCountDown = letterThickness; rowCountUp < letterThickness + 1; rowCountUp++, rowCountDown--) { //FOR VERTICAL LINES
				if(counterReachedZero || columnCount + letterThickness >= letterThickness * chunkSize) {
					if(rowCountUp < counter) {
						asciiGrid[rowCountDown][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountDown][columnCount] = emptySpaceChar;
					}
				} else if(midPointReached) {
					if(rowCountUp >= counter2) {
						asciiGrid[rowCountDown][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountDown][columnCount] = emptySpaceChar;
					}
				} else if(counter > 0) {
					if(rowCountUp >= counter) {
						asciiGrid[rowCountUp][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountUp][columnCount] = emptySpaceChar;
					}
				} else {
					if(rowCountUp > counter2) {
						asciiGrid[rowCountDown][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountDown][columnCount] = emptySpaceChar;
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
		
		for(char[] rows : asciiGrid) {
			for(char column : rows) {
				System.out.print(column);
			}
			
			for(char column : rows) {
				System.out.print(column);
			}
			
			System.out.print('\n');
		}
	}


	public static void main(String[] args) {
		Scanner inputStream = new Scanner(System.in);
		
		int letterThickness = inputStream.nextInt();
		
		DrawLogo drawLetter = new DrawLogo(2, 10000, letterThickness, '-', '*');
		
		if(drawLetter.isValidLetterThickness()) {
			drawLetter.printAsciiLogo();
		} else {
			System.out.println("Invalid input for N! Exiting...");
		}
		
		inputStream.close();
	}

}
