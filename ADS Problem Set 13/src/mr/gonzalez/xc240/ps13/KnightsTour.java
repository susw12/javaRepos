package mr.gonzalez.xc240.ps13;

public interface KnightsTour {
	final int UNVISITED = -1;
	final int[][] MOVES = {{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2},{1,2},{2,1}};


	void reset();
	void startTour(int x, int y);
	void startTour();
	void move();
	int getMovesMade();
	int getRow();
	int getCol();
	int[][] getBoard();
	int[][] getPossibleMoves();
	String toString();


}
