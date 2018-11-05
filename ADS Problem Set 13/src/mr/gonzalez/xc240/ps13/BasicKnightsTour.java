package mr.gonzalez.xc240.ps13;

import java.util.Random;

/**
 * Basic Knights Tour
 *
 * <p> Just randomly finds positions to move to </p>
 * <p> Most probably does not hit max moves</p></p>
 *
 * @author Sujay Swain
 *
 * Problem Set: ADSB: PS13
 */

public class BasicKnightsTour implements KnightsTour {
    private int[][] board;
    int movesMade = 0, row = 0, col = 0, dim;

    /**
     * Creates a board with the dimensions of dim
     * @param dim
     *
     * @author Sujay Swain
     */
    public BasicKnightsTour(int dim) {
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

    public void startTour() {Random r = new Random(); startTour(r.nextInt(dim), r.nextInt(dim));}
    public void move() {

        int[][] possMoves = getPossibleMoves();
        int numPossMoves = possMoves.length;
        int[] move = possMoves[new Random().nextInt(numPossMoves)];
        moveTo(row + move[0], col + move[1]);

    }

    public int[][] copy (int[][] a) {
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

    /**
     * Simple main function that runs my program (with checking for final case)
     * @param args
     *
     * @author Sujay Swain
     */
    public static void main(String[] args) {
        BasicKnightsTour start = new BasicKnightsTour(8);
        start.startTour();
        while (true) {
            try {start.move();}
            catch (Exception e) {System.out.println(start); break;}

        }

    }

}
