package net.mrpaul.ads.xc240.ps10;

/**
 * Incrementer that counts in order
 * 
 * This program starts at 0 and increments in order.
 * It can return its value.
 * <p>
 * ADS: Problem Set 10
 * 
 * @author Sujay Swain
 * 
 * 
 */
public class SequentialIncrementer implements Incrementable {
	private int value;
	public SequentialIncrementer() {
		value = 0;
	}
	
	public void increment() {
		value++;
	}
	public int getValue() {
		return value;
	}
	
	
}
