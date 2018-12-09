package mrgonzalez.xc240.ex01;

import java.util.Objects;

/**
 * Creates a phone number object
 *
 * <p>This classes creates a phone number object with 5 pieces of basic number</p>
 * <p>Generates number, name, billingCard, attachedEmail, areCode</p>
 * <p>Also, this redefines the equal method to check if two things are the same</p>
 *
 * ADS Exercise 1: Phone
 * 09/25/2018
 *
 * @author Sujay Swain
 */
public class Phone implements Comparable<Phone>{
    //Generates the variables that will be necessary for getting a phone number
    private String phoneNumber;
    private String userName;
    private String creditCard;
    private String email;
    private int userAreaCode;

    /**
     * Standard Bubble sort code from the internet
     * @param array
     */
    public static void bubbleSort(int[] array) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < array.length - j; i++) {
                if (array[i] > array[i + 1]) {
                    tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    /**
     * Creates a phone
     * <p>Simple class to create a phone and to collect basic info.
     * Requires a combination of both string and int values</p>
     *
     * @author Sujay Swain
     * @param areaCode
     * @param number
     * @param name
     * @param billingCard
     * @param attachedEmail
     */
    public Phone(int areaCode, String number, String name, String billingCard, String attachedEmail) {
        if (number.length() != 10) {
            System.out.println("A phone number must have 10 digits. Please do not include area code as this should be entered in the first parameter.");
        }
        else {
            this.phoneNumber = number;
            this.userName = name;
            this.creditCard = billingCard;
            this.email = attachedEmail;
            this.userAreaCode = areaCode;
        }
    }

    /**
     * Overrides .equals()
     *
     * <p>Overrides the standard .equals() .
     * Now it only compares the parameters</p>
     *
     * @author Sujay Swain
     * @param o
     * @return Boolean Value
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return getCreditCard() == phone.getCreditCard() &&
                getUserAreaCode() == phone.getUserAreaCode() &&
                Objects.equals(getPhoneNumber(), phone.getPhoneNumber()) &&
                Objects.equals(getUserName(), phone.getUserName()) &&
                Objects.equals(getEmail(), phone.getEmail());
    }

    /**
     * Simple way to generate hash code
     *
     * <p>Generates the hash code</p>
     *
     * @author Sujay Swain
     * @return hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNumber(), getUserName(), getCreditCard(), getEmail(), getUserAreaCode());
    }

    /**
     * Redefines the compareTo() method
     *
     * <p>Overloads the compareTo() method and uses the hash code instead.</p>
     *
     * @author Sujay Swain
     * @param otherPhone
     * @return Boolean Value
     */
    @Override
    public int compareTo(Phone otherPhone) {
        boolean check = true;
        if (hashCode() > otherPhone.hashCode()) {
            return 1;
        }
        else if (hashCode() < otherPhone.hashCode()) {
            return -1;
        }
        else {
            return 0;
        }

    }

    /**
     * Getter for phone number
     * <p> Gets the phone number </p>
     *
     * @author Sujay Swain
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Setter for phone number
     * <p> Sets the phone number </p>
     *
     * @author Sujay Swain
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Getter for user's name
     * <p> Gets the user's name </p>
     *
     * @author Sujay Swain
     * @return userName
     */
    public String getUserName() {
        return userName;
    }
    /**
     * Setter for user's name
     * <p> Sets the user's name </p>
     *
     * @author Sujay Swain
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    /**
     * Getter for credit card number
     * <p> Gets the credit card number </p>
     *
     * @author Sujay Swain
     * @return creditCard
     */
    public String getCreditCard() {
        return creditCard;
    }
    /**
     * Setter for credit card number
     * <p> Sets the credit card number </p>
     *
     * @author Sujay Swain
     */
    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }
    /**
     * Getter for email
     * <p> Gets the email </p>
     *
     * @author Sujay Swain
     * @return email
     */
    public String getEmail() {
        return email;
    }
    /**
     * Setter for email
     * <p> Sets the email </p>
     *
     * @author Sujay Swain
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Getter for area code
     * <p> Gets the area code number </p>
     *
     * @author Sujay Swain
     * @return userAreaCode
     */
    public int getUserAreaCode() {
        return userAreaCode;
    }
    /**
     * Setter for area code
     * <p> Sets the area code number </p>
     *
     * @author Sujay Swain
     */
    public void setUserAreaCode(int userAreaCode) {
        this.userAreaCode = userAreaCode;
    }

    /**
     * Defines the toString() method
     *
     * <p>States what will happen when the users want a string version (Ex. System.out.println())</p>
     *
     * @author Sujay Swain
     * @return Print output
     */
    public String toString() {
        return "Number: " + userAreaCode + phoneNumber + ", Owner's Name: " + userName + ", Owner's Credit Card Number: " + creditCard +
                ", Owner's Email: " + email;
    }

    /**
     * Finds the minimum value of the array
     *
     * <p>Scans through the 2D array element by element by element to find the smallest value.</p>
     *
     * @author Sujay Swain
     * @param checker
     * @return minVal
     */
    public static int min(int checker[][]) {
        int minVal = 0;
        for (int x = 0;  x < checker.length; x++) {
            for (int y = 0; y < checker[x].length; y++) {
                if (x == 0 && y == 0) {
                    minVal = checker[x][y];
                }
                else {
                    if (minVal > checker[x][y]) {
                        minVal = checker[x][y];
                    }
                }
            }
        }
        return minVal;
    }

    /**
     * Returns the sum of the array
     *
     * <p>Sums up all of the elements in the 2D array and return that value.</p>
     *
     * @author Sujay Swain
     * @param checker
     * @return sum
     */
    public static int sum(int checker[][]) {
        int sum = 0;
        for (int x = 0;  x < checker.length; x++) {
            for (int y = 0; y < checker[x].length; y++) {
                sum += checker[x][y];
            }
        }
        return sum;
    }

    /**
     * Figures out whether or not this is a sequence
     *
     * <p>Uses the definition of a sequence to figure out whether or not each row is a sequence</p>
     *
     * @author Sujay Swain
     * @param checker
     * @return isSequenceArray
     */

    public static boolean[] isSequence(int[][] checker) {
        boolean isSequenceArray[] = new boolean[checker.length];
        for (int z = 0; z < isSequenceArray.length; z++) {
            isSequenceArray[z] = true;
        }
        for (int x = 0; x < checker[x].length; x++) {
            int[] checkingArray = checker[x];
            for (int y = 0; y < checker.length; y++) {
                if (checker[x][y] != x) {
                    isSequenceArray[y] = false;
                }
            }
        }
        return isSequenceArray;
    }


    /**
     * Figures out whether or not this is a "Latin array"
     *
     * <p> Uses the provided definition of a Latin array to determine whether or not the given array qualifies</p>
     *
     * @author Sujay Swain
     * @param checker
     * @return isLatinReturn
     */
    public static boolean isLatin(int checker[][]) {
        boolean isLatinReturn = true;
        for (int y = 0; y < checker.length; y++) {
            int[] popCompare = new int[checker[y].length];
            for (int x = 0; x < checker[y].length; x++) {
                int val = checker[y][x];
                if (popCompare[val] == -1) {
                    isLatinReturn = false;
                }
            }
        }
        return isLatinReturn;

    }

}
