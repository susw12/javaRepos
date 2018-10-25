package mr.gonzalez.XC240;
/** 
 * Controls the game
 *
 *<p> Translates the enumerations from the view into board actions and updates
 *<p> ADSb PS12: 2048
 *
 *@author Sujay Swain
 */
public class Game2048Controller {
	Board board; Game2048View view;

	/**
	 * Controller Constructor
	 * <p> Uses the board and view given it
	 *
	 * @author Wensen Liu
	 * @param b a Board
	 * @param v a View
	 */
	public Game2048Controller(Board b, Game2048View v){board = b; view = v;}

	/**
	 * Runs the game
	 * <p> Translates the Enumeration from the view into its respective action for the board then
	 * updates the board until the game ends.
	 * @author Wensen Liu
	 */
	public void runGame(){
		view.updateDisplay();
		board.addTile();
		while(board.canMove()){
			//translates the useractions
			UserAction move = view.getUserAction();
			if(move == UserAction.LEFT && board.left()){board.addTile();}
			if(move == UserAction.RIGHT && board.right()){board.addTile();}
			if(move == UserAction.UP && board.up()){board.addTile();}
			if(move == UserAction.DOWN && board.down()){board.addTile();}
			if(move == UserAction.QUIT){board.quit();}
			if(move == UserAction.RESET){board.reset(); this.runGame();}
			if(move == UserAction.INVALID){view.getUserAction();}
			view = new Game2048View(board);
			view.updateDisplay();
		}
		System.out.println("GAME OVER...\nScore: " + board.getScore());
	}
}
