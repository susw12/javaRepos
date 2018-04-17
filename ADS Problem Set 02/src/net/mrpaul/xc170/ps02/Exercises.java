package net.mrpaul.xc170.ps02;
/**
 *Many different exercises
 *This is a programs containing many different exercise. The exercises include a temperature advice, a guard dog, a coin flip,
 *rolling a die, a quadratic formula and two guessing the number programs.
 *<p>
 *ADS PS02: Exercises
 *2/27/2018
 *
 *@author Sujay Swain
*/



import java.util.Scanner;
import java.lang.Math;
import java.util.Random;



public class Exercises {
	public static Random rand = new Random();
	public static final String OWNERNAME = "Sujay";
    /**
     * Summary fragment: Calls all methods
     * <p> Calls all method in the exercises</p>
     *
     * @author Sujay Swain
     */
	public static void main(String[] args){
		
		/* Method calls.  Un-comment any line to make that method run.  
		 * Note: When you click run, the main method is the one that runs.
		 * That means that each method that you uncomment will run sequentially.
		 * If you were to include repeat calls, the method would run multiple times.
		 */
		
		//tempChecker();
		//guardDog();
		//coinFlip();
		//rollDice();
		//rollDice();
		//quadraticFormula(1.0, 1.0, -4.0);  //see this?  These are arguments, not Scanner input
		guessMyNumberLimited();
		guessMyNumberUnlimited();
	}//end of Exercises main method

