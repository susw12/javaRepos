package mr.gonzalez.aoaexercise03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Graph connection and cycles
 * <p>Tests if a graph is connected and cyclic.</p>
 * <p>Finds a cycle through each vertex and displays the graph with one cycle.</p>
 *
 * AoA Exercise 04 - Graph Traversal
 *
 * @author Sujay Swain
 */
public class Exercise04 extends Application {
    private static String txt;
    private static int V;
    private static int[][] adj;
    private static int[][] edges;
    private static Vertex[] vertices;
    private static String cycle;
    private static int[][] cycleEdges;

    /**
     * Graph connection and cycles.
     * <p>Tests if a graph, obtained from a text file, is connected and cyclic.</p>
     * <p>Finds a cycle through each vertex and displays the graph with one cycle.</p>
     *
     * @author Sujay Swain
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        readFile();
        System.out.print("The graph is ");
        if (!isConnected()) {
            System.out.print("not ");
        }
        System.out.println("connected.");

        System.out.print("The graph is ");
        if (!isCyclic()) {
            System.out.print("not ");
        }
        System.out.println("cyclic.\n");

        findCycles();

        launch(args);
    }

    @Override // Override the start method in the Application class
    /**
     * Graph creator.
     * <p>Defines vertices and edges used to create a graph, showing one cycle.</p>
     *
     * @author Sujay Swain
     * @param primaryStage
     * @throws FileNotFoundException
     */
    public void start(Stage primaryStage) throws FileNotFoundException {
        Vertex[] vertices;
        int[][] edges;
        File info = new File(txt);
        Scanner fileRead = new Scanner(info);
        int total = Integer.parseInt(fileRead.nextLine());
        vertices = new Vertex[total];
        edges = new int[total*total][2];
        int counter = 0;
        int pos = 0;
        while (fileRead.hasNextLine()) {
            String parseStr = fileRead.nextLine();
            String[] parsedArr = parseStr.split(" ", 0);
            vertices[pos] = new Vertex(parsedArr[0], Integer.parseInt(parsedArr[1]), Integer.parseInt(parsedArr[2]));
            pos++;
            for (int x = 3 ; x < parsedArr.length; x++) {
                edges[counter][0] = pos - 1;
                edges[counter][1] = Integer.parseInt(parsedArr[x]);
                counter++;
            }

        }
        //Create the Graph data structure, with a constructor call including your edges and vertices
        Graph<Vertex> graph = new UnweightedGraph<>(vertices, edges);
        // Create a scene and place it in the stage
        Scene scene = new Scene(new GraphView(graph), 750, 450);
        primaryStage.setTitle("Hello!"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Graph vertex.
     * <p>Defines a vertex in a graph, containing a name and position.</p>
     *
     * AoA Exercise 04 - Graph Traversal
     *
     * @author Sujay Swain
     */
    static class Vertex implements Displayable {
        private int x, y;
        private String name;

        Vertex(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }

        @Override
        public int getX() {
            return x;
        }

        @Override
        public int getY() {
            return y;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    /**
     * Graph from input.
     * <p>Reads a text file and defines graph vertices and edges from it.</p>
     * <p>Creates an adjacency matrix for the edges.</p>
     *
     * @author Sujay Swain
     * @throws FileNotFoundException
     */
    public static void readFile() throws FileNotFoundException {
        System.out.print("Enter a text file: ");
        Scanner input = new Scanner(System.in);
        txt = input.next();
        input.close();

        Scanner reader = new Scanner(new File(txt));
        V = Integer.parseInt(reader.nextLine());
        vertices = new Vertex[V];

        adj = new int[V][V];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                adj[i][j] = 0;
            }
        }

        for (int i = 0; i < V; i++) {
            String line = reader.nextLine();
            String[] lineSplit = line.split(" ");
            for (int j = 3; j < lineSplit.length; j++) {
                adj[Integer.parseInt(lineSplit[0])][Integer.parseInt(lineSplit[j])] = 1;
            }
            vertices[i] = new Vertex(lineSplit[0], Integer.parseInt(lineSplit[1]), Integer.parseInt(lineSplit[2]));
        }
        reader.close();

        int count = 0;
        edges = new int[V*(V-1)][2];
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if(adj[i][j] == 1) {
                    edges[count][0] = i;
                    edges[count][1] = j;
                    count++;
                }
            }
        }
    }

    /**
     * DFS recursion.
     * <p>Performs a DFS by visiting adjacent vertices using recursion.</p>
     *
     * @author Sujay Swain
     * @param v
     */
    public static void DFSUtil(int v, boolean visited[]) {
        visited[v] = true;
        int i = 0;
        while (i < V) {
            int n = adj[v][i];
            if (n == 1 && !visited[i]) {
                DFSUtil(i, visited);
            }
            i++;
        }
    }

    /**
     * Depth First Search
     * <p>Performs a depth first search starting at a given vertex.</p>
     *
     * @author Sujay Swain
     * @param v
     */
    public static void DFS(int v, boolean visited[]) {
        DFSUtil(v, visited);
    }

    /**
     * Graph connection tester.
     * <p>Determines if a graph is connected using DFS.</p>
     *
     * @author Sujay Swain
     * @return boolean
     */
    public static boolean isConnected() {
        boolean[] visited = new boolean[V];
        DFS(0, visited);
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * DFS vertex cyclic recursion.
     * <p>Detects cycles by performing a DFS starting at a given vertex, visiting adjacent vertices using recursion.</p>
     *
     * @author Sujay Swain
     * @param v
     * @param parent
     * @param first
     * @return boolean
     */
    public static boolean isCyclicUtil(int v, boolean visited[], int parent, int first) {
        visited[v] = true;
        int i = 0;
        while (i < V) {
            int n = adj[v][i];
            if (n == 1 && !visited[i]) {
                cycle += (" " + v);
                if (isCyclicUtil(i, visited, v, first)) {
                    return true;
                }
            } else if (n == 1 && i != parent && i == first) {
                cycle += (" " + v);
                return true;
            }
            i++;
        }
        return false;
    }

    /**
     * Graph cyclic tester.
     * <p>Determines if a graph is cyclic using DFS.</p>
     *
     * @author Sujay Swain
     * @return boolean
     */
    public static boolean isCyclic() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicUtil(i, visited, -1, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Graph cycle finder.
     * <p>Finds and prints out one cycle going through each vertex in the graph.</p>
     *
     * @author Sujay Swain
     * @return void
     */
    public static void findCycles() {
        boolean[] visited = new boolean[V];
        cycle = "";
        boolean printed = false;
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, -1, i)) {
                cycle = cycle.substring(1,cycle.length());
                if (!printed) {
                    cycleEdges = new int[V][2];
                    String[] c = cycle.split(" ");
                    int j;
                    for (j = 0; j < c.length-1; j++) {
                        cycleEdges[j][0] = Integer.parseInt(c[j]);
                        cycleEdges[j][1] = Integer.parseInt(c[j+1]);
                    }
                    cycleEdges[j][0] = Integer.parseInt(c[j]);
                    cycleEdges[j][1] = Integer.parseInt(c[0]);
                    printed = true;
                }
            }
            for (int j = 0; j < V; j++) {
                visited[j] = false;
            }
            cycle = "";
        }
        if (!printed) {
            cycleEdges = new int[0][2];
        }
    }
}
