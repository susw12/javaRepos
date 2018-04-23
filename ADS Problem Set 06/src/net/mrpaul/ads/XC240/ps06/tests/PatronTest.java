package net.mrpaul.ads.XC240.ps06.tests;

import net.mrpaul.ads.XC240.ps06.Patron;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PatronTest {
    private Patron p1;
    private Patron p2;
    private Patron p3;

    @Before
    public void setUp() throws Exception {
        p1 = new Patron("Bob");
        p2 = new Patron("Mary");
        p3 = new Patron("Alex");
        p1.borrow("BOOK 1");
        p1.borrow("BOOK 2");
        p1.borrow("BOOK 3");
    }

    @After
    public void tearDown() throws Exception {
        p1 = null;
        p2 = null;
        p3 = null;
    }

    @Test
    public void borrow() {
        boolean a1 = p1.borrow("BOOK 1");
        boolean e1 = false;

        boolean a2 = p2.borrow("BOOK 1289129982981798792873987198798729879182739817");
        boolean e2 = true;

        assertEquals(e1, a1);
        assertEquals(e2, a2);

    }

    @Test
    public void checkedOut() {
        boolean a1 = p1.checkedOut("BOOK 1");
        boolean e1 = true;

        boolean a2 = p2.checkedOut("BOOK 1");
        boolean e2 = false;

        boolean a3 = p1.checkedOut("BOOK 10789093478");
        boolean e3 = false;
    }

    @Test
    public void checkIn() {
        boolean a1 = p1.checkIn("BOOK 1");
        boolean e1 = true;

        boolean a2 = p2.checkIn("BOOK 1");
        boolean e2 = false;

        boolean a3 = p1.checkIn("BOOK 10789093478");
        boolean e3 = false;
    }
}