/*
 * 
 * 
 * 
 */
package net.mrpaul.xc170.ps02;
import java.util.Scanner;

public class Greedy {

	public static void main(String[] args) {

	    //NO NEED TO MODIFY ANYTHING UNTIL THE COMMENT INDICATING THE START OF YOUR CODE
	    //declare the variables we'll need
	    Scanner sc = new Scanner(System.in);
	    double changeToGive = 0;
	    
	    //This is the start of the loop to prompt for the dollar amount
	    do {
	    	//if the user gave us a negative dollar amount
	        if(changeToGive < 0)
	            System.out.println("Dollar amounts must be positive.");
	        
	        //if the current amount is zero dollars
	        else if(changeToGive == 0)
	            System.out.println("How much change do you need to pay out?");
	        
	        // while the user's input is not a valid double, prompt again
	        while (!sc.hasNextDouble()) {
	            System.out.println("Invalid input.  How much change do you need to pay out?");
	            sc.next(); // this is important!
	        }
	        
	        //if the user entered a valid double, assign it to changeToGive
			changeToGive = sc.nextDouble();
	    } while (changeToGive <= 0); //if the user entered a valid double but it was negative, do it all again
		
	    
	    //HERE IS WHERE YOUR CODE SHOULD GO.
	    //Start handling changeToGive here.
		int changeLeft;
		changeLeft = (int) (changeToGive * 100);
		int coinsUsed = 0;
		while (changeLeft > 0){
			if (changeLeft - 25 >= 0) {
				changeLeft -= 25;
			}
			else if (changeLeft - 10 >= 0) {
				changeLeft -= 10;
			}
			else if (changeLeft - 5 >= 0) {
				changeLeft -= 5;
			}
			else {
				changeLeft -= 1;
			}
			coinsUsed += 1;
		}
		System.out.println(coinsUsed);
	}
}
