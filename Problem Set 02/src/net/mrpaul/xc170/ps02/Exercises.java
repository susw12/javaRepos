package net.mrpaul.xc170.ps02;
/*
 * 
 * 
 * 
 */



import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public static final String OWNERNAME = "Sujay";

public class Exercises {

	public static void main(String[] args){
		
		/* Method calls.  Un-comment any line to make that method run.  
		 * Note: When you click run, the main method is the one that runs.
		 * That means that each method that you uncomment will run sequentially.
		 * If you were to include repeat calls, the method would run multiple times.
		 */
		
		tempChecker();
		//guardDog();
		//coinFlip();
		//rollDice();
		//quadraticFormula(1.0, 1.0, -4.0);  //see this?  These are arguments, not Scanner input
		//guessMyNumberLimited();
		//guessMyNumberUnlimited();
	}//end of Exercises main method
	
	
	//tempChecker()
	public static void tempChecker(){
        Scanner tempCaller = new Scanner(System.in);
        System.out.print("What is the temperature? ");
        double indoorTemp = tempCaller.nextDouble();
        /*
        if (indoorTemp > 80){
            System.out.println("It's hot in here!");
        }
        else {
            System.out.println("Not too hot.");
        }
        if (indoorTemp < 60) {
            System.out.println("Brr, too cold!");
        }
        else {
            System.out.println("Not too cold.");
        }
        */

        if (indoorTemp > 80) {
            System.out.println("Hot in here!");
        }
        else if (indoorTemp < 60) {
            System.out.println("Brrr, too cold!");
        }
        else {
            System.out.println("A-OK.");
        }


	}
	public static void guardDog(){


	}


	//coinFlip()
	public static void coinFlip(){

	}

	//rollDice()
	public static void rollDice(){

	}


	//quadraticFormula()
	public static void quadraticFormula(double a, double b, double c){

	}

	//guessMyNumberLimited()
	public static void guessMyNumberLimited(){


	}

	//guessMyNumberUnlimited()
	public static void guessMyNumberUnlimited(){


	}


}
