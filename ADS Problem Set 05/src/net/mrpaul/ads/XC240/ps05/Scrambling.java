package net.mrpaul.ads.XC240.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;
import java.util.Random;

/**
 * Unscrambles and scrambles photos
 *
 * <p>Unscrambles photos that are mostly blue and green</p>
 * <p>Scrambles photos based on a random blue and green pattern</p>
 * ADS PS05: Foul Play
 * 4/3/18
 *
 *
 * @author Sujay Swain
 *
 */
public class Scrambling {

	/**
	 * Calls main functions
     *
     * Calls all of the functions for a test
	 * @param args
	 */
	public static void main(String[] args) {
	    //calls the scrambling and unscrambling files (these are just test files)
		unscramble("scrambled_DM030_00");
		scramble("asecretmessage_decoded");
		

	}//end of main
	
		
	
	/**
	 * Unscrambles an image puzzle for ps05: Foul play.
	 * @author Sujay Swain
	 * @param fileName a String holding the file name of a .png file in the current working directory.  Example: "scrambled_image.png"
	 * Creates an APImage object out of the file called fileName
	 * <p>Renders the scrambled APImage
	 * <p>Goes through each Pixel in that APImage object and mutes Green and Blue
	 * <p>Pixel values while amplifying red values by a factor of 5.
	 * <p>Then renders the unscrambled (i.e. modified) APImage object
	 * <p>Then prompts the user to save the unscrambled image.
	 * <p>Assumes: valid filename ending in .png that exists in the directory
	 */
	public static void unscramble(String fileName){
        //Adds .png file ending to the filename and instantiates the image
		fileName += ".png";
		APImage imageDecode = new APImage(fileName);
		Scanner reader = new Scanner(System.in);
		System.out.print("Hit enter to unscramble the image.");
		reader.nextLine();

        //Decodes the image by setting the blue and the green to 0, while making the red 5x brighter
		for (Pixel p : imageDecode) {
			p.setGreen(0);
			p.setBlue(0);
			p.setRed(p.getRed()*5);
		}//end of enhanced for loop

        //Displays the new image
		imageDecode.draw();

		//Gives the user the option to either save the file or just exit
		System.out.print("Enter 'y' if you want to save the file or 'n' if you don't want to save the file. ");
		String entry = reader.next();
		if (entry.equals("y")) {
			imageDecode.saveAs();
		}//end of if statement
		else if (entry.equals("n")) {
			System.out.println("Thanks!");
		}//end of else if statement
		else {
			System.out.println("Well then, looks like you didn't do that right.");
		}//end of else statement

		


	}//end of unscramble
	
	
	
	
	/**
	 * Scrambles an image for ps05.
	 * @author Sujay Swain
	 * @param fileName a String holding the file name of a .png file
	 * Creates an APImage object out of the file called fileName
	 * <p>Renders the regular APImage
	 * <p>Goes through each Pixel in that APImage object and randomizes the Green and Blue
	 * <p>Pixel values while diminishing red values by a factor of 10.
	 * <p>Then renders the scrambled (i.e. modified) APImage object
	 * <p>Then prompts the user to save the unscrambled image.
	 * <p>Assumes: valid filename ending in .png that exists in the directory
	 */
	public static void scramble(String fileName){
        //Adds .png file ending to the filename and instantiates the image
		fileName += ".png";
		APImage imageDecode = new APImage(fileName);
		Scanner reader = new Scanner(System.in);
		System.out.print("Hit enter to scramble the image.");
		reader.nextLine();

		//Encodes the file by setting a random value for green and blue while making the red 10x darker
		for (Pixel p : imageDecode) {
		    Random colorVal = new Random();
			p.setGreen(colorVal.nextInt(264));
			p.setBlue(colorVal.nextInt(264));
			p.setRed(p.getRed()/10);
		}//end of enhanced for loop

		//Draws out the image
		imageDecode.draw();

		System.out.print("Enter 'y' if you want to save the file or 'n' if you don't want to save the file. ");
		String entry = reader.next();
		if (entry.equals("y")) {
			imageDecode.saveAs();
		}//end of if statement
		else if (entry.equals("n")) {
			System.out.println("Thanks!");
		}//end of else if statement
		else {
			System.out.println("Well then, looks like you didn't do that right.");
		}//end of else statement
		
		
	}//end of scramble

}
