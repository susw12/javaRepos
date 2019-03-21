package mr.gonzalez.ex03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A visual graph maker
 *
 * <p>Creates a visual representation of a graph using JavaFX</p>
 * <p>Uses a couple of custom modules to make this possible</p>
 * <p>The graph pops up in a different screen</p>
 * <p>The information is read form a text file</p>
 *
 * @author Sujay Swain
 * AoA Exercise 3: Graph Representation Project
 */
@SuppressWarnings("ALL")
public class MyGraph2 extends Application {
    @Override // Override the start method in the Application class
    /**
     * Creates and makes a graph
     * <p>Using a similar structure to the example, this generates a graph from a give set of points</p>
     * <p>The points are provided in a text file</p>
     *
     * @parameters primaryStage
     * @author Sujay Swain
     */
    public void start(Stage primaryStage) throws FileNotFoundException {
        //Create your edges and vertices here
        GraphPoint[] vertices;
        int[][] edges;
        File info = new File("MyGraph2.txt");
        Scanner fileRead = new Scanner(info);
        int total = Integer.parseInt(fileRead.nextLine());
        vertices = new GraphPoint[total];
        edges = new int[total*total][2];
        int counter = 0;
        int pos = 0;
        while (fileRead.hasNextLine()) {
            String parseStr = fileRead.nextLine();
            String[] parsedArr = parseStr.split(" ", 0);
            vertices[pos] = new GraphPoint(parsedArr[0], Integer.parseInt(parsedArr[1]), Integer.parseInt(parsedArr[2]));
            pos++;
            for (int x = 3 ; x < parsedArr.length; x++) {
                edges[counter][0] = pos - 1;
                edges[counter][1] = Integer.parseInt(parsedArr[x]);
                counter++;
            }

        }
        System.out.println(Arrays.toString(vertices));
        System.out.println(Arrays.deepToString(edges));
        //Create the Graph data structure, with a constructor call including your edges and vertices
        Graph<GraphPoint> graph = new UnweightedGraph<>(vertices, edges);
        // Create a scene and place it in the stage
        Scene scene = new Scene(new GraphView(graph), 750, 450);
        primaryStage.setTitle("Hello!"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Simple point addresser
     * <p>Allows for the creation of a node in a graph</p>
     *
     * @author Sujay Swain
     */
    static class GraphPoint implements Displayable {
        private int x, y;
        private String name;

        GraphPoint(String name, int x, int y) {
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

        public String toString() {
            return name + ": (" + x + ", " + y + ")";
        }
    }



    /**
     * The main method is only needed for the IDE with limited
     * JavaFX support. Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);

    }
}
