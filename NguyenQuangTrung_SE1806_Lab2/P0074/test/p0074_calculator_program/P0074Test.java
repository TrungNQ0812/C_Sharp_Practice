/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0074_calculator_program;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author trung
 */
public class P0074Test {
    P0074 tes;
    
    public P0074Test() {
        tes = new P0074();
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testMenu() {
    }

    @Test
    public void testGetInt() {
    }

     @Test
    public void testAdd() {
        int rs = tes.add(4, 5);
        int expected = 9;
        assertEquals(expected, rs);
    }

    @Test
    public void testNhapMatrix() {
    }

    @Test
    public void testDisplay() {
    }

    @Test
    public void testDisplayResult() {
    }

    @Test
    public void testCalMatrix() {
    }

    @Test
    public void testMulMatrix() {
    }
    
}
