package net.mrpaul.ads.XC240.ps06.tests;

import net.mrpaul.ads.XC240.ps06.Point;
import net.mrpaul.ads.XC240.ps06.StandardFormLine;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StandardFormLineTest {
    private StandardFormLine l1;
    private StandardFormLine l2;
    private StandardFormLine l3;
    private Point p1 = new Point(12,43);
    private Point p2 = new Point(63,40);

    @Before
    public void setUp() throws Exception {
        l1 = new StandardFormLine();
        l2 = new StandardFormLine(2,33,4);
        l3 = new StandardFormLine(p1, p2);
    }

    @After
    public void tearDown() throws Exception {
        l1 = null;
        l2 = null;
        l3 = null;
    }

    @Test
    public void getSlope() {
        double a1 = l1.getSlope();
        double e1 = (1);

        double a2 = l3.getSlope();
        double e2 = (40-43)/(63-12);

        assertEquals(a1, e1, 0.0001);
        assertEquals(a2, e2, 0.0001);
    }

    @Test
    public void toStringTest() {
        String a1 = l2.toString();
        String e1 = "2x + 33y = 4";

        String a2 = l1.toString();
        String e2 = "-1x + 1y = 1";
    }
}