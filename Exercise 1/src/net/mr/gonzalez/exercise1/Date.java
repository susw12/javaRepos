package net.mr.gonzalez.exercise1;

/**
 * Creates a class for handling dates
 * This program allows for the proper usage and management of different dates in time
 * <p>
 * AOA Exercise 01: Date.java
 * 2/24/2019
 *
 * @author Sujay Swain
 */
public class Date {
	int day, month, year;
	/**
	 * Puts default dates into variables
	 * This constructor puts 0s.
	 * <p>
	 * @author Sujay Swain
	 */
	public Date() {
		day = 0;
		month = 0;
		year = 0;
	}
	/**
	 * Sets dates to specific variables
	 * This constructor sets the dates to user given variables.
	 * <p>
	 * @author Sujay Swain
	 * @param day1 - date given by user
	 * @param month1 - month given by user
	 * @param year1 - year given by user
	 */
	public Date(int day1, int month1, int year1){
		day = day1;
		month = month1;
		year = year1;
	}
	
	/**
	 * Sets date to user variable
	 * This method sets the date to a user given variable.
	 * <p>
	 * @author Sujay Swain
	 * @param day1 - user given variable
	 */
	public void setDay(int day1) {day = day1;}
	
	/**
	 * Sets month to user variable
	 * This method sets the month to a user given variable.
	 * <p>
	 * @author Sujay Swain
	 * @param month1 - user given variable
	 */
	public void setMonth(int month1) {month = month1;}
	
	/**
	 * Sets month to user variable
	 * This method sets the month to a user given variable.
	 * <p>
	 * @author Sujay Swain
	 * @param month1 - user given variable
	 */
	public void setMonth(String month1) {
		if(month1.contains("Jan")) {month = 1;}
		if(month1.contains("Feb")) {month = 2;}
		if(month1.contains("Mar")) {month = 3;}
		if(month1.contains("Apr")) {month = 4;}
		if(month1.contains("May")) {month = 5;}
		if(month1.contains("Jun")) {month = 6;}
		if(month1.contains("Jul")) {month = 7;}
		if(month1.contains("Aug")) {month = 8;}
		if(month1.contains("Sep")) {month = 9;}
		if(month1.contains("Oct")) {month = 10;}
		if(month1.contains("Nov")) {month = 11;}
		if(month1.contains("Dec")) {month = 12;}
	}
	
	/**
	 * Sets year to user variable
	 * This method sets the year to a user given variable.
	 * <p>
	 * @author Sujay Swain
	 * @param year1 - user given variable
	 */
	public void setYear(int year1) {year = year1;}
	
	/**
	 * Returns the day variable specific
	 * This method returns the day variable.
	 * <p>
	 * @author Sujay Swain
	 * @return day - variable
	 */
	public int getDay() {return day;}
	
	/**
	 * Returns the month variable specific
	 * This method returns the month variable.
	 * <p>
	 * @author Sujay Swain
	 * @return month - variable
	 */
	public int getMonth() {return month;}
	
	/**
	 * Returns the year variable specific
	 * This method returns the year variable.
	 * <p>
	 * @author Sujay Swain
	 * @return year - variable
	 */
	public int getYear() {return year;}
	
	/**
	 * Returns string format of variables
	 * This method returns the day, month, and year variables in a string format.
	 * <p>
	 * @author Sujay Swain
	 * @return ret - readable format of day, month, year variables
	 */
	public String toString() {
		return day + " " + month + " " + year;
	}
}
