package mr.gonzalez.xc240.ps13;

import java.util.Random;

public class BasicKnightsTour implements KnightsTour {
    private Random pointGen = new Random();
    private Random directionGen = new Random();
    private int[][] board = {{-1, -1, -1, -1 , -1 , -1, -1, -1},{-1, -1, -1, -1 , -1 , -1, -1, -1},
            {-1, -1, -1, -1 , -1 , -1, -1, -1},{-1, -1, -1, -1 , -1 , -1, -1, -1},{-1, -1, -1, -1 , -1 , -1, -1, -1},
            {-1, -1, -1, -1 , -1 , -1, -1, -1},{-1, -1, -1, -1 , -1 , -1, -1, -1},{-1, -1, -1, -1 , -1 , -1, -1, -1}};
    @Override
    public void reset() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                board[y][x] = -1;
            }
        }
    }

    @Override
    public void start() {
        int[] startPosition = {pointGen.nextInt(8), pointGen.nextInt(8)};
        start(startPosition);

    }

    @Override
    public void start(int[] position) {
        move(position);

    }

    @Override
    public void move(int[] position) {

    }

    public boolean[] canMove(int[] position) {
        boolean[] returnBool = new boolean[8];
        for (int x = 0; x < MOVES.length; x++) {
            int[] pointTest = {position[0]-MOVES[x][0], position[1]-MOVES[x][1]};
            if (board[pointTest[0]][pointTest[1]] == -1 && 0 <= pointTest[0] && pointTest[0]<= 7 && 0 <= pointTest[1] && pointTest[1]<= 7) {
                returnBool[x] = true;
            }
        }
        return returnBool;
    }

    public int[] possibleMoves(int[] position) {
        for (int x = 0; x < )
        if (canMove(position)) {

        }
    }

    @Override
    public String getStateVars() {
        return null;
    }

    @Override
    public int[] getBoardState() {
        return new int[0];
    }

    @Override
    public String getBoardStateStr() {
        return null;
    }
}
