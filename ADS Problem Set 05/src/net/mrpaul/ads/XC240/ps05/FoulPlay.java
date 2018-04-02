package net.mrpaul.ads.XC240.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;


/**
 * 
 * @author 
 *
 */

public class FoulPlay {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		/* 
		 * The reason we can call topicExercses() like this without an object
		 * or a class name is that it is a static method in the same class as the method call.
		 * If we wanted to call topicExercises() from a different class, we'd have to write
		 * FoulPlay.topicExercises();
		 */
		topicExercises();


	}//end of main
	
	
	/**
	 * 
	 */
	public static void topicExercises(){
		//instantiate a new APImage object
		APImage doge = new APImage("doge.png");
		Scanner reader = new Scanner(System.in);

		//Use a Scanner object (and its nextLine() method) to trigger your APImage's draw() method
		reader.nextLine();
		doge.draw();

		//Print the width and the height of your APImage object in pixels in the form, "W: # px\tH: # px"
		int width = doge.getWidth();
		int height = doge.getHeight();
		System.out.println("W: # " + width + "\tH: #  " + height);
		
		//Print the R, G, and B values of the Pixel object at (10, 17)
		Pixel p = doge.getPixel(10, 17);
		int r = p.getRed();
		int b = p.getBlue();
		int g = p.getGreen();

		
		//Iterate through each pixel in the image using a regular for loop; print R, G, and B in
		//the form: "Pixel at (<x>, <y>):\tR: #\tG: #\tB: #"
		//example: Pixel at (42, 53):	R: 10	G: 65	B: 157
		//Note that the console output is limited, so if you print enough stuff, the earlier stuff you printed disappears.
		
		
		
		//Rewrite your code from the last exercise so it uses an enhanced for loop.  You may omit the indices.
		
		
		//Set every Pixel in each even column to white and every odd column to black.
		
		
		//Adjust the brightness: multiply each Pixel's values by a constant and constrain values to 255
		
		
	}//end of topicExercises
	

}//end of class FoulPlay
