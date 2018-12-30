package net.mrpaul.ads.xc240.ps10;
import net.mrpaul.ps10.distribution.*;

/**
 * YaleLawyer extending Lawyer
 * 
 * This program gives Yale Lawyers extra salary and vacation days.
 * It makes them fill out four of the Lawyer forms.
 * <p>
 * ADS: Problem Set 10
 * 
 * @author Sujay Swain
 * 
 * 
 */
public class YaleLawyer extends Lawyer {
	public double getSalary() {
		return super.getSalary() * 1.2;
	}
	
	public int getVacationDays() {
		return super.getVacationDays() + 3;
	}
	
	public String getVacationForm() {
		return new String(new char[4]).replace("\0", super.getVacationForm());
	}
}
