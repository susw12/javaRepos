package mr.gonzalez.xc240.ps13;

public interface KnightsTour {
    final int UNVISITED = -1;
    final int[][] MOVES = {{2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}};

    public void reset();

    public void start();

    public void start(int[] position);

    public void move(int[] position);

    public String getStateVars();

    public int[] getBoardState();

    public String getBoardStateStr();
}