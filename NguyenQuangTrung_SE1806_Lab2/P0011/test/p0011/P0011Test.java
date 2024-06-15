/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0011;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trung
 */
public class P0011Test {
    P0011 main;
    
    public P0011Test() {
        main = new P0011();
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testMenu() {
    }

    @Test
    public void testGetChoice() {
        assertEquals(2, main.getChoice("Choose a number", 1, 3));
        
        // Edge case: Input out of range
        assertEquals(-1, main.getChoice("Choose a number", 1, 3));
    }

    @Test
    public void testIsBinary1() {
         // Valid binary input
        assertTrue(main.isBinary("1010"));
    }
    @Test
    public void testIsBinary2() {
        // Invalid binary input
        assertFalse(main.isBinary("1020"));
    }
    @Test
    public void testIsBinary3() {
        // Empty input
        assertFalse(main.isBinary(""));
    }

    @Test
    public void testIsHexadecimal1() {
         // Valid hexadecimal input
        assertTrue(main.isHexadecimal("A1F"));
    }
    @Test
    public void testIsHexadecimal2() {
        // Invalid hexadecimal input
        assertFalse(main.isHexadecimal("GHI"));
    }
    @Test
    public void testIsHexadecimal3() {
        // Input with prefix 0x
        assertTrue(main.isHexadecimal("0xA1F"));
    }
    @Test
    public void testIsHexadecimal4() {
        // Empty input
        assertFalse(main.isHexadecimal(""));
    }

    @Test
    public void testIsDecimal1() {
         // Valid decimal input
        assertTrue(main.isDecimal("123"));
    }
    @Test
    public void testIsDecimal2() {
        // Invalid decimal input
        assertFalse(main.isDecimal("12A3"));
    }
    @Test
    public void testIsDecimal3() {
        // Empty input
        assertFalse(main.isDecimal(""));
    }

    @Test
    public void testConvertToDecimal1() {
        // Binary to Decimal
        assertEquals(new BigInteger("10"), main.convertToDecimal("1010", 2));
    }
    @Test
    public void testConvertToDecimal2() {
        // Hexadecimal to Decimal
        assertEquals(new BigInteger("255"), main.convertToDecimal("FF", 16));
    }
    @Test
    public void testConvertToDecimal3() {
        // Decimal to Decimal (no conversion)
        assertEquals(new BigInteger("123"), main.convertToDecimal("123", 10));
    }

    @Test
    public void testConvertDecimalToBase1() {
        // Decimal to Binary
        assertEquals("1010", main.convertDecimalToBase("10", 2));
    }
    @Test
    public void testConvertDecimalToBase2() {
        // Decimal to Hexadecimal
        assertEquals("FF", main.convertDecimalToBase("255", 16));
    }
    @Test
    public void testConvertDecimalToBase3() {
        // Decimal to Decimal (no conversion)
        assertEquals("123", main.convertDecimalToBase("123", 10));
    }
    @Test
    public void testConvertDecimalToBase4() {
        // Decimal to Decimal (no conversion)
        assertEquals("0", main.convertDecimalToBase("", 16));
    }
    @Test
    public void testConvertDecimalToBase5() {
        // Decimal to Decimal (no conversion)
        assertEquals("1010", main.convertDecimalToBase("10", 16));
    }
    @Test
    public void testConvertDecimalToBase6() {
        // Decimal to Decimal (no conversion)
        assertEquals("0", main.convertDecimalToBase("0", 16));
    }

}
