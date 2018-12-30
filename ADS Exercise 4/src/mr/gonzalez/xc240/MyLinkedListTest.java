package mr.gonzalez.xc240;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;


public class MyLinkedListTest {
    private MyLinkedList<Integer> l1;
    private MyLinkedList<String> l2;

    @BeforeEach
    public void setUp() throws Exception {
        l1 = new MyLinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);
        }};
        l2 = new MyLinkedList<String>() {{
            add("a");
            add("bc");
            add("def");
            add("ghij");
        }};
    }

    @AfterEach
    public void tearDown() throws Exception {
        l1 = null;
        l2 = null;
    }

    @Test
    public void testAddE() {
        l1.add(10);
        assertEquals((int) l1.get(5), 10);
        assertEquals(l1.size(), 6);
        l2.add("vwxyz");
        assertEquals(l2.get(4), "vwxyz");
        assertEquals(l2.size(), 5);
    }

    @Test
    public void testAddIntE() {
        l1.add(0, -3);
        System.out.println(l1.toArray());
        assertEquals((int) l1.get(0), -3);
        assertEquals((int) l1.get(4), 4);
        l2.add(1, "hmm");
        assertEquals(l2.get(1), "hmm");
        assertEquals(l2.get(2), "bc");
    }

    @Test
    public void testRemove() {
        l1.remove();
        assertEquals((int) l1.get(0), 2);
        assertEquals(l1.size(), 4);
        l2.remove();
        assertEquals(l2.get(0), "bc");
        assertEquals(l2.size(), 3);
    }

    @Test
    public void testRemoveInt() {
        l1.remove(3);
        assertEquals((int) l1.get(2), 3);
        assertEquals((int) l1.get(3), 5);
        assertEquals(l1.size(), 4);
        l2.remove(1);
        assertEquals(l2.get(0), "a");
        assertEquals(l2.get(1), "def");
        assertEquals(l2.size(), 3);
    }

    @Test
    public void testRemoveE() {
        l2.remove("bc");
        assertEquals(l2.get(1), "def");
        assertEquals(l2.size(), 3);
        l2.remove("a");
        assertEquals(l2.get(0), "def");
        assertEquals(l2.size(), 2);
    }

    @Test
    public void testPrepend() {
        l1.prepend(10);
        assertEquals((int) l1.get(5), 10);
        assertEquals(l1.size(), 6);
        l2.prepend("vwxyz");
        assertEquals(l2.get(4), "vwxyz");
        assertEquals(l2.size(), 5);
    }

    @Test
    public void testadd() {
        l1.add(10);
        assertEquals((int) l1.get(5), 10);
        assertEquals(l1.size(), 6);
        l2.add("vwxyz");
        assertEquals(l2.get(4), "vwxyz");
        assertEquals(l2.size(), 5);
    }

    @Test
    public void testGetHead() {
        assertEquals((int) l1.getHead().getValue(), 1);
        assertEquals(l2.getHead().getValue(), "a");
    }

    @Test
    public void testGet() {
        assertEquals((int) l1.get(3), 4);
        assertEquals(l2.get(3), "ghij");
    }

    @Test
    public void testSet() {
        l1.set(0, 10);
        assertEquals((int) l1.get(0), 10);
        l2.set(3, "yay");
        assertEquals(l2.get(3), "yay");
    }

    @Test
    public void testSize() {
        assertEquals(l1.size(), 5);
        assertEquals(l2.size(), 4);
    }

    @Test
    public void testContains() {
        assertEquals(l1.contains(3), true);
        assertEquals(l1.contains(6), false);
        assertEquals(l2.contains("bc"), true);
        assertEquals(l2.contains("abc"), false);
    }

    @Test
    public void testToArray() {
        assertArrayEquals(l1.toArray(), new Object[] {1,2,3,4,5});
        assertArrayEquals(l2.toArray(), new Object[] {"a","bc","def","ghij"});
    }

    @Test
    public void testIsEmpty() {
        l1.clear();
        assertEquals(l1.isEmpty(), true);
        assertEquals(l2.isEmpty(), false);
    }

    @Test
    public void testClear() {
        l1.clear();
        assertEquals(l1.size(), 0);
        l2.clear();
        assertEquals(l2.size(), 0);
    }

    @Test
    public void testIteratorNext() {
        Iterator<Integer> itr1 = l1.iterator();
        int i = 0;
        while (itr1.hasNext()) {
            assertEquals(itr1.next(), l1.get(i));
            i++;
        }
        assertEquals(i, 5);

        i = 0;
        Iterator<String> itr2 = l2.iterator();
        while (itr2.hasNext()) {
            assertEquals(itr2.next(), l2.get(i));
            i++;
        }
        assertEquals(i, 4);
    }
}
