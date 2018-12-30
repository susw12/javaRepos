package mr.gonzalez.xc240.ps13;

public interface KnightsTour {

	/**
	 * Indicator of a place the knight hasn't been
     *
     * @author Sujay Swain
	 */
	final static int UNVISITED = -1;

    /**
     * All possible moves, however this does not mean the knight can make all these moves at the moment
     *
     * @author Sujay Swain
     */
	final static int[][] MOVES = {{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1}};

    /**
     * Reset the board to the original -1 in all space
     *
     * @author Sujay Swain
     */
    public void reset();

    /**
     * Start at a random position (
     *
     * @author Sujay Swain
     */
    public void startTour();

    /**
     * Start the tour at a specified position
     *
     * @author Sujay Swain
     * @param x row 0-length of board -1 starting top
     * @param y column 0-height of board -1 starting left
     */
	public void startTour(int x, int y);

    /**
     * @return row index, 0 through and up to but not including length of board
     *
     * @author Sujay Swain
     */
    public int getRow();

    /**
     * @return column index, 0 through and up to but not including height of board
     *
     * @author Sujay Swain
     */
    public int getCol();

    /**
     * Getter for the board.
     * @return the current board with the Knight's moves marked by the turn it visited the square and empty squares with UNVISITED (-1)
     *
     * @author Sujay Swain
     */
	public int[][] getBoardState();

    /**
     * Makes a move based on the algorithm
     *
     * @author Sujay Swain
     */
    public void move();

    /**
     * Return the number of squares that have been visited
     * @return the number of visited squares, so ones not marked by UNVISITED (-1)
     *
     * @author Sujay Swain
     */
    public int getMovesMade();

    /**
     * Returns a 2d array of all the possible moves that the knight can make.
     * @return an array of possible moves that the knight can make (point as in (x,y))
     *
     * @author Sujay Swain
     */
	public int[][] getPossibleMoves();

    /**
     *
     * Overloads current toString method for int[][] board
     * @return String representation of the board with the Knight's moves marking every visited square and  marking the empty squares with "_" (UNVISITED or -1)
     *
     * @author Sujay Swain
     */
	public String toString();

    /**
     * Takes the knight to a different point on the board
     *
     * @param x
     * @param y
     *
     * @author Sujay Swain
     */
	public void moveTo(int x, int y);

    /**
     * Makes a copy of the current point
     * @param point
     * @return copyOfThePoint
     *
     * @author Sujay Swain
     */
	public int[][] copy(int[][] point);

    /**
     * The following are getters and setters
     *
     * @author Sujay Swain
     */

    public void setBoard(int[][] board);

    public void setMovesMade(int movesMade);

    public void setRow(int row);

    public void setCol(int col);

    public int getDimensions();

    public void setDimensions(int dimensions);

}
