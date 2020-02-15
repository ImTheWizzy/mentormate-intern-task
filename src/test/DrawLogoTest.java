package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DrawLogo;

class DrawLogoTest {

	@Test
	void testNumberIsOdd() {		
		assertEquals(true, DrawLogo.numberIsOdd(1));
		assertEquals(false, DrawLogo.numberIsOdd(2));
		assertEquals(true, DrawLogo.numberIsOdd(9999));
		assertEquals(false, DrawLogo.numberIsOdd(10000));
		assertEquals(true, DrawLogo.numberIsOdd(10001));
	}

	@Test
	void testIsValidLetterThickness() {
		assertEquals(true, DrawLogo.isValidLetterThickness(3));
		assertEquals(false, DrawLogo.isValidLetterThickness(4));
		assertEquals(true, DrawLogo.isValidLetterThickness(9999));
		assertEquals(false, DrawLogo.isValidLetterThickness(10000));
		assertEquals(false, DrawLogo.isValidLetterThickness(10001));
	}

}
