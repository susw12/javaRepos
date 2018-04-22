package net.mrpaul.ads.XC240.ps06.tests;

import static org.junit.Assert.*;

import net.mrpaul.ads.XC240.ps06.Point;
import org.junit.Before;
import org.junit.Test;

public class PointTest {
    private Point p1;
    private Point p2;
    private Point p3;
    private Point p4;
    private Point p5;
    private Point p6;
    private Point p7;
    private Point p8;
    private Point p9;
    private Point p10;

    @org.junit.Before
    public void setUp() throws Exception {
        p1 = new Point(0,0);
        p2 = new Point(1,1);
        p3 = new Point(3,2);
        p4 = new Point(5,5);
        p5 = new Point(6,8);
        p6 = new Point(6,100);
        p7 = new Point(3,56);
        p8 = new Point(5,2);
        p9 = new Point(10,3);
        p10 = new Point(4,9);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        p1 = null;
        p2 = null;
        p3 = null;
        p4 = null;
        p5 = null;
        p6 = null;
        p7 = null;
        p8 = null;
        p9 = null;
        p10 = null;
    }


    @Test
    public void manhattanDistance() {
        int a1 = p1.manhattanDistance(p2);
        int e1 = 2;
        int a2 = p3.manhattanDistance(p4);
        int e2 = 5;

        assertEquals(a1, e1);
        assertEquals(a2, e2);
    }

    @Test
    public void isVertical() {
        boolean a1 = p5.isVertical(p6);
        boolean e1 = true;
        boolean a2 = p1.isVertical(p4);
        boolean e2 = false;

        assertEquals(a1, e1);
        assertEquals(a2, e2);

    }

    @Test
    public void slope() {
        double a1 = p1.slope(p2);
        double e1 = 1;

        double a2 = p6.slope(p7);
        double e2 = (44/3);

        assertEquals(a1, e1, 0.001);
        assertEquals(a2, e2, 0.001);
    }

    @Test
    public void isCollinear() {
        boolean a1 = p1.isCollinear(p8, p9);
        boolean e1 = true;

        boolean a2 = p2.isCollinear(p4, p10);
        boolean e2 = false;

        assertEquals(a1, e1);
        assertEquals(a2, e2);
    }
}