package mr.gonzalez.ex05;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Graph centrality, triangles, and clustering exercise
 *
 * <p>Creates a graph from a text file then calculates the degree of centrality, triangles, and clustering with a given vertex.</p>
 *
 *
 * AoA Exercise 05: Friendship Triangles
 * 3/31/2019
 * 
 * @author Sujay Swain
 */
public class FriendshipTriangles extends Application {
	private static int V;
	private static int[][] adj;
	private static int[][] edges;
	private static Vertex[] vertices;

	/**
	 * Graph creator.
	 *
	 * <p>Defines vertices and edges used to create and show a graph.</p>
	 *
	 *
	 * @author Sujay Swain
	 * @param primaryStage
	 */
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
		Graph<Vertex> graph = new UnweightedGraph<>(vertices, edges);

		// Create a scene and place it in the stage
		Scene scene = new Scene(new GraphView(graph), 700, 700);
		primaryStage.setTitle("Friendship Triangles"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage
	}

	/**
	 * Graph vertex.
	 *
	 * <p>Defines a vertex in a graph, containing a name and position.</p>
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
	 *
	 * <p>Reads a text file and defines graph vertices and edges from it.</p>
	 * <p>Creates an adjacency matrix for the edges.</p>
	 *
	 *
	 * @author Sujay Swain
	 * @throws FileNotFoundException
	 */
	public static void readFile() throws FileNotFoundException {
		System.out.print("Enter a text file: ");
		Scanner input = new Scanner(System.in);
		String txt = input.next();
		
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
			vertices[i] = new Vertex(lineSplit[0], (int) Math.round(-300*Math.cos(2*Math.PI*i/V))+350, (int) Math.round(-300*Math.sin(2*Math.PI*i/V)+350));
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
	 * Degree of centrality calculator
	 *
	 * <p>Determines the degree of centrality of a given vertex.</p>
	 *
	 *
	 * @author Sujay Swain
	 * @param v
	 * @return degree of centrality
	 */
	public static double degreeOfCentrality(int v) {
		int count = 0;
		for (int i = 0; i < V; i++) {
			if (adj[v][i] == 1) {
				count++;
			}
		}
		double returnVal = ((double) count) / ((double) (V - 1));
		return returnVal;
	}
	
	/**
	 * Triangle finder
	 *
	 * <p>Finds the number of triangles containing a given vertex</p>
	 *
	 *
	 * @author Sujay Swain
	 * @param v
	 * @return the number of triangles
	 */
	public static int numTriangles(int v) {
		int count = 0;
		for (int i = 0; i < adj[v].length; i++) {
			if (adj[v][i] == 1) { 
				for (int j = 0; j < V; j++) {
					if (adj[i][j] == 1 && adj[j][v] == 1) { 
						count++;
					}
				}
			}
		}
		int returnInt = count / 2;
		return returnInt;
	}
	
	/**
	 * Clustering calculator
	 *
	 * <p>Determines the clustering of a given vertex.</p>
	 *
	 *
	 * @author Sujay Swain
	 * @param t
	 * @return the clustering
	 */
	public static double clustering(int t) {
		double returnVal = ((double) (2 * t)) / ((double) ((V * (V - 1)) / 2));
		return returnVal;
	}
	
	/**
	 * Graph degree of centrality, triangles, and clustering.
	 *
	 * <p>Creates a graph from a text file and calculates the degree of centrality, triangles, and clustering with a given vertex.</p>
	 *
	 *
	 * @author Sujay Swain
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		readFile();
		
		System.out.print("Enter a vertex (0–" + (V-1) + "): ");
		Scanner reader = new Scanner(System.in);
		int v = Integer.parseInt(reader.next());
		reader.close();
		
		System.out.println();
		System.out.println("Normalized degree of centrality: " + ((double) Math.round(degreeOfCentrality(v)*10000)) / 10000);
		int numTriangles = numTriangles(v);
		System.out.println("Number of triangles: " + numTriangles);
		System.out.println("Clustering: " + ((double) Math.round(clustering(numTriangles)*100*100)/100) + "%");
		
		launch(args);
	}

}
