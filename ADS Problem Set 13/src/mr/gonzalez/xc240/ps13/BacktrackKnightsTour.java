package mr.gonzalez.xc240.ps13;

import java.util.Random;

public class BacktrackKnightsTour implements KnightsTour {
    private int[][] board;
    int movesMade = 0, row = 0, col = 0, dim;
    boolean isGood = true;


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

    public boolean getIsGood() {
        return isGood;
    }

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

    public static int[][] copy (int[][] a) {
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
    public int[][] getBoard() {return board;}
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

    public BacktrackKnightsTour clone() {
        BacktrackKnightsTour toReturn = new BacktrackKnightsTour(dim);
        toReturn.board = copy(board);
        toReturn.col = col;
        toReturn.row = row;
        toReturn.movesMade = movesMade;
        toReturn.isGood = isGood;
        return toReturn;
    }


    public static void main(String[] args) {
        BacktrackKnightsTour start = new BacktrackKnightsTour(5);
        start.startTour();

        System.out.println(recursive(start));

    }


}
