package net.mr.gonzalez.exercise1;

/**
 * Creates tombstone class
 * This program contains the tombstone information
 * <p>
 * AOA Exercise 01: Tombstone.java
 * 2/24/2019
 *
 * @author Sujay Swain
 */
public class Tombstone {
	String name;
	Date date;
	int age;
	String address;
	
	/**
	 * Sets all variables to default
	 * This method sets all variables to 0 or empty.
	 * <p>
	 * @author Sujay Swain
	 */
	public Tombstone() {
		name = "";
		date = new Date();
		age = 0;
		address = "";
	}
	
	/**
	 * Sets variables to user ones
	 * This method sets the variables to the ones given by the user.
	 * <p>
	 * @author Sujay Swain
	 * @param name1 - given name by user
	 * @param date1 - given date by user
	 * @param age1 - given age by user
	 * @param address1 - given address by user
	 */
	public Tombstone(String name1, Date date1, int age1, String address1) {
		name = name1;
		date = date1;
		age = age1;
		address = address1;
	}
	
	/**
	 * Returns the name variable specific
	 * This method returns the name variable
	 * <p>
	 * @author Sujay Swain
	 * @return name - name of dead person
	 */
	public String getName() {return name;}
	
	/**
	 * Returns the date variable specific
	 * This method returns the date variable
	 * <p>
	 * @author Sujay Swain
	 * @return date - date of dead person
	 */
	public Date getDate() {return date;}
	
	/**
	 * Returns the age variable specific
	 * This method returns the age variable
	 * <p>
	 * @author Sujay Swain
	 * @return age - age of dead person
	 */
	public int getAge() {return age;}
	
	/**
	 * Returns the address variable specific
	 * This method returns the address variable
	 * <p>
	 * @author Sujay Swain
	 * @return address - address of dead person
	 */
	public String getAddress() {return address;}
	
	/**
	 * Sets name variable user given
	 * This method sets the name variable to one given by the user
	 * <p>
	 * @author Sujay Swain
	 * @param name2 - name given by user
	 */
	public void setName(String name2) {name = name2;}
	
	/**
	 * Sets date variable user given
	 * This method sets the date variable to one given by the user
	 * <p>
	 * @author Sujay Swain
	 * @param date2 - date given by user
	 */
	public void setDate(Date date2) {date = date2;}
	
	/**
	 * Sets age variable user given
	 * This method sets the age variable to one given by the user
	 * <p>
	 * @author Sujay Swain
	 * @param age2 - age given by user
	 */
	public void setAge(int age2) {age = age2;}
	
	/**
	 * Sets address variable user given
	 * This method sets the address variable to one given by the user
	 * <p>
	 * @author Sujay Swain
	 * @param address2 - address given by user
	 */
	public void setAddress(String address2) {address = address2;}
}
