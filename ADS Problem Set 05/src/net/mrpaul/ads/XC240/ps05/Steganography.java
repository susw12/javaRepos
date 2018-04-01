package net.mrpaul.ads.csid.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;

/**
 * 
 * @author 
 *
 */
public class Steganography {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		//example calls:
		
		/* generate black and white
		 * manually save the file you create in this method as original_message_bw.png
		 * make sure you save it in your project working directory
		 */
		//generateBW("original_message.png");
		
		
		
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
		
	}//end of decode
	
	/**
	 * 
	 * @param fileName
	 */
	public static void generateBW(String fileName){
		
	}//end of generateBW
	
	/**
	 * 
	 * @param fileName
	 */
	public static void shaveImage(String fileName){
		
	}//end of shaveImage
	
	/**
	 * 
	 * @param fileName
	 */
	public static void encode(String fileName){
		
	}//end of encode

}//end of class Steganography
