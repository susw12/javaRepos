package mr.gonzalez.XC240;
import java.util.Scanner;
import java.io.*;
import java.util.Random;

/**
 *Defines a board
 *
 *<p> All the methods to make a 2048 board. Including movement, loading boards, adding tiles, score, etc
 *<p> ADSb PS12: 2048
 *
 *@author Sujay Swain
 */
public class Board {
	private int gameSize, score;
	private Tile[][] board;

	/**
	 * Default board constructor
	 * <p> Defined as a 4 x 4 board and a score of 0
	 * @author Wensen Liu
	 */
	Board(){
		score = 0;
		gameSize = 4;
		board = new Tile[gameSize][gameSize];
		for(int i = 0; i < gameSize; i++){for(int j = 0; j < gameSize; j++){board[i][j] = new Tile();}}
	}

	/**
	 * Board Constructor
	 * <p> Defined as a board with score 0 but specified num x num board size
	 * @author Wensen Liu
	 * @param size an integer that defines the length and width of the board
	 */
	Board(int size){
		score = 0;
		gameSize = size;
		board = new Tile[gameSize][gameSize];
		for(int i = 0; i < gameSize; i++){for(int j = 0; j < gameSize; j++){board[i][j] = new Tile();}}
	}

	/**
	 * Board Constructor
	 * <p> Defined as a board with given score and size
	 *
	 * @author Wensen Liu
	 * @param size the length and width of the board
	 * @param newScore which is the starting score
	 */
	Board(int size, int newScore){
		score = newScore;
		gameSize = size;
		board = new Tile[gameSize][gameSize];
		for(int i = 0; i < gameSize; i++){for(int j = 0; j < gameSize; j++){board[i][j] = new Tile();}}
	}

	/**
	 * Board Constructor
	 * <p> Loads a board from a file
	 * <p> Assumes: File of name exists in working directory
	 *
	 * @author Wensen Liu
	 * @param fileName the file in the working directory
	 * @throws IOException
	 */
	Board(String filename) throws IOException{
		loadBoardState(filename);
	}

	/**
	 * Loads the board from a file
	 * <p> Takes a file and reads loads a state from it
	 * <p> Reads through each integer, the first one is the score, then the game size, then the board state
	 * <p> Assumes: File of name exists in working directory
	 *
	 * @author Wensen Liu
	 * @param fileName the file in the working directory
	 * @throws IOException
	 */
	public void loadBoardState(String filename) throws IOException{
		int row = 0, column = 0;
		//gets the file
		Scanner reader = new Scanner(new File(filename));
		//reads the first 2 lines
		if(reader.hasNextInt()){score = reader.nextInt();}
		if(reader.hasNextInt()){gameSize = reader.nextInt();}
		//new board of gamesize
		board = new Tile[gameSize][gameSize];
		//reads through each of the remaining numbers for the board state
		while(reader.hasNextInt()){
			if(column == gameSize){
				column = 0;
				row += 1;
			}
			board[row][column] = new Tile(reader.nextInt());
			column ++;
		}
	}

