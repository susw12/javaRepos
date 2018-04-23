package net.mrpaul.ads.XC240.ps06;

import java.util.*;

/**
 * Computer guessing
 * The computer will guess your number
 * <p>
 * ASDA PS06: Looping Exercises
 * 4/21/18
 *
 * @author Sujay Swain
 */
public class LoopingExercises {
	public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String response = "";
        //initialize variables
        int lbound = 0;
        int hbound = 1000;
        int numguessed = 500;
        int guesses = 1;
        String a;

        System.out.println("Hello. I am a computer. I am going to try to guess your number between 1 and 1000.");
        //loops until number is reached
        while (true) {
            System.out.println(response + "Is it " + numguessed + "?");
            System.out.print("Type y if I am correct.  Type h if your number is higher, and type l if your number is lower: ");
            a = reader.nextLine();
            //checks if input is valid
            while (!(a.equals("l") || a.equals("h") || a.equals("y"))) {
                System.out.print("Type y if I am correct.  Type h if your number is higher, and type l if your number is lower: ");
                a = reader.nextLine();
            }
            //breaks from the loop if number is guessed, otherwise adjust the limits
            if (a.equals("y")) {
                System.out.println("Got it!  It was " + numguessed + ".  It took me " + guesses + " guesses.");
                break;
            } else {
                if (a.equals("h")) {
                    lbound = numguessed;
                    response = "You said it was higher   ";
                } else {
                    hbound = numguessed;
                    response = "You said it was lower    ";
                }
            }
            //increment guesses
            guesses += 1;
            //binary search
            numguessed = (int) ((hbound + lbound) / 2);
        }
        reader.nextLine();
    }
}
