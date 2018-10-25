package mr.gonzalez.XC240;

import mr.gonzalez.XC240.Board;

/**
 * The game
 *
 *<p> ADSb PS12: 2048
 *
 *@author Sujay Swain
 */
public class Game2048 {
	Board board; Game2048View view; Game2048Controller controller;

	/**
	 * Runs the game (like actually)
	 *
	 * @author Wensen Liu
	 * @param args a String array
	 */
	public static void main(String args[]){
		Game2048 game = new Game2048();
		game.runGame();
	}

	/**
	 * Game constructor
	 * <p> Instantiates a view, controller, and board
	 *
	 * @author Wensen Liu
	 */
	public Game2048(){
		board = new Board();
		view = new Game2048View(board);
		controller = new Game2048Controller(board, view);
	}

	/**
	 * Runs the game using the controller
	 *
	 * @author Wensen Liu
	 */
	public void runGame(){controller.runGame();}
}
