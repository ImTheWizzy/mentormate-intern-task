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
	
	public void printAsciiLogo() {
		char [][] asciiGrid = new char[letterThickness + 1][letterThickness * chunkSize];
		
		int counterUp = 0;
		int counterDown = letterThickness;
		
		boolean reachedZeroFlag = false;
		boolean reachedMidpointFlag = false;
		
		for(int columnCount = 0; columnCount < letterThickness * chunkSize; columnCount++) {
			for(int rowCountUp = 0, rowCountDown = letterThickness; rowCountUp < letterThickness + 1; rowCountUp++, rowCountDown--) {
				if(reachedZeroFlag || columnCount + letterThickness >= letterThickness * chunkSize) {
					if(rowCountUp < counterDown) {
						asciiGrid[rowCountDown][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountDown][columnCount] = emptySpaceChar;
					}
				} else if(reachedMidpointFlag) {
					if(rowCountUp >= counterUp) {
						asciiGrid[rowCountDown][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountDown][columnCount] = emptySpaceChar;
					}
				} else if(counterDown > 0) {
					if(rowCountUp >= counterDown) {
						asciiGrid[rowCountUp][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountUp][columnCount] = emptySpaceChar;
					}
				} else {
					if(rowCountUp > counterUp) {
						asciiGrid[rowCountDown][columnCount] = fillSpaceChar;
					} else {
						asciiGrid[rowCountDown][columnCount] = emptySpaceChar;
					}
				}
			}
			
			if(counterDown > 0) {
				counterDown--;
				if(counterDown == (letterThickness + 1) / 2) {
					reachedZeroFlag = false;
				}
				if(counterDown == 0) {
					counterUp = 0;
				}
			} else if(reachedMidpointFlag) {
				counterUp--;
				if(counterUp == 0) {
					counterDown = letterThickness;
					reachedMidpointFlag = false;
					reachedZeroFlag = true;
				}
			} else {
				if(counterUp + 1 == (letterThickness + 1) / 2) {
					reachedMidpointFlag = true;
				} else {
					counterUp++;
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
