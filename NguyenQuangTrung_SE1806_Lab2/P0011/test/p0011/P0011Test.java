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
    public void testGetChoiceEdgeCases1() {
        // Edge case: Input is less than the minimum value
        assertEquals(-1, main.getChoice("Choose a number", 5, 10));
    }
    @Test
    public void testGetChoiceEdgeCases2() {
        // Edge case: Input is greater than the maximum value
        assertEquals(-1, main.getChoice("Choose a number", 1, 3));
    }
    @Test
    public void testGetChoiceEdgeCases3() {
        // Edge case: Input exactly at the minimum value
        assertEquals(1, main.getChoice("Choose a number", 1, 3));
    }
    @Test
    public void testGetChoiceEdgeCases4() {
        // Edge case: Input exactly at the maximum value
        assertEquals(3, main.getChoice("Choose a number", 1, 3));
    }

    @Test
    public void testIsBinaryEdgeCases1() {
        // Edge case: Single character binary
        assertTrue(main.isBinary("1"));
    }
    @Test
    public void testIsBinaryEdgeCases2() {
        // Edge case: Single character non-binary
        assertFalse(main.isBinary("2"));
    }
    @Test
    public void testIsBinaryEdgeCases3() {
        // Edge case: Binary string with spaces
        assertFalse(main.isBinary("10 10"));
    }
    @Test
    public void testIsBinaryEdgeCases4() {
        // Edge case: Binary string with mixed characters
        assertFalse(main.isBinary("10a10"));
    }

    @Test
    public void testIsHexadecimalEdgeCases1() {
        // Edge case: Single character hexadecimal
        assertTrue(main.isHexadecimal("F"));
    }
    @Test
    public void testIsHexadecimalEdgeCases2() {
        // Edge case: Single character non-hexadecimal
        assertFalse(main.isHexadecimal("G"));
    }
    @Test
    public void testIsHexadecimalEdgeCases3() {
        // Edge case: Hexadecimal string with prefix
        assertTrue(main.isHexadecimal("0xFF"));
    }
    @Test
    public void testIsHexadecimalEdgeCases4() {
        // Edge case: Hexadecimal string with spaces
        assertFalse(main.isHexadecimal("A F"));
    }

    @Test
    public void testIsDecimalEdgeCases1() {
        // Edge case: Single character decimal
        assertTrue(main.isDecimal("1"));
    }
    @Test
    public void testIsDecimalEdgeCases2() {
        // Edge case: Single character non-decimal
        assertFalse(main.isDecimal("a"));
    }
    @Test
    public void testIsDecimalEdgeCases3() {
        // Edge case: Decimal string with spaces
        assertFalse(main.isDecimal("12 34"));
    }
    @Test
    public void testIsDecimalEdgeCases4() {
        // Edge case: Decimal string with mixed characters
        assertFalse(main.isDecimal("12a34"));
    }

    @Test
    public void testConvertToDecimalEdgeCases1() {
        // Edge case: Empty string
        assertEquals(BigInteger.ZERO, main.convertToDecimal("", 2));
    }
    @Test
    public void testConvertToDecimalEdgeCases2() {
        // Edge case: Large binary number
        assertEquals(new BigInteger("1048576"), main.convertToDecimal("100000000000000000000", 2));
    }
    @Test
    public void testConvertToDecimalEdgeCases3() {
        // Edge case: Large hexadecimal number
        assertEquals(new BigInteger("1048576"), main.convertToDecimal("100000", 16));
    }

    @Test
    public void testConvertDecimalToBaseEdgeCases1() {
        // Edge case: Zero
        assertEquals("0", main.convertDecimalToBase("0", 2));
    }
    @Test
    public void testConvertDecimalToBaseEdgeCases2() {
        // Edge case: Large number conversion to binary
        assertEquals("100000000000000000000", main.convertDecimalToBase("1048576", 2));
    }
    @Test
    public void testConvertDecimalToBaseEdgeCases3() {
        // Edge case: Large number conversion to hexadecimal
        assertEquals("100000", main.convertDecimalToBase("1048576", 16));
    }
}
