package net.ads.mrpaul.xc240.ps09;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FibonacciTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testRecursiveFibonacci() {
        assertEquals(1, Fibonacci.recursiveFibonacci(1));
        assertEquals(1, Fibonacci.recursiveFibonacci(2));
        assertEquals(55, Fibonacci.recursiveFibonacci(10));
        assertEquals(6765, Fibonacci.recursiveFibonacci(20));
    }

    @Test
    public void testDynamicFibonacci() {
        assertEquals(0, Fibonacci.dynamicFibonacci(0));
        assertEquals(1, Fibonacci.dynamicFibonacci(1));
        assertEquals(1, Fibonacci.dynamicFibonacci(2));
        assertEquals(55, Fibonacci.dynamicFibonacci(10));
        assertEquals(6765, Fibonacci.dynamicFibonacci(20));
    }
}
