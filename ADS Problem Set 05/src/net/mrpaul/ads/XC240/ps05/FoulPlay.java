package net.mrpaul.ads.XC240.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;
import net.mrpaul.ads.XC240.ps05.Scrambling;
import net.mrpaul.ads.XC240.ps05.Steganography;


/**
 * Exercises and calling final actions
 *
 * <p>This program contains all of the exercises</p>
 * <p>It also calls the functions from Scrambling.java and Steganography.java to solve the mystery</p>
 * ADS PS05: Foul Play
 * 4/3/18
 *
 *
 * @author Sujay Swain
 *
 */

public class FoulPlay {
	/**
	 * Call main functions
     * <p>Calls the main functions from other programs and also calls the exercises</p>
	 * @param args
	 */
	public static void main(String[] args) {
		/* 
		 * The reason we can call topicExercses() like this without an object
		 * or a class name is that it is a static method in the same class as the method call.
		 * If we wanted to call topicExercises() from a different class, we'd have to write
		 * FoulPlay.topicExercises();
		 */
		Scrambling.unscramble("ps05 encoded");
		Steganography.decode("thingFinal");
		topicExercises();


	}//end of main
	
	
	/**
	 * The topic exercises
     *
     * <p>This contains the main </p>
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
		for (int xAll = 0; xAll <= width; xAll++) {
			for (int yAll = 0; yAll <= height; yAll++) {
				Pixel pAll = doge.getPixel(x, y);
				int rAll = pAll.getRed();
				int bAll = pAll.getBlue();
				int gAll = pAll.getGreen();
				System.out.println("Pixel at (" + xAll + ", " + yAll + "):\tR: " + rAll + "\tG: " + gAll + "\tB: " + bAll);
			}//end of a for loop
		}//end of another for loop
		System.out.print("Press enter to continue.");
		reader.nextLine();
		
		
		
		//Rewrite your code from the last exercise so it uses an enhanced for loop.  You may omit the indices.
		for (Pixel pFor : doge) {
			int rFor = pFor.getRed();
            int bFor = pFor.getBlue();
            int gFor = pFor.getGreen();
            System.out.println("Pixel:\tR: " + rFor + "\tG: " + gFor + "\tB: " + bFor);
		}//end of for loop
		System.out.print("Press enter to continue.");
		reader.nextLine();

		//Set every Pixel in each even column to white and every odd column to black.
        APImage copy = doge.clone();
        for(int c1 = 0; c1 < width; c1++) {
            for(int c2=0; c2 < height; c2++) {
                if(c1%2==1) {
                    copy.setPixel(c1, c2, new Pixel(0, 0, 0));
                }//end if
                else {
                    copy.setPixel(c1, c2, new Pixel(255, 255, 255));
                }//end else
            }//end nested for loop
        }//end for loop

        System.out.println("Press enter to display new image.");
        reader.nextLine();
        copy.draw();
        copy.save();

		
		//Adjust the brightness: multiply each Pixel's values by a constant and constrain values to 255
		APImage cloning = doge.clone();
		for (Pixel pClone : cloning) {
			int rClone = pClone.getRed();
			int bClone = pClone.getBlue();
			int gClone = pClone.getGreen();
			rClone *= 2;
			bClone *= 2;
			gClone *= 2;

			if (rClone > 255) {
				rClone = 255;
			}//end of if statement
			if (bClone > 255) {
				bClone = 255;
			}//end of if statement
			if (gClone > 255) {
				gClone = 255;
			}//end of if statement

			pClone.setRed(rClone);
			pClone.setBlue(bClone);
			pClone.setGreen(gClone);
		}// end of for loop
		cloning.draw();
		
	}//end of topicExercises
	

}//end of class FoulPlay