    /**
     * Summary fragment: Gives temperature advice
     * <p>gives advice about the temperature like whether or not it is too cold or too hot</p>
     * @author Sujay Swain
     */
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
        }//end of if
        else if (indoorTemp < 60) {
            System.out.println("Brrr, too cold!");
        }//end of else if
        else {
            System.out.println("A-OK.");
        }//end of else


	}//End of tempChecker()
    /**
     * Summary fragment: Guard Dog Program
     * <p>A guard dog program that either welcomes you or rejects you terribly.</p>
     *
     * @author Sujay Swain
     */
	public static void guardDog(){
		Scanner nameCall = new Scanner(System.in);
		System.out.print("What is your name? ");
		String nameCheck = nameCall.nextLine();
		if (nameCheck.equalsIgnoreCase(OWNERNAME)){
			System.out.println("Woof Woof! Welcome home, " + OWNERNAME + ".  Please accept these licks as a sign of my loyal affection.  Now please take me outside so I may have a quick poo.");
		}//end of if
		else {
			System.out.println("RUFF RUFF RUFF RUFF GO AWAY RUFF RUFF RUFF!");
		}//en

	}//end of guardDog()

    /**
     * Summary fragment: Coin flip
     * <p>A program that does a coin flip!</p>
     *
     * @author Sujay Swain
     */
	//coinFlip()
	public static void coinFlip(){
		Random rand = new Random();
		int side = rand.nextInt(2);
		if (side ==  0) {
			System.out.println("Heads.");
		}//end of if
		else {
			System.out.println("Tails.");
		}//end of else

	}//end of coinFlip()
    /**
     * Summary fragment: A die roller
     * <p>A die roller that actually shows that </p>
     *
     * @author Sujay Swain
     */
	//rollDice()
	public static void rollDice(){
		int face1 = rand.nextInt(6) + 1;
		int face2 = rand.nextInt(6) + 1;

		System.out.println("You rolled " + face1 + ", " + face2 + ":");
		System.out.println("----------");
		switch(face1) {
			case 1: System.out.println("\n\tx\n");
					break;
			case 2: System.out.println("x\n\n\t\tx");
					break;
			case 3: System.out.println("x\t\t\n\tx\t\n\t\tx");
					break;
			case 4: System.out.println("x\t\tx\n\nx\t\tx");
					break;
			case 5: System.out.println("x\t\tx\n\tx\nx\t\tx");
					break;
			case 6: System.out.println("x\t\tx\nx\t\tx\nx\t\tx\n");
					break;
			default: System.out.println("Your die landed on an edge.");
					break;
		}//end of switch statement
		System.out.println("----------");
		switch(face2) {
			case 1: System.out.println("\n\tx\n");
					break;
			case 2: System.out.println("x\n\n\t\tx");
					break;
			case 3: System.out.println("x\t\t\n\tx\t\n\t\tx");
					break;
			case 4: System.out.println("x\t\tx\n\nx\t\tx");
					break;
			case 5: System.out.println("x\t\tx\n\tx\nx\t\tx");
					break;
			case 6: System.out.println("x\t\tx\nx\t\tx\nx\t\tx\n");
					break;
			default: System.out.println("Your die landed on an edge.");
					break;
		}//end of another switch statement
		System.out.println("----------");
	}//end of rollDice()

    /**
     * Summary fragment: Quadratic equation solver
     * <p>A quadratic equation solver. <br>
     *    It is able to tell how many results there will be, any errors and also, invalid inputs.</p>
     *
     * @author your-name
     * @param a user input variable for part of the equation
     * @param b user input variable for part of the equation
     * @param c user input variable for part of the equation
     * @throws IllegalArgumentException if 0 is entered for a
     */
	//quadraticFormula()
	
	public static void quadraticFormula(double a, double b, double c){
		if (a == 0){
			throw new IllegalArgumentException("Required condition: a != 0, but actual parameter was " + a);
		}//end of if
		else if (Math.pow(b, 2)-4*a*c < 0) {
            System.out.println("There is no solution.");
        }//end of else if
		else if (Math.pow(b, 2)-4*a*c == 0.0){
			System.out.println("This worked");
			System.out.println("Your solutions are x=" + -b/(2*a) + ".");
		}//end of else if
		else {
			System.out.println("Your solutions are x=" + ((-b+Math.sqrt(Math.pow(b, 2)-4*a*c))/2*a) + " and x=" + ((-b-Math.sqrt(Math.pow(b, 2)-4*a*c)/2*a)) + ".");
		}//end of else

	}//end of quadraticFormula()
    /**
     * Summary fragment: Number guesser
     * <p>A number guesser with limited trials</p>
     *
     * @author Sujay Swain
     */
	//guessMyNumberLimited()
	public static void guessMyNumberLimited(){
		int userGuess = 1;
		int counter = 1;
		int randNumber = rand.nextInt(1000)+1;
		Scanner getNum = new Scanner(System.in);
		while (counter <= 10) {
			System.out.print("Guess " + counter + ": ");
			userGuess = getNum.nextInt();
			if (userGuess == randNumber){
				System.out.println("Congratulations!  You got it.  The number was " + randNumber + ".");
				counter = 10;
			}//another if statement
			else {
				if (userGuess > randNumber)
					System.out.println("Guess lower.");
				else {
					System.out.println("Guess higher.");
				}//end of else statement (nested in an if)
			}//end of another else statement
			counter++;
			

		}//end of while loop
		if (userGuess != randNumber) {
			System.out.println("Sorry, you have no guesses left.  The number was " + randNumber + ".");
		}//end of if statement
	}//end of guessMyNumberLimited()
    /**
     * Summary fragment: Number guesser
     * <p>A number guesser with unlimited trials</p>
     *
     * @author Sujay Swain
     */
	//guessMyNumberUnlimited()
	public static void guessMyNumberUnlimited(){
		int userGuess;
		int guessNumber = 1;
		boolean checker = false;
		int randNumber = rand.nextInt(1000)+1;
		Scanner getNum = new Scanner(System.in);
		while (!checker) {
			System.out.print("Guess " + guessNumber + ": ");
			userGuess = getNum.nextInt();
			if (userGuess == randNumber){
				System.out.println("Congratulations!  You got it.  The number was " + randNumber + ".");
				checker = true;
            }//another if statement
			else {
				if (userGuess > randNumber)
					System.out.println("Guess lower.");
				else {
					System.out.println("Guess higher.");
				guessNumber++;
                }//end of else statement (nested in an if)
            }//end of another else statement
		}//end of while loop
	}//end of guessMyNumberUnlimited


}
