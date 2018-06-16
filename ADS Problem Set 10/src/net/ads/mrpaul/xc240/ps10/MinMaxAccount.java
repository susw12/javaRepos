package net.mrpaul.ads.xc240.ps10;
import net.mrpaul.ps10.distribution.*;

/**
 * BankingAccount that stores the min and max
 * 
 * This program extends BankingAccount to remember the min and max values of all time.
 * These can be gotten at any time.
 * <p>
 * ADS: Problem Set 10
 * 
 * @author Sujay Swain
 * 
 * 
 */
public class MinMaxAccount extends BankingAccount {
	private int min, max;
	
	
	public MinMaxAccount(Startup s) {
		BankingAccount b = new BankingAccount(s);
		min = b.getBalance();
		max = b.getBalance();
	}
	
	public int getMin() {
		return min;
	}
	
	public int getMax() {
		return max;
	}
	
	public void setMinMax() {
		if (getBalance() > max) max = getBalance();
		if (getBalance() < min) min = getBalance();
	}
	
	public void debit(Debit d) {
		super.debit(d);
		setMinMax();
	}
	
	public void credit(Credit c) {
		super.credit(c);
		setMinMax();
	}
	
	
	
}
