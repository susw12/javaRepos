package net.mrpaul.ads.xc240.ps08;

import org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class ArraysPotpourriTest {
    int[] a, b, c, d, e, f, g, h, vowels;
    double epsilon;
    String s;


    @Before
    void setUp() throws Exception {
        epsilon = .01;
        a = new int[] {-5, -4, 5, 6, 7, 8};
        b = new int[] {1, 2, 3, 4, 5, 2, 3};
        c = new int[] {1, 3, 5, 7, 5, 7, 5, 7};
        d = new int[] {1};
        e = new int[] {1, -2, 4, -4, 9, -6, 16, -8, 25, -10};
        f = new int[] {6, 7, 8};
        g = new int[] {-9, 1, 11, 13, 15};
        h = new int[] {6, 7, 8, -5, -4, 5, 6, 7, 8};
        vowels = new int[] {1, 3, 3, 1, 0};
        s = "i think, therefore i am.";

    }

    @After
    void tearDown() throws Exception {
    }

    @Test
    void testCountInRange() {
        assertEquals(6, ArraysPotpourri.countInRange(a, -5, 8));
        assertEquals(4, ArraysPotpourri.countInRange(a, 5, 8));
        assertEquals(1, ArraysPotpourri.countInRange(a, 8, 8));
    }

    @Test
    void testRange() {
        assertEquals(13, ArraysPotpourri.range(a));
        assertEquals(4, ArraysPotpourri.range(b));
        assertEquals(0, ArraysPotpourri.range(d));
    }

    @Test
    void testIsSorted() {
        assertEquals(true, ArraysPotpourri.isSorted(d));
        assertEquals(true, ArraysPotpourri.isSorted(a));
        assertEquals(false, ArraysPotpourri.isSorted(b));
    }

    @Test
    void testMode() {
        assertEquals(2, ArraysPotpourri.mode(b));
        assertEquals(5, ArraysPotpourri.mode(c));
    }

    @Test
    void testStdev() {
        assertEquals(11.237, ArraysPotpourri.stdev(e), epsilon);
    }

    @Test
    void testKthLargest() {
        assertEquals(7, ArraysPotpourri.kthLargest(2, a));
        assertEquals(-5, ArraysPotpourri.kthLargest(6, a));
        assertEquals(3, ArraysPotpourri.kthLargest(3, b));
        assertEquals(7, ArraysPotpourri.kthLargest(2, c));
    }

    @Test
    void testMinGap() {
        assertEquals(1, ArraysPotpourri.minGap(a));
        assertEquals(-3, ArraysPotpourri.minGap(b));
        assertEquals(-2, ArraysPotpourri.minGap(c));
    }

    @Test
    void testPercentEven() {
        assertEquals(50.0, ArraysPotpourri.percentEven(a), epsilon);
        assertEquals(42.86, ArraysPotpourri.percentEven(b), epsilon);
    }

    @Test
    void testIsUnique() {
        assertEquals(true, ArraysPotpourri.isUnique(a));
        assertEquals(false, ArraysPotpourri.isUnique(b));
        assertEquals(false, ArraysPotpourri.isUnique(c));
        assertEquals(true, ArraysPotpourri.isUnique(d));
        assertEquals(true, ArraysPotpourri.isUnique(e));
    }

    @Test
    void testPriceIsRight() {
        assertEquals(4, ArraysPotpourri.priceIsRight(b, 4));
        assertEquals(-1, ArraysPotpourri.priceIsRight(b, 0));
        assertEquals(5, ArraysPotpourri.priceIsRight(c, 6));
    }

    @Test
    void testLongestSortedSequence() {
        assertEquals(6, ArraysPotpourri.longestSortedSequence(a));
        assertEquals(5, ArraysPotpourri.longestSortedSequence(b));
        assertEquals(4, ArraysPotpourri.longestSortedSequence(c));
        assertEquals(1, ArraysPotpourri.longestSortedSequence(d));
    }

    @Test
    void testContains() {
        assertEquals(true, ArraysPotpourri.contains(a, f));
        assertEquals(false, ArraysPotpourri.contains(b, f));
        assertEquals(true, ArraysPotpourri.contains(b, d));
    }

    @Test
    void testCollapse() {
        assertEquals(true, Arrays.equals(g, ArraysPotpourri.collapse(a)));
    }

    @Test
    void testAppend() {
        assertEquals(true, Arrays.equals(h, ArraysPotpourri.append(f, a)));
    }

    @Test
    void testVowelCount() {
        assertEquals(true, Arrays.equals(vowels, ArraysPotpourri.vowelCount(s)));
    }
}