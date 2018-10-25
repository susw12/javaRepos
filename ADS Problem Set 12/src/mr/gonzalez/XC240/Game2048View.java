package mr.gonzalez.XC240;

import java.util.Scanner;
/**
 *Controls the view of the game
 *
 *<p> User action and updating display
 *<p> ADSb PS12: 2048
 *
 *@author Sujay Swain
 */
public class Game2048View {
	Board currentBoard;
	/**
	 * View Constructor
	 * <p> Uses the board given it
	 * @author Wensen Liu
	 * @param brd a board
	 */
	public Game2048View(Board brd){currentBoard = brd;}

	/**
	 * Sets the board
	 * @author Wensen Liu
	 * @param brd the board that is being set
	 */
	public void setBoard(Board brd){currentBoard = brd;}

	/**
	 * Gets the user's input
	 * <p> Receives input via a scanner
	 * <p> Translates it into its equivalent enumeration
	 *
	 * @author Wensen Liu
	 * @return An UserAction that is the users corresponding input
	 */
	public UserAction getUserAction(){
		UserAction value;
		Scanner reader = new Scanner(System.in);
		System.out.print("Next action: [W]Up, [A]Left, [S]Down, [D]Right, [Q]uit, [R]eset: ");
		String action = reader.nextLine();
		if(action.equalsIgnoreCase("w")) {value = UserAction.UP;}
		else if(action.equalsIgnoreCase("a")) {value = UserAction.LEFT;}
		else if(action.equalsIgnoreCase("s")) {value = UserAction.DOWN;}
		else if(action.equalsIgnoreCase("d")) {value = UserAction.RIGHT;}
		else if(action.equalsIgnoreCase("q")) {value = UserAction.QUIT;}
		else if(action.equalsIgnoreCase("r")) {value = UserAction.RESET;}
		else {value = UserAction.INVALID;}
		//System.out.println(value);
		return value;
	}

	/**
	 * Updates the display
	 * <p> Prints out the board's string interpretation
	 * @author Wensen Liu
	 */
	public void updateDisplay(){System.out.println(currentBoard.toString());}
}
