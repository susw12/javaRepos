package net.mrpaul.ads.XC240.ps07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static net.mrpaul.ads.XC240.ps07.VoterFileRecovery.nthInstance;
import static org.junit.Assert.*;

public class VoterFileRecoveryTest {
    String test1;
    String test2;

    @Before
    public void setUp() throws Exception {
        test1 = "Hello";
        test2 = "Nilly adjflkj asdlfkjkl;askdjhlkjhasdhasdkasdfkkj";
    }

    @After
    public void tearDown() throws Exception {
        test1 = null;
        test2 = null;
    }

    @Test
    public void testNthInstance() {
        int e1 = nthInstance(2, "l", test1);
        int a1 = 3;

        int e2 = nthInstance(3, "as", test2);
        int a2 = 34;

        assertEquals(e1, a1);
        assertEquals(e2, a2);
    }
}