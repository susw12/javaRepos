package mr.gonzalez.xc240.ps13;

import java.util.Random;

/**
 * Backtracking Knights Tour
 *
 * <p> Uses recursive backtracking to solve the problem</p>
 * <p> 100% accuracy 100% of the time</p></p>
 *
 * @author Sujay Swain
 *
 * Problem Set: ADSB: PS13
 */

public class BacktrackKnightsTour implements KnightsTour {
    private int[][] board;
    int movesMade = 0;
    int row = 0;
    int col = 0;
    int dim;
    boolean isGood = true;

    /**
     * Creates a backtracking object
     *
     * @param dim
     *
     * @author Sujay Swain
     */
    public BacktrackKnightsTour(int dim) {
        this.dim = dim;
        board = new int[dim][dim];
        reset();
    }



    public void reset() {
        movesMade = 0;
        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                board[i][j] = UNVISITED;
            }
        }
    }

    public void startTour(int x, int y) {
        row = x;
        col = x;
        moveTo(x, y);
    }

    /**
     * Checking validity just for my own, this is easier to read)
     * @return isGood
     *
     * @author Sujay Swain
     */
    public boolean getIsGood() {
        return isGood;
    }

    /**
     * Changes the state for the isGood to bad (false)
     *
     * @author Sujay Swain
     */
    public void setBad() {
        isGood = false;
    }

    public void startTour() {
        startTour(0, 0);
        //Random r = new Random();
        //startTour(r.nextInt(dim), r.nextInt(dim));
    }
    public void move() {

        int[][] possMoves = getPossibleMoves();
        int numPossMoves = possMoves.length;
        for (int i = 0; i < numPossMoves; i++) {

        }
        int[] move = possMoves[new Random().nextInt(numPossMoves)];
        moveTo(row + move[0], col + move[1]);

    }


    /**
     * Makes the recursive moves for the backtracking algorithm
     *
     * @param r
     * @return A backtrackingKnightsTour object
     *
     * @author Sujay Swain
     */
    public static BacktrackKnightsTour recursive(BacktrackKnightsTour r) {
        if (! r.getIsGood()) return r;
        if (r.getMovesMade() == r.dim * r.dim) {
            return r;
        }

        int[][] possMoves = r.getPossibleMoves();
        int numPossMoves = possMoves.length;

        for (int i = 0; i < numPossMoves; i++) {
            int[] move = possMoves[i];
            BacktrackKnightsTour a = r.clone();
            a.moveTo(a.getRow() + move[0], a.getCol() + move[1]);
            BacktrackKnightsTour b = recursive(a);


            if (b.getMovesMade() == b.dim * b.dim) {
                return b;
            }

        }
        r.setBad();
        return r;
    }

    public  int[][] copy(int[][] a) {
        int[][] toReturn = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                toReturn[i][j] = a[i][j];
            }
        }
        return toReturn;
    }

    public void moveTo(int row, int col) {this.row = row; this.col = col; movesMade++; board[row][col] = movesMade;}
    public int getRow() {return row;}
    public int getCol() {return col;}
    public int getMovesMade() {return movesMade;}
    public int[][] getBoardState() {return board;}
    public String toString() {
        String toReturn = "";
        for (int i = 0; i < dim; i++) {
            String line = "";
            for (int j = 0; j < dim; j++) {
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
            if (newRow < 0 || newCol < 0 || newRow >= dim || newCol >= dim) continue;
            if (board[newRow][newCol] == UNVISITED) {numPoss++; possible[i] = true;}

        }
        int[][] toReturn = new int[numPoss][2];
        int addIndex = 0;
        for (int i = 0; i < MOVES.length; i++) if (possible[i]) {toReturn[addIndex] = MOVES[i]; addIndex++;}
        return toReturn;
    }

    /**
     * Clones the board
     * @return Returns a BackTrackKnights object that is the clone
     */
    public BacktrackKnightsTour clone() {
        BacktrackKnightsTour toReturn = new BacktrackKnightsTour(dim);
        toReturn.board = copy(board);
        toReturn.col = col;
        toReturn.row = row;
        toReturn.movesMade = movesMade;
        toReturn.isGood = isGood;
        return toReturn;
    }

    /**
     * Runs the backtracking algorithm on the board (recursively (sooo slow)) to solve the board from any point
     *
     * @param args
     *
     * @author Sujay Swain
     */
    public static void main(String[] args) {
        BacktrackKnightsTour start = new BacktrackKnightsTour(5);
        start.startTour();

        System.out.println(recursive(start));

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
        return dim;
    }

    public void setDimensions(int dimensions) {
        this.dim = dimensions;
    }


}
