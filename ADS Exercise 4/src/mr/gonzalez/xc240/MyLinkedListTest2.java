package mr.gonzalez.xc240;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyLinkedListTest2 {


    public boolean checkEquals(MyLinkedList<Integer> a, MyLinkedList<Integer> b) {
        if (a.size() != b.size()) {
            return false;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Test
    void testAppendAndGet() {
        MyLinkedList<Integer> a = new MyLinkedList<Integer>();
        a.append(9);
        a.append(7);
        a.append(-8);
        assertTrue(checkEquals(a, new MyLinkedList<Integer>() {{
            add(-8);
            add(7);
            add(9);
        }}));
        a.append(0);
        assertTrue(checkEquals(a, new MyLinkedList<Integer>() {{
            add(0);
            add(-8);
            add(7);
            add(9);
        }}));
    }

    @Test
    void testAddAndIsEmpty() {
        MyLinkedList<Integer> a = new MyLinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
        MyLinkedList<Integer> b = new MyLinkedList<Integer>();
        assertTrue(b.isEmpty());
        a.add(0, 9);
        assertTrue(checkEquals(a, new MyLinkedList<Integer>() {{
            add(9);
            add(1);
            add(2);
            add(3);
        }}));
        a.add(4, 10);
        assertTrue(checkEquals(a, new MyLinkedList<Integer>() {{
            add(9);
            add(1);
            add(2);
            add(3);
            add(10);
        }}));
        assertFalse(a.isEmpty());
    }

    @Test
    void testPrependAndSize() {
        MyLinkedList<Integer> a = new MyLinkedList<Integer>();
        a.prepend(9);
        a.prepend(7);
        a.prepend(-8);
        assertTrue(checkEquals(a, new MyLinkedList<Integer>() {{
            add(9);
            add(7);
            add(-8);
        }}));
        assertEquals(3, a.size());
        a.prepend(0);
        assertTrue(checkEquals(a, new MyLinkedList<Integer>() {{
            add(9);
            add(7);
            add(-8);
            add(0);
        }}));
        assertEquals(4, a.size());
    }

    @Test
    void testContains() {
        MyLinkedList<Integer> a = new MyLinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
            add(4);
        }};
        assertTrue(a.contains(3));
        assertFalse(a.contains(5));
    }

    @Test
    void testToArray() {
        assertArrayEquals(new MyLinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }}.toArray(), new Integer[]{1, 2, 3});
        assertArrayEquals(new MyLinkedList<Integer>().toArray(), new Integer[]{});

    }

    @Test
    void testRemove() {
        MyLinkedList<Integer> a = new MyLinkedList<Integer>() {{
            add(1);
            add(2);
            add(3);
        }};
    }
}