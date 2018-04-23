package net.mrpaul.ads.XC240.ps06.tests;

import static org.junit.Assert.*;

import net.mrpaul.ads.XC240.ps06.Dice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiceTest {
    Dice f1, f2;
    int n = 3;
    long seed = 1445517736455L;

    @Before
    public void setUp() throws Exception {
        f1 = new Dice(seed);
        f2 = new Dice(seed);
    }

    @After
    public void tearDown() throws Exception {
        f1 = null;
        f2 = null;
    }

    @Test
    public void testGetCurrentSide() {
        f1.roll();
        f2.roll();
        int calculated1 = f1.getCurrentSide();
        int expected1 = 2;
        int calculated2 = f2.getCurrentSide();
        int expected2 = 2;

        assertEquals(calculated1, expected1);
        assertEquals(calculated2, expected2);
    }

    @Test
    public void testGetNumRolls1() {
        int calculated1 = f1.getNumRolls();
        int expected1 = 0;
        int calculated2 = f2.getNumRolls();
        int expected2 = 0;

        assertEquals(calculated1, expected1);
        assertEquals(calculated2, expected2);
    }

    @Test
    public void testGetNumRolls() {
        int calculated1 = f1.getNumRolls(n);
        int expected1 = 0;
        int calculated2 = f2.getNumRolls(n);
        int expected2 = 0;

        assertEquals(calculated1, expected1);
        assertEquals(calculated2, expected2);
    }

    @Test
    public void testGetPercent() {
        for (int x = 0; x < 20; x++) {
            f1.roll();
            f2.roll();
        }
        double calculated1 = f1.getPercentages(n);
        System.out.println(calculated1);
        double expected1 = 0;
        double calculated2 = f2.getPercentages(n);
        double expected2 = 0;

        assertEquals(calculated1, expected1, 0.00000001);
        assertEquals(calculated2, expected2, 0.00000001);
    }
}