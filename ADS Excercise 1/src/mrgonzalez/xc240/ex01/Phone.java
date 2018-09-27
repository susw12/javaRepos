package mrgonzalez.xc240.ex01;

import java.util.Objects;

/**
 * Creates a phone number object
 *
 * <p>This classes creates a phone number object with 5 pieces of basic number</p>
 * <p>Generates number, name, billingCard, attachedEmail, zipCode</p>
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

    @Override
    public int hashCode() {
        return Objects.hash(getPhoneNumber(), getUserName(), getCreditCard(), getEmail(), getUserAreaCode());
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public int getUserAreaCode() {
        return userAreaCode;
    }

    public void setUserAreaCode(int userAreaCode) {
        this.userAreaCode = userAreaCode;
    }

    public String toString() {
        return "Number: " + userAreaCode + phoneNumber + ", Owner's Name: " + userName + ", Owner's Credit Card Number: " + creditCard +
                ", Owner's Email: " + email;
    }
}
