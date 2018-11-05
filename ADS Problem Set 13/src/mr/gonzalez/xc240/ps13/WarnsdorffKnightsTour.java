package mr.gonzalez.xc240.ps13;

import java.util.Random;

/**
 * Warnsdroff Knights Tour
 *
 * <p> Uses Warnsdorff's algorithm</p>
 * <p> High accuracy rate</p></p>
 *
 * @author Sujay Swain
 *
 * Problem Set: ADSB: PS13
 */

public class WarnsdorffKnightsTour implements KnightsTour {
	private int[][] board;
	private int movesMade = 0;
	private int row = 0;
	private int col = 0;
	private int dimensions;

    /**
     * This runs all possible cases and displays the average moves in total
     *
     * @param args
     *
     * @author Sujay Swain
     */
	public static void main(String[] args) {
		WarnsdorffKnightsTour start = new WarnsdorffKnightsTour(8);
		double movesSum = 0;
		for (int y = 0; y < start.dimensions; y++) {
		    for (int x = 0; x < start.dimensions; x++) {
                start.startTour(x, y);
                while (true) {
                    try {
                        start.move();
                    } catch (Exception e) {
                        System.out.println(start);
                        movesSum += start.getMovesMade();
                        break;
                    }
                }
            }
        }
        System.out.println(movesSum/(start.getDimensions()*start.getDimensions()));

	}

    /**
     * Creates a Warnsdroff Knight Tour Object
     *
     * @param dimensions
     *
     * @author Sujay Swain
     */
	public WarnsdorffKnightsTour(int dimensions) {
		this.dimensions = dimensions;
		board = new int[dimensions][dimensions];
		reset();
	}


	public void reset() {
		setMovesMade(0);
		for (int i = 0; i < dimensions; i++) {
			for (int j = 0; j < dimensions; j++) {
				board[i][j] = UNVISITED;
			}
		}
	}

	public void startTour(int x, int y) {
	    reset();
		row = x;
		col = x;
		moveTo(x, y);
	}

	public void startTour() {
		Random r = new Random();
		startTour(r.nextInt(dimensions), r.nextInt(dimensions));
	}

	public void move() {
		//preserve board state
		int[][] startBoard = copy(board);
		int startRow = row, startCol = col, startMovesMade = getMovesMade();

		//Warnsdorf: minimum possible moves (average approx. 63.8
		int[][] possibleMoves = getPossibleMoves();
		int[] numpossibleMoves = new int[possibleMoves.length];
		int minpossibleMoves = 99;
		int minIndex = 0;
		for (int i = 0; i < possibleMoves.length; i++) {
			moveTo(row + possibleMoves[i][0], col + possibleMoves[i][1]);
			numpossibleMoves[i] = getPossibleMoves().length;
			if (numpossibleMoves[i] < minpossibleMoves && numpossibleMoves[i] > 0) {
				minIndex = i;
				minpossibleMoves = numpossibleMoves[i];
			}
			board = copy(startBoard);
			row = startRow;
			col = startCol;
		movesMade = startMovesMade;
		}
		int[] move = possibleMoves[minIndex];
		moveTo(row + move[0], col + move[1]);

	}

	public int[][] copy(int[][] a) {
		int[][] toReturn = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				toReturn[i][j] = a[i][j];
			}
		}
		return toReturn;
	}

	public void moveTo(int row, int col) {
		this.row = row;
		this.col = col;
		movesMade++;
		board[row][col] = movesMade;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}

	public int getMovesMade() {
		return movesMade;
	}

	public int[][] getBoardState() {
		return board;
	}

	public String toString() {
		String toReturn = "";
		for (int i = 0; i < dimensions; i++) {
			String line = "";
			for (int j = 0; j < dimensions; j++) {
				int item = board[i][j];
				if (item == UNVISITED) line += "_";
				else line += board[i][j];
				line += "\t";
			}
			toReturn += line + "\n";
		}
		return toReturn;
	}

	public int[][] getPossibleMoves() {
		int numPoss = 0;
		boolean[] possible = new boolean[MOVES.length];
		for (int i = 0; i < MOVES.length; i++) {
			int newRow = row + MOVES[i][0];
			int newCol = col + MOVES[i][1];
			if (newRow < 0 || newCol < 0 || newRow >= dimensions || newCol >= dimensions) continue;
			if (board[newRow][newCol] == UNVISITED) {
				numPoss++;
				possible[i] = true;
			}

		}
		int[][] toReturn = new int[numPoss][2];
		int addIndex = 0;
		for (int i = 0; i < MOVES.length; i++)
			if (possible[i]) {
				toReturn[addIndex] = MOVES[i];
				addIndex++;
			}
		return toReturn;
	}

	public void setBoard(int[][] board) {
		this.board = board;
	}

	public void setMovesMade(int movesMade) {
		this.movesMade = movesMade;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getDimensions() {
		return dimensions;
	}

	public void setDimensions(int dimensions) {
		this.dimensions = dimensions;
	}
}

