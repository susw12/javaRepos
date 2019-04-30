package net.mr.gonzalez.exercise1;
import java.io.*;
import java.util.*;

/**
 * Tests the cemetery class
 * This program creates an cemetery object to test that class.
 * <p>
 * AOA Exercise 01: CemeteryTester.java
 * 2/24/2019
 *
 * @author Sujay Swain
 */
public class CemeteryTester {
	/**
	 * Runs the cemetery class
	 * This runs the rest of the classes to check if they work properly
	 * <p>
	 * @author Sujay Swain
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Cemetery cemetery = new Cemetery();
		Scanner reader = cemetery.scan("Cemetery.txt");
		cemetery.fillTreeMap(reader);
		System.out.println("Number of People Buried:");
		cemetery.numberBuried();
		System.out.println("----------------------------------------------------------------");
		System.out.println("Earliest to Latest Burials:");
		cemetery.burialList();
		System.out.println("----------------------------------------------------------------");
		cemetery.averageAge();
	}
}
