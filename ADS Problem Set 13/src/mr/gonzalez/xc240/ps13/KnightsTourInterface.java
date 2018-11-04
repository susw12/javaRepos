package mr.gonzalez.xc240.ps13;

public interface KnightsTourInterface {

    /**
     * Indicator of a place the knight hasn't been
     */
    public static final int UNVISITED = -1;

    /**
     * All possible moves, however this does not mean the knight can make all these moves at the moment
     */
    public static final int[][] MOVES = {{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1}};

    /**
     * Start the tour at a specified position
     * @param row row 0-7 starting top
     * @param col column 0-7 starting left
     */
    public void startTour(int row,int col);

    /**
     * Start at a random position (uses other startTour method)
     */
    public void startTour();

    /**
     * @return row index, 0 through and including 7.
     */
    public int getCurrentRow();

    /**
     * @return column index, 0 through and including 7
     */
    public int getCurrentCol();

    /**
     * Return a 2d array of the moves that the knight CAN make.
     * @return an array of possible moves
     */
    public int[][] getPossibleMoves();

    /**
     * Return the number of squares that have been visited
     * @return the number of visited squares, so ones not marked by UNVISITED (-1)
     */
    public int getNumVisited();

    /**
     * Makes a move based on the algorithm
     * @return new position after move. Null if move is impossible
     */
    public int[] makeMove();

    /**
     * Makes a move based on user input
     * @param m the move
     * @return new position after move. Null if move is impossible
     */
    public int[] makeMove(int[] m);

    /**
     * Getter for the board.
     * @return the current board with the knight's moves marked by the turn it visited the square and empty squares with UNVISITED
     */
    public int[][] getBoardState();

    /**
     * @return String representation of the board with the knight's moves marked by the turn it visited the square and empty squares with "-" (UNVISITED)
     */
    public String getBoardDisplay();

    /**
     * Reset the board (restarts the game)
     */
    public void reset();


}