	/**
	 * Resets the board
	 * <p> Sets all the board values and score to 0
	 * @author Wensen Liu
	 */
	public void reset(){
		score = 0;
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				board[i][j] = new Tile();
			}
		}
	}

	/**
	 * Counts the number of empty spaces
	 * <p> Iterates through each value in the board, counts the number of values that are 0
	 * @author Wensen Liu
	 * @return an integer that is the amount of empty spaces
	 */
	public int countEmptySpaces(){
		int counter = 0;
		for(Tile[] element : board){
			for(Tile thing : element){
				if(thing.getValue() == 0) counter ++;
			}
		}
		return counter;
	}

	/**
	 * Gets the score
	 * @author Wensen Liu
	 * @return An integer that is the score
	 */
	public int getScore(){return score;}
	//for testing purposes only!!!
	/**
	 * Gets the board
	 * @author Wensen Liu
	 * @return A tile 2D array that is the board
	 */
	public Tile[][] getBoard(){return board;}

	/**
	 * Converts the board to a string
	 * <p> Defined as score, then the tile values separated by tabs
	 * @author Wensen Liu
	 * @return A string that is a representation of the board
	 */
	public String toString(){
		String rep = "";
		for(Tile[] element : board){
			for(Tile thing : element){
				rep += thing + "\t";
			}
			rep += "\n";
		}
		return "Score: " + score + "\n" + rep;
	}

	/**
	 * Checks if the board is full
	 * <p> If the board has no empty spaces, then it is full.
	 * @author Wensen Liu
	 * @return A boolean representing if the board is full
	 */
	public boolean isFull(){
		if(this.countEmptySpaces() == 0){return true;}
		else{return false;}
	}

	/**
	 * Adds a tile
	 * <p> Creates a list of all the coordinates that there are empty spaces
	 * <p> Randomly chooses one of those coordinates
	 * <p> Adds a tile there that is either a 2 or a 4 on a 90 to 10 percent respectively
	 * @author Wensen Liu
	 */
	public void addTile(){
		if(!this.isFull()){
			int theValue, row = 0, column = 0;
			//new array of the coordinate of the empty spaces
			int[][] emptySpaces = new int[this.countEmptySpaces()][2];
			//decides whether it is a 2 or a 4
			Random generator = new Random();
			int decider = generator.nextInt(10);
			if(decider == 9){theValue = 4;}
			else{theValue = 2;}
			//records the coordinates of each individual empty tile
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board[i].length; j++){
					if(board[i][j].getValue() == 0){
						emptySpaces[row][column] = i;
						emptySpaces[row][column+1] = j;
						row ++; column = 0;
					}
				}
			}
			//decides which tile of the coords should be used
			int whichCoords = generator.nextInt(this.countEmptySpaces());
			//sets the tile at the coordinates to a new tile of the value
			board[emptySpaces[whichCoords][0]][emptySpaces[whichCoords][1]] = new Tile(theValue);
		}
	}

	/**
	 * Rotates the board clockwise
	 * <p> Switches first row with the last column and etc for second rown second to last column
	 * @author Wensen Liu
	 */
	public void rotateCW(){
		//clones the original board for reference purposes
		Tile[][] clone = new Tile[gameSize][gameSize];
		for(int i = 0; i < board.length; i++){
			for(int j = 0; j < board[i].length; j++){
				clone[i][j] = new Tile(board[i][j].getValue());
			}
		}
		//swaps the first row to become the last column and so on
		int k = 0;
		for(int i = board.length-1; i >= 0; i--){
			for(int j = 0; j < board.length; j++){
				board[j][i] = new Tile(clone[k][j].getValue());
			}
			k++;
		}
	}

	/**
	 * Checks if there are any available moves
	 * <p> Checks each values adjacent tiles up down left right etc to see if they are empty or the same value
	 * <p> If they are then there are moves, but if they arent then there are no moves
	 * <p> Only if the board is full does this test run.
	 *
	 * @author Wensen Liu
	 * @return A boolean that represents whether there are available moves
	 */
	public boolean canMove(){
		if(!this.isFull()){return true;}
		else{
			for(int i = 0; i < board.length; i++){
				for(int j = 0; j < board.length; j++){
					int elementRow = board[i][j].getValue();
					int elementColumn = board[j][i].getValue();
					if(j != board.length - 1){
						if(elementRow == board[i][j+1].getValue()){return true;}
						if(elementColumn == board[j+1][i].getValue()){return true;}
					}
				}
			}
			return false;
		}
	}

	/**
	 * Moves the board left
	 * <p> Goes through each tile. Checks the following tiles for first nonempty tile.
	 * <p> Same tile, combine and move logical size over
	 * <p> Different tile, move tile into next available empty space (or don't move if right next to)
	 * <p> Zero tile, replace tile with value, specialize decrement of logical size
	 * <p> If any movement was made then set the value for if the program did something to true
	 *
	 * @author Wensen liu
	 * @return A boolean that represents if left moved anything
	 */
	public boolean left(){
		boolean didSomething = false;
		//for each tile
		for(int i = 0; i < board.length; i ++){
			for(int j = 0; j < board.length; j++){
				int currentElement = board[i][j].getValue();
				//checks the rest of the values
				for(int k = j+1; k < board.length; k++){
					int followingElement = board[i][k].getValue();
					//for first nonzero element
					if(followingElement != 0){
						//the current element it 0
						if(currentElement == 0){
							didSomething = true;
							board[i][j] = new Tile(followingElement);
							board[i][k] = new Tile();
							//The god piece of code. right here.
							j--;
							break;
						}
						//the current element = the following element
						else if(followingElement == currentElement){
							didSomething = true;
							board[i][j] = new Tile(followingElement * 2);
							board[i][k] = new Tile();
							score += followingElement * 2;
							break;
						}
						//the current element != the following element
						else{
							board[i][j+1] = new Tile(followingElement);
							if(k != j+1){
								didSomething = true;
								board[i][k] = new Tile();
							}
							break;
						}
					}
				}
			}
		}
		return didSomething;
	}

	/**
	 * Moves the board right
	 * <p> Rotates the board cw twice
	 * <p> Moves left
	 * <p> Rotates cw twice to get original orientation
	 * <p> Movement boolean is whether left did anything
	 *
	 * @author Wensen Liu
	 * @return A boolean whether left did anything
	 */
	public boolean right(){
		boolean didSomething = false;
		this.rotateCW();this.rotateCW();
		didSomething = this.left();
		this.rotateCW();this.rotateCW();
		return didSomething;
	}

	/**
	 * Moves the board up
	 * <p> Rotates cw three times
	 * <p> Move left
	 * <p> Rotate cw once to get original orientation
	 * <p> Movement boolean is whether left moved anything
	 *
	 * @author Wensen Liu
	 * @return A boolean whether left did anything
	 */
	public boolean up(){
		boolean didSomething = false;
		this.rotateCW();this.rotateCW();this.rotateCW();
		didSomething = this.left();
		this.rotateCW();
		return didSomething;
	}

	/**
	 * Moves the board down
	 * <p> Rotates cw once
	 * <p> Move left
	 * <p> Rotate cw three times to get original orientation
	 * <p> Movement boolean whether left did anything
	 *
	 * @author Wensen Liu
	 * @return A boolean whether left did anything
	 * @throws any exceptions your method throw
	 */
	public boolean down(){
		boolean didSomething = false;
		this.rotateCW();
		didSomething = this.left();
		this.rotateCW();this.rotateCW();this.rotateCW();
		//System.out.println(didSomething);
		return didSomething;
	}

	/**
	 * Copies the board
	 * <p> Copies the score and the board size and values in the board to a new board
	 *
	 * @author Wensen Liu
	 * @return a Board that is a "deeply copied" version of the other
	 */
	public Board copyBoard(){
		Board copy = new Board(gameSize, score);
		//goes through each value and copies it into the respective place
		for(int i = 0; i < copy.board.length; i ++){
			for(int j = 0; j < copy.board.length; j++){
				copy.board[i][j] = new Tile(board[i][j].getValue());
			}
		}
		return copy;
	}
	/**
	 * Quits the program
	 * @author Wensen Liu
	 */
	public void quit(){System.exit(0);}
}
