package net.mrpaul.ads.xc240.ps10;

import net.mrpaul.ps10.distribution.*;

/**
 * Marketer type employee
 * 
 * Marketers earn 10000 extra dollars.
 * They have the ability to advertise.
 * <p>
 * ADS: Problem Set 10
 * 
 * @author Sujay Swain
 * 
 * 
 */
public class Marketer extends Employee{
	public double getSalary() {
		return super.getSalary() + 10000;
	}
	
	public void advertise() {
		System.out.println("Act now, while supplies last!");
		
	}
}
