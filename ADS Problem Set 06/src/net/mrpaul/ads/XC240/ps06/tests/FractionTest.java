package net.mrpaul.ads.XC240.ps06.tests;

import net.mrpaul.ads.XC240.ps06.Fraction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.FREE_MEM;
import sun.security.x509.FreshestCRLExtension;

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
        f2 = new Fraction(4,8);
        f3 = new Fraction(5,55);
        f4 = new Fraction(6,23);
        f5 = new Fraction(4,23);
        f6 = new Fraction(5,4);
        f7 = new Fraction(14,7);
        f8 = new Fraction(7,14);
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
        Fraction e2 = new Fraction(1, 11);

        assertEquals(a1.toString(), e1.toString());
        assertEquals(a2.toString(), e2.toString());
    }

    @Test
    public void add() {
        Fraction a1 = f4.add(f5);
        Fraction e1 = new Fraction(10,23);

        Fraction a2 = f2.add(f6);
        Fraction e2 = new Fraction(7,4);

        assertEquals(a1.toString(), e1.toString());
        assertEquals(a2.toString(), e2.toString());
    }

    @Test
    public void subtract() {
        Fraction a1 = f3.subtract(f1);
        Fraction e1 = new Fraction(-23,110);

        Fraction a2 = f2.subtract(f6);
        Fraction e2 = new Fraction(-3,4);

        assertEquals(a1.toString(), e1.toString());
        assertEquals(a2.toString(), e2.toString());
    }

    @Test
    public void multiply() {
        Fraction a1 = f4.multiply(f5);
        Fraction e1 = new Fraction(24,529);

        Fraction a2 = f2.subtract(f6);
        Fraction e2 = new Fraction(-3,4);

        assertEquals(a1.toString(), e1.toString());
        assertEquals(a2.toString(), e2.toString());
    }

    @Test
    public void divide() {
        Fraction a1 = f4.divide(f5);
        Fraction e1 = new Fraction(3,2);

        Fraction a2 = f2.divide(f6);
        Fraction e2 = new Fraction(2,5);

        assertEquals(a1.toString(), e1.toString());
        assertEquals(a2.toString(), e2.toString());

    }
}