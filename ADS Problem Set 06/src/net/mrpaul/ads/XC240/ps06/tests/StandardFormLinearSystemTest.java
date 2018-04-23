package net.mrpaul.ads.XC240.ps06.tests;

import static org.junit.Assert.*;

import net.mrpaul.ads.XC240.ps06.Point;
import net.mrpaul.ads.XC240.ps06.StandardFormLine;
import net.mrpaul.ads.XC240.ps06.StandardFormLinearSystem;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class StandardFormLinearSystemTest {
	StandardFormLinearSystem a, b;
	StandardFormLine l1, l2, l3, l4;

	@Before
	public void setUp() throws Exception {
		l1 = new StandardFormLine(new Point(26, 70), new Point(17, 43));
		l2 = new StandardFormLine();
		l3 = new StandardFormLine(new Point(7, 13), new Point(8, -1));
		l4 = new StandardFormLine(new Point(0, 111), new Point(1, 97));
		
		a = new StandardFormLinearSystem(l1, l2);
		b = new StandardFormLinearSystem(l3, l4);
	}
//
	@After
	public void tearDown() throws Exception {
		l1 = null;
		l2 = null;
		l3 = null;
		l4 = null;
		a = null;
		b = null;
	}

	@Test
	public void testToString() {
		
	}

	@Test
	public void testHaveSameSlope() {
		assertEquals(false, a.haveSameSlope());
		assertEquals(true, b.haveSameSlope());
	}

	@Test
	public void testHasInfiniteSolutions() {
		assertEquals(false, a.hasInfiniteSolutions());
		assertEquals(true, b.hasInfiniteSolutions());
	}

	@Test
	public void testAreParallel() {
		assertEquals(false, a.areParallel());
		assertEquals(false, a.areParallel());
	}

	@Test
	public void testSolve() {
		assertEquals(null,b.solve());
		assertEquals(new Point(4, 5), a.solve());
	}

}
