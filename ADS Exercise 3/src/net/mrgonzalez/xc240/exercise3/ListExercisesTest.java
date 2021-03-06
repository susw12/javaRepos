package net.mrgonzalez.xc240.exercise3;

import org.junit.After;
import org.junit.Before;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;

public class ListExercisesTest {
    private List<String> l1;
    private List<String> l2;
    private List<String> l1sp;
    private List<String> l2sp;
    private List<String> l1rel;
    private List<String> l2rel;
    private List<String> l1dl;
    private List<String> l2dl;
    private List<Integer> l3;
    private List<Integer> l4;
    private List<Integer> l3mtf;
    private List<Integer> l4mtf;
    private List<String> l5;
    private List<String> l5rd;
    private List<String> l1s;
    private List<String> l2s;
    private List<String> l2ml4;
    private List<String> l1rss;
    private List<String> l2rss;
    private List<Integer> l3l4i;
    private List<Integer> l4mtfl3mtfi;

    @Before
    public void setUp() throws Exception {
        l1 = new ArrayList<String>() {{
            add("abcdefghi");
            add("abc");
            add("abcdefghijklmnopqrstuvwxyz");
            add("a");
            add("abcdefghijklmno");
            add("abcdef");
        }};
        l2 = new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
            add("four");
            add("five");
        }};
        l1sp = new ArrayList<String>() {{
            add("abc");
            add("abcdefghi");
            add("a");
            add("abcdefghijklmnopqrstuvwxyz");
            add("abcdef");
            add("abcdefghijklmno");
        }};
        l2sp = new ArrayList<String>() {{
            add("two");
            add("one");
            add("four");
            add("three");
            add("five");
        }};
        l1rel = new ArrayList<String>() {{
            add("abcdefghi");
            add("abc");
            add("a");
            add("abcdefghijklmno");
        }};
        l2rel = new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
        }};
        l1dl = new ArrayList<String>() {{
            add("abcdefghi");
            add("abcdefghi");
            add("abc");
            add("abc");
            add("abcdefghijklmnopqrstuvwxyz");
            add("abcdefghijklmnopqrstuvwxyz");
            add("a");
            add("a");
            add("abcdefghijklmno");
            add("abcdefghijklmno");
            add("abcdef");
            add("abcdef");
        }};
        l2dl = new ArrayList<String>() {{
            add("one");
            add("one");
            add("two");
            add("two");
            add("three");
            add("three");
            add("four");
            add("four");
            add("five");
            add("five");
        }};
        l3 = new ArrayList<Integer>() {{
            add(5);
            add(4);
            add(3);
            add(2);
            add(1);
        }};
        l4 = new ArrayList<Integer>() {{
            add(1292);
            add(83);
            add(3);
            add(579622);
            add(3);
            add(174);
        }};
        l3mtf = new ArrayList<Integer>() {{
            add(1);
            add(5);
            add(4);
            add(3);
            add(2);
        }};
        l4mtf = new ArrayList<Integer>() {{
            add(3);
            add(3);
            add(1292);
            add(83);
            add(579622);
            add(174);
        }};
        l5 = new ArrayList<String>() {{
            add("be");
            add("be");
            add("is");
            add("not");
            add("or");
            add("question");
            add("that");
            add("the");
            add("to");
            add("to");
            add("to");
        }};
        l5rd = new ArrayList<String>() {{
            add("be");
            add("is");
            add("not");
            add("or");
            add("question");
            add("that");
            add("the");
            add("to");
        }};
        l2s = new ArrayList<String>() {{
            add("one");
            add("one");
            add("one");
            add("two");
            add("two");
            add("two");
            add("three");
            add("three");
            add("three");
            add("four");
            add("four");
            add("four");
            add("five");
            add("five");
            add("five");
        }};
        l2ml4 = new ArrayList<String>() {{
            add("one");
            add("two");
            add("three");
            add("$&*#");
            add("four");
            add("$&*#");
            add("five");
        }};
        l1rss = new ArrayList<String>() {{
            add("abcdefghi");
            add("abcdefghijklmnopqrstuvwxyz");
            add("abcdefghijklmno");
        }};
        l2rss = new ArrayList<String>() {{
            add("two");
            add("three");
            add("five");
        }};
        l3l4i = new ArrayList<Integer>() {{
            add(5);
            add(1292);
            add(4);
            add(83);
            add(3);
            add(3);
            add(2);
            add(579622);
            add(1);
            add(3);
            add(174);
        }};
        l4mtfl3mtfi = new ArrayList<Integer>() {{
            add(3);
            add(1);
            add(3);
            add(5);
            add(1292);
            add(4);
            add(83);
            add(3);
            add(579622);
            add(2);
            add(174);
        }};
    }

    @After
    public void tearDown() throws Exception {
        l1 = null;
        l2 = null;
        l1sp = null;
        l2sp = null;
        l1rel = null;
        l2rel = null;
        l1dl = null;
        l2dl = null;
        l3 = null;
        l4 = null;
        l3mtf = null;
        l4mtf = null;
        l5 = null;
        l5rd = null;
        l2s = null;
        l2ml4 = null;
        l1rss = null;
        l2rss = null;
    }

    @Test
    public void testMaxLength() {
        assertEquals(ListExercises.maxLength(l1), 26);
        assertEquals(ListExercises.maxLength(l2), 5);
    }

    @Test
    public void testSwapPairs() {
        //assertArrayEquals(ListExercises.swapPairs(l1).toArray(), l1sp.toArray());
        assertArrayEquals(ListExercises.swapPairs(l2).toArray(), l2sp.toArray());
    }

    @Test
    public void testRemoveEvenLength() {
        assertArrayEquals(ListExercises.removeEvenLength(l1).toArray(), l1rel.toArray());
        assertArrayEquals(ListExercises.removeEvenLength(l2).toArray(), l2rel.toArray());
    }

    @Test
    public void testDoubleList() {
        assertArrayEquals(ListExercises.doubleList(l1).toArray(), l1dl.toArray());
        assertArrayEquals(ListExercises.doubleList(l2).toArray(), l2dl.toArray());
    }

    @Test
    public void testMinToFront() {
        assertArrayEquals(ListExercises.minToFront(l3).toArray(), l3mtf.toArray());
        assertArrayEquals(ListExercises.minToFront(l4).toArray(), l4mtf.toArray());
    }

    @Test
    public void tes1tRemoveDuplicates() {
        assertArrayEquals(ListExercises.removeDuplicates(l5).toArray(), l5rd.toArray());
        assertArrayEquals(ListExercises.removeDuplicates(l1).toArray(), l1.toArray());

    }

    @Test
    public void testStutter() {
        assertArrayEquals(ListExercises.stutter(l1,2).toArray(), l1dl.toArray());
        assertArrayEquals(ListExercises.stutter(l2,3).toArray(), l2s.toArray());
    }

    @Test
    public void testMarkLength4() {
        assertArrayEquals(ListExercises.markLength4(l1).toArray(), l1.toArray());
        assertArrayEquals(ListExercises.markLength4(l2).toArray(), l2ml4.toArray());
    }

    @Test
    public void testRemoveShorterStrings() {
        assertArrayEquals(ListExercises.removeShorterStrings(l1).toArray(), l1rss.toArray());
        assertArrayEquals(ListExercises.removeShorterStrings(l2).toArray(), l2rss.toArray());
    }

    @Test
    public void testInterleave() {
        assertArrayEquals(ListExercises.interleave(l3, l4).toArray(), l3l4i.toArray());
        assertArrayEquals(ListExercises.interleave(l4mtf, l3mtf).toArray(), l4mtfl3mtfi.toArray());
    }

    @Test
    public void testClosestPerfect() {
        assertEquals(ListExercises.closestPerfect(l3), 4);
        assertEquals(ListExercises.closestPerfect(l4), 1292);
    }
}