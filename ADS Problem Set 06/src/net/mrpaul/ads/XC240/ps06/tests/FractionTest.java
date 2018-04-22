package net.mrpaul.ads.XC240.ps06.tests;

import net.mrpaul.ads.XC240.ps06.Fraction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {
    private Fraction f1;
    private Fraction f2;
    private Fraction f3;
    private Fraction f4;
    private Fraction f5;
    private Fraction f6;
    private Fraction f7;
    private Fraction f8;

    @Before
    public void setUp() throws Exception {
        f1 = new Fraction(3,10);
        f2 = new Fraction(4, 8);
        f3 = new Fraction(5,55);
        f4 = null;
        f5 = null;
        f6 = null;
        f7 = null;
        f8 = null;
    }

    @After
    public void tearDown() throws Exception {
        f1 = null;
        f2 = null;
        f3 = null;
        f4 = null;
        f5 = null;
        f6 = null;
        f7 = null;
        f8 = null;
    }

    @Test
    public void reduce() {
        Fraction a1 = f2.reduce();
        Fraction e1 = new Fraction(1, 2);

        Fraction a2 = f3.reduce();
        Fraction e2 = new Fraction(5, 55);

        assertEquals(a1, e1);
        assertEquals(a2, e2);

    }

    @Test
    public void add() {
    }

    @Test
    public void subtract() {
    }

    @Test
    public void multiply() {
    }

    @Test
    public void divide() {
    }
}