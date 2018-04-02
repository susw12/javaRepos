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
		System.out.print("Press enter to continue.");
		reader.nextLine();
		doge.draw();

		//Print the width and the height of your APImage object in pixels in the form, "W: # px\tH: # px"
		int width = doge.getWidth();
		int height = doge.getHeight();
		System.out.println("W: " + width + "\tH: " + height);
		System.out.print("Press enter to continue.");
		reader.nextLine();
		
		//Print the R, G, and B values of the Pixel object at (10, 17)
		int x = 10;
		int y = 17;
		Pixel p = doge.getPixel(x, y);
		int r = p.getRed();
		int b = p.getBlue();
		int g = p.getGreen();
		System.out.println("\nPixel at (" + x + ", " + y + "):\tR: " + r + "\tG: " + g + "\tB: " + b + "\n");
		System.out.print("Press enter to continue.");
		reader.nextLine();

		
		//Iterate through each pixel in the image using a regular for loop; print R, G, and B in
		//the form: "Pixel at (<x>, <y>):\tR: #\tG: #\tB: #"
		//example: Pixel at (42, 53):	R: 10	G: 65	B: 157
		//Note that the console output is limited, so if you print enough stuff, the earlier stuff you printed disappears.
		for (int xAll = 0; xAll < width; xAll++) {
			for (int yAll = 0; yAll < height; yAll++) {
				Pixel pAll = doge.getPixel(x, y);
				int rAll = pAll.getRed();
				int bAll = pAll.getBlue();
				int gAll = pAll.getGreen();
				System.out.println("Pixel at (" + xAll + ", " + yAll + "):\tR: " + rAll + "\tG: " + gAll + "\tB: " + bAll);
			}
		}
		System.out.print("Press enter to continue.");
		reader.nextLine();
		
		
		
		//Rewrite your code from the last exercise so it uses an enhanced for loop.  You may omit the indices.
		int xFor = 0;
		int yFor = 0;
		for (Pixel pFor : doge) {
			int rFor = pFor.getRed();
			int bFor = pFor.getBlue();
			int gFor = pFor.getGreen();
			System.out.println("Pixel at (" + xFor + ", " + yFor + "):\tR: " + rFor + "\tG: " + gFor + "\tB: " + bFor);
			if (yFor != 255) {
				yFor++;
			}
			else {
				xFor++;
			}
			System.out.println(xFor + "," + yFor);
		}
		System.out.print("Press enter to continue.");
		reader.nextLine();

		//Set every Pixel in each even column to white and every odd column to black.
		for (int xCol = 0; xCol < width; xCol++) {
			for (int yCol = 0; yCol < height; yCol++) {
				Pixel pCol = doge.getPixel(x, y);
				int rCol;
				int bCol;
				int gCol;
				if (x % 2 == 0) {
					rCol = 255;
					bCol = 255;
					gCol = 255;
				}
				else {
					rCol = 0;
					bCol = 0;
					gCol = 0;
				}
				pCol.setRed(rCol);
				pCol.setBlue(bCol);
				pCol.setGreen(gCol);
			}
		}
		doge.draw();
		
		//Adjust the brightness: multiply each Pixel's values by a constant and constrain values to 255
		
		
	}//end of topicExercises
	

}//end of class FoulPlay
