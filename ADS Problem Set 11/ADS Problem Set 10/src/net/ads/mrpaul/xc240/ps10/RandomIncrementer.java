package net.mrpaul.ads.xc240.ps10;

import java.util.Random;

/**
 * Incrementer that counts randomly
 * 
 * This program starts at a random number from 0-99
 * It increments by a random number from 0-99
 * <p>
 * ADS: Problem Set 10
 * 
 * @author Sujay Swain
 * 
 * 
 */
public class RandomIncrementer {
	private int value;
	private Random r;
	
	public RandomIncrementer() {
		Random r = new Random();
		value = r.nextInt(100) + 1; 
	}
	
	public void increment() {
		value += r.nextInt(100) + 1; 
	}
	
	public int getValue() {
		return value;
	}
	
}
