package net.mrpaul.ads.XC240.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;

/**
 * 
 * @author 
 *
 */
public class Scrambling {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		

	}//end of main
	
		
	
	/**
	 * Unscrambles an image puzzle for ps05: Foul play.
	 * @author 
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
		APImage imageDecode = new APImage(fileName + ".png");
		Scanner reader = new Scanner(System.in);
		System.out.println("Hit enter to unscramble the image.");
		reader.nextLine();
		imageDecode.draw();
		for (Pixel p = 0; p < length(fileName); p++){
			System.out.println();
		}


	}//end of unscramble
	
	
	
	
	/**
	 * Scrambles an image for ps05.
	 * @author 
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

		
		
	}//end of scramble

}
