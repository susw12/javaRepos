package net.mrpaul.ads.XC240.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;

/**
 * 
 * @author 
 *
 */
public class Steganography {
    public static Scanner reader = new Scanner(System.in);

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
	    decode("flowersencoded");
		//example calls:
		
		/* generate black and white
		 * manually save the file you create in this method as original_message_bw.png
		 * make sure you save it in your project working directory
		 */
		generateBW("doge");
		
		
		
		/*
		 * shave destination
		 * manually save the file you create in this method as original_destination_shaven.png
		 */
		//shaveImage("original_destination.png");
		
		
		/*
		 * encode your black and white message into your shaven destination
		 * save the encoded image as destination_encoded.png
		 */
		//encode("original_message_bw.png", "original_destination_shaven.png");
		
		
		
		/*
		 * decode your encoded image
		 */
		//decode("destination_encoded.png");
		


	}//end of main
	
	
	/**
	 * 
	 * @param fileName
	 */
	public static void decode(String fileName){
	    fileName += ".png";
		APImage encodedPic = new APImage(fileName);
		for (Pixel p : encodedPic) {
		    int rPix = p.getRed();
		    if (rPix % 10 == 0) {
		        p.setBlue(255);
		        p.setGreen(255);
		        p.setRed(255);
            }
            else if (rPix % 10 == 1) {
		        p.setRed(0);
		        p.setGreen(0);
		        p.setBlue(0);
            }
            else {
                System.out.println("Failed");
            }
		}
        System.out.print("Press enter to decode.");
		reader.nextLine();
		encodedPic.draw();
        System.out.print("Save decoded image? y/n: ");
        String check = reader.next();
        if (check.equals("y")) {
            encodedPic.saveAs();
        }
	}//end of decode

	/**
	 * 
	 * @param fileName
	 */
	public static void generateBW(String fileName){
	    fileName += ".png";
		APImage origImage = new APImage(fileName);
		for (Pixel p : origImage) {
		    int rPix = p.getRed();
		    int bPix = p.getBlue();
		    int gPix = p.getGreen();
		    int colorAvg = (gPix + bPix + rPix)/3;
		    if (colorAvg > 127) {
		        p.setBlue(0);
		        p.setRed(0);
		        p.setGreen(0);
            }
            else {
                p.setBlue(255);
                p.setRed(255);
                p.setGreen(255);
            }
        }
        System.out.print("Press enter to display black and white image.");
        reader.nextLine();
        origImage.draw();
        System.out.print("Save black and white image? y/n: ");
		String check = reader.next();
		if (check.equals("y")) {
            origImage.saveAs();
        }
	}//end of generateBW
	
	/**
	 *
	 *
	 * @param fileName
	 */
	public static void shaveImage(String fileName){
	    fileName += ".png";
	    APImage beardImg = new APImage(fileName);

	    for (Pixel p : beardImg) {
	        int rPix = p.getRed();
	        rPix -= rPix % 10;
	        p.setRed(rPix);
        }
        System.out.print("Save the shaven image? y/n: ");
        String check = reader.next();
        if (check.equals("y")) {
            beardImg.saveAs();
        }
	}//end of shaveImage
	
	/**
	 * 
	 * @param fileName1
     * @param fileName2
	 */
	public static void encode(String fileName1, String fileName2){
	    fileName1 += ".png";
	    fileName2 += ".png";
		APImage origImg = new APImage(fileName1);
		APImage finalImg = new APImage(fileName2);



	}//end of encode

}//end of class Steganography
