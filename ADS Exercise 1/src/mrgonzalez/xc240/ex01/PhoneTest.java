package mrgonzalez.xc240.ex01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneTest {
    private int[][] i1;
    private int[][] i2;
    private int[][] i3;
    private int[][] i4;
    private int[][] i5;

    @BeforeEach
    public void setUp(){
        i1 = new int[][] {{1,5,3,7,6},{2,4,4,8,7},{3,7,6,9,3}};
        i2 = new int[][] {{1,2,3},{2,3,1},{3,1,2}};
        i3 = new int[][] {{1,3,2},{2,3,1},{3,1,2}};
        i4 = new int[][] {{1,2,3},{3,3,1},{2,1,2}};
        i5 = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
    }

    @AfterEach
    public void tearDown() {
        i1 = null;
        i2 = null;
        i3 = null;
        i4 = null;
        i5 = null;
    }

    @Test
    void testMin() {
        assertEquals(Phone.min(i1),1);
    }

    @Test
    void testSum() {
        assertEquals(Phone.sum(i1), 75);
    }

    @Test
    void testIsSequence() {
        assertArrayEquals(Phone.isSequence(i1), new boolean[] {true,false,true,true,false});
    }

    @Test
    void testIsLatin() {
        assertEquals(Phone.isLatin(i1), false);
        assertEquals(Phone.isLatin(i2), true);
        assertEquals(Phone.isLatin(i3), false);
        assertEquals(Phone.isLatin(i4), false);
        assertEquals(Phone.isLatin(i5), false);
    }
}
