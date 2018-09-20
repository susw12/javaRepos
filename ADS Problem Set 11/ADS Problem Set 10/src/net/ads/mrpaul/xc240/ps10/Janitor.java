package net.mrpaul.ads.xc240.ps10;

import net.mrpaul.ps10.distribution.*;

/**
 * Janitor type Employee
 * 
 * This program gives janitors 10000 less salary and twice the hours.
 * They get half the vacation days and say "workin' for the man" when cleaning 
 * <p>
 * ADS: Problem Set 10
 * 
 * @author Sujay Swain
 * 
 * 
 */
public class Janitor extends Employee {
	public double getSalary() {
		return super.getSalary() - 10000;
	}
	
	public int getHours() {
		return super.getHours() * 2;
	}
	
	public int getVacationDays() {
		return super.getVacationDays() / 2;
	}
	
	public void clean() {
		System.out.println("Workin' for the man.");
	}
	
}
