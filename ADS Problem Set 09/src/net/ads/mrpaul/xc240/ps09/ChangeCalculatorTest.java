package net.ads.mrpaul.xc240.ps09;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ChangeCalculatorTest {
    int[] a, b, c, d;
    @Before
    public void setUp() throws Exception {
        a = new int[] {1, 5, 15, 25};
        b = new int[] {1, 2, 5, 10};
        c = new int[] {1, 12, 39};
        d = new int[] {1};
    }

    @After
    public void tearDown() throws Exception {
        a = new int[]{};
        b = new int[]{};
        c = new int[]{};
        d = new int[]{};
    }

    @Test
    public void testRecursiveMinChange() {
        assertEquals(1, ChangeCalculator.recursiveMinChange(1, d));
        assertEquals(5, ChangeCalculator.recursiveMinChange(5, d));
        assertEquals(2, ChangeCalculator.recursiveMinChange(30, a));
        assertEquals(5, ChangeCalculator.recursiveMinChange(5, d));
        assertEquals(3, ChangeCalculator.recursiveMinChange(14, b));
        assertEquals(5, ChangeCalculator.recursiveMinChange(65, c));
    }

    @Test
    public void testDynamicMinChange() {
        assertEquals(1, ChangeCalculator.dynamicMinChange(1, d));
        assertEquals(5, ChangeCalculator.dynamicMinChange(5, d));
        assertEquals(2, ChangeCalculator.dynamicMinChange(30, a));
        assertEquals(5, ChangeCalculator.dynamicMinChange(5, d));
        assertEquals(3, ChangeCalculator.dynamicMinChange(14, b));
        assertEquals(5, ChangeCalculator.dynamicMinChange(65, c));
    }

}