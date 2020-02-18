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
		DrawLogo testObject1 = new DrawLogo(2, 10000, 3, '-', '*');
		assertEquals(true, testObject1.isValidLetterThickness());
		DrawLogo testObject2 = new DrawLogo(2, 10000, 4, '-', '*');
		assertEquals(false, testObject2.isValidLetterThickness());
		DrawLogo testObject3 = new DrawLogo(2, 10000, 9999, '-', '*');
		assertEquals(true, testObject3.isValidLetterThickness());
		DrawLogo testObject4 = new DrawLogo(2, 10000, 10000, '-', '*');
		assertEquals(false, testObject4.isValidLetterThickness());
		DrawLogo testObject5 = new DrawLogo(2, 10000, 10001, '-', '*');
		assertEquals(false, testObject5.isValidLetterThickness());
	}

}
