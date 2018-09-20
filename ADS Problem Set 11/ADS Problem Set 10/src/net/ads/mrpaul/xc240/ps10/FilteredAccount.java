package net.mrpaul.ads.xc240.ps10;
import net.mrpaul.ps10.distribution.*;

/**
 * Account filtering zero processes
 * 
 * This program extends Account to filter out transactions of value 0.
 * It reports the percent filtered.
 * <p>
 * ADS: Problem Set 10
 * 
 * @author Sujay Swain
 * 
 * 
 */
public class FilteredAccount extends Account {
	private int numFiltered = 0, total = 0;
	
	
	public FilteredAccount(Client c) {
		super(c);
	}

	public boolean process(Transaction t) {
		total++;
		if (!(t.value() == 0)) {
			super.process(t);
		}
		numFiltered++;
		return true;
	}
	
	public double percentFiltered() {
		if (total == 0) return (double) total;
		return (double) numFiltered/total;
	}
}
