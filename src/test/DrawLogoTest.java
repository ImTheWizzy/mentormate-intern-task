package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DrawLogo;

class DrawLogoTest {

	@Test
	void testIsOdd() {		
		assertEquals(true, DrawLogo.isOdd(1));
		assertEquals(false, DrawLogo.isOdd(2));
		assertEquals(true, DrawLogo.isOdd(9999));
		assertEquals(false, DrawLogo.isOdd(10000));
		assertEquals(true, DrawLogo.isOdd(10001));
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
