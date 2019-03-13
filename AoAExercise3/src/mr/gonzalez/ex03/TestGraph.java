package mr.gonzalez.ex03;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestGraph extends Application {
	 @Override // Override the start method in the Application class
	  public void start(Stage primaryStage) {
	   //Create your edges and vertices here

	   //Create the Graph data structure, with a constructor call including your edges and vertices
	    // Create a scene and place it in the stage
	    Scene scene = new Scene(new GraphView(graphName), 750, 450);
	    primaryStage.setTitle("SAMPLETITLE"); // Set the stage title
	    primaryStage.setScene(scene); // Place the scene in the stage
	    primaryStage.show(); // Display the stage
	  }
	  
	  
	  
	  /**
	   * The main method is only needed for the IDE with limited
	   * JavaFX support. Not needed for running from the command line.
	   */
	  public static void main(String[] args) {
	    launch(args);
	  }
}
