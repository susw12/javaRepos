package net.ads.mrpaul.xc240.ps09;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExercisesGRTest {
    int[] a, b, c, d, e, f;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFillOne() {
        int[] x = {};
        int[] y = {1};
        int[] z = {1, 1, 1};
        assertArrayEquals(x, ExercisesGR.fillOne(0));
        assertArrayEquals(y, ExercisesGR.fillOne(1));
        assertArrayEquals(z, ExercisesGR.fillOne(3));
    }

    @Test
    public void testReverse() {

        int[] x = {1, 2, 3};
        int[] y = {3, 2, 1};
        int[] a = {};
        int[] m = {1};
        assertArrayEquals(x, ExercisesGR.reverse(y));
        assertArrayEquals(y, ExercisesGR.reverse(x));
        assertArrayEquals(a, ExercisesGR.reverse(a));
        assertArrayEquals(m, ExercisesGR.reverse(m));
    }

    @Test
    public void testInsertBetweenTriads() {
        int[] a = {1, 2, 3, 4};
        int[] b = {1, 2, 3, 4, 5};
        int[] c = {1, 2, 3, 4, 5, 6};
        int[] x = {1, 1, 2, 3, 1, 4};
        int[] y = {1, 1, 2, 3, 1, 4, 5};
        int[] z = {1, 1, 2, 3, 1, 4, 5, 6, 1};
        assertArrayEquals(x, ExercisesGR.insertBetweenTriads(a, 1));
        assertArrayEquals(y, ExercisesGR.insertBetweenTriads(b, 1));
        assertArrayEquals(z, ExercisesGR.insertBetweenTriads(c, 1));
    }



}
