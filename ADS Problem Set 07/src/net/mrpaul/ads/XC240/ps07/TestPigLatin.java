package net.mrpaul.ads.XC240.ps07;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPigLatin {
	String s1, s2, s3, s4, s5, s6;
	@Before
	public void setUp() throws Exception {
		s1 = "bicycle";
		s2 = "apple";
		s3 = "1875";
		s4 = "myopic";
		s5 = "...--";
		s6 = "apple...";
	}

	@After
	public void tearDown() throws Exception {
		s1 = null;
		s2 = null;
		s3 = null;
		s4 = null;
		s5 = null;
		s6 = null;
	}

	@Test
	public void testStartOfFirstConsonantCluster() {
		int calculated1 = PigLatin.startOfFirstConsonantCluster(s1);
		int calculated2 = PigLatin.startOfFirstConsonantCluster(s2);
		int calculated3 = PigLatin.startOfFirstConsonantCluster(s3);
		int calculated4 = PigLatin.startOfFirstConsonantCluster(s4);
		int expected1 = 0;
		int expected2 = 1;
		int expected3 = -1;
		int expected4 = 0;
		assertEquals(calculated1, expected1);
		assertEquals(calculated2, expected2);
		assertEquals(calculated3, expected3);
		assertEquals(calculated4, expected4);
	}

	@Test
	public void testEndOfFirstConsonantCluster() {
		int calculated1 = PigLatin.endOfFirstConsonantCluster(s1);
		int calculated2 = PigLatin.endOfFirstConsonantCluster(s2);
		int calculated3 = PigLatin.endOfFirstConsonantCluster(s3);
		int calculated4 = PigLatin.endOfFirstConsonantCluster(s4);
		int expected1 = 0;
		int expected2 = 3;
		int expected3 = -1;
		int expected4 = 1;
		assertEquals(calculated1, expected1);
		assertEquals(calculated2, expected2);
		assertEquals(calculated3, expected3);
		assertEquals(calculated4, expected4);
	}
	
	@Test
	public void testWordToPigLatin() {
		String calculated1 = PigLatin.wordToPigLatin(s1);
		String calculated2 = PigLatin.wordToPigLatin(s2);
		String calculated4 = PigLatin.wordToPigLatin(s4);
		String expected1 = "icyclebay";
		String expected2 = "appleway";
		String expected4 = "opicmyay";
		assertEquals(calculated1, expected1);
		assertEquals(calculated2, expected2);
		assertEquals(calculated4, expected4);
	}
	
	@Test
	public void testfindStartOfEndingPuncSeq() {
		int calculated5 = PigLatin.findStartOfEndingPuncSeq(s5);
		int calculated6 = PigLatin.findStartOfEndingPuncSeq(s6);
		int expected5 = 0;
		int expected6 = 5;
		assertEquals(calculated5, expected5);
		assertEquals(calculated6, expected6);
	}
}
