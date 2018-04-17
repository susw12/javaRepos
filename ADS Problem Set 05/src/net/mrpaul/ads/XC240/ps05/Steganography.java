package net.mrpaul.ads.XC240.ps05;

import images.APImage;			//Note: We need to import from the images package!
import images.Pixel;			//Note: We need to import from the images package!
import java.util.Scanner;

/**
 * A steganography tool
 *
 * <p>A steganography tool that encodings files by taking the black and white image and then shaving of pixels on the implant image. <br>
 * It then combines the two by adding 1 or 0 based of whether or not the color of the photo is black or white.</p>
 * <p>A steganography tools that also decodes files by looking to see if there is a 1 or a 0 at the end of each pixel.</p>
 * ADS PS05: Foul Play
 * 4/3/18
 *
 * @author Sujay Swain
 *
 */
public class Steganography {
    public static Scanner reader = new Scanner(System.in);

	/**
	 * Calls the main functions
     *
     * <p>Calls all of the encoding functions and then decodes the final encoded file</p>
	 * @param args
	 */
	public static void main(String[] args) {
		//example calls:
		
		/* generate black and white
		 * manually save the file you create in this method as original_message_bw.png
		 * make sure you save it in your project working directory
		 */
		generateBW("message");
		
		
		
		/*
		 * shave destination
		 * manually save the file you create in this method as original_destination_shaven.png
		 */
		shaveImage("thing");
		
		
		/*
		 * encode your black and white message into your shaven destination
		 * save the encoded image as destination_encoded.png
		 */
		encode("messageBW", "thing");
		
		
		
		/*
		 * decode your encoded image
		 */
		decode("thingFinal.png");
		


	}//end of main
	
	
	/**
	 * Decodes an image
     *
     * <p>Uses a simple steganography image decryption method to decrypt an image</p>
	 * @param fileName This is the name of the file that is to be decrypted
	 */
	public static void decode(String fileName){
        //Adds .png file ending to the filename and instantiates the image
	    fileName += ".png";
		APImage encodedPic = new APImage(fileName);

		//Begins decoding process
		for (Pixel p : encodedPic) {
		    //converts values to black and white based on the end digit
		    int rPix = p.getRed();
		    if (rPix % 10 == 0) {
		        p.setBlue(255);
		        p.setGreen(255);
		        p.setRed(255);
            }//end of if statement
            else if (rPix % 10 == 1) {
		        p.setRed(0);
		        p.setGreen(0);
		        p.setBlue(0);
            }//end of else if statement
            else {
                System.out.println("Failed");
            }//end of else statement
		}//end of for loop
        //Displays the decoded image
        System.out.print("Press enter to decode.");
		reader.nextLine();
		encodedPic.draw();
		//Allows the user to save the file
        System.out.print("Save decoded image? y/n: ");
        String check = reader.next();
        if (check.equals("y")) {
            encodedPic.saveAs();
        }//end of if statement
	}//end of decode

	/**
	 * Converts to black and white
     * <p>Converts an image to black and white by using an approximation method based on the color average</p>
	 * @param fileName This is the name of the file that is to be converted to black and white
	 */
	public static void generateBW(String fileName){
        //Adds .png file ending to the filename and instantiates the image
	    fileName += ".png";
		APImage origImage = new APImage(fileName);

		//Turn the picture into black and white by using an average and round process
		for (Pixel p : origImage) {
		    int rPix = p.getRed();
		    int bPix = p.getBlue();
		    int gPix = p.getGreen();
		    int colorAvg = (gPix + bPix + rPix)/3;
		    if (colorAvg > 127) {
		        p.setBlue(0);
		        p.setRed(0);
		        p.setGreen(0);
            }//end of if statement
            else {
                p.setBlue(255);
                p.setRed(255);
                p.setGreen(255);
            }//end of else statement
        }//end of for loop

        //Displays the image
        System.out.print("Press enter to display black and white image.");
        reader.nextLine();
        origImage.draw();

        //Allows the user to save the image
        System.out.print("Save black and white image? y/n: ");
		String check = reader.next();
		if (check.equals("y")) {
            origImage.saveAs();
        }
	}//end of generateBW
	
	/**
	 * Shaves the pixels' ends
	 * <p>Removes the ones digits of the pixels to allow for the image to allow for the encoding</p>
	 * @param fileName
	 */
	public static void shaveImage(String fileName){
        //Adds .png file ending to the filename and instantiates the image
	    fileName += ".png";
	    APImage beardImg = new APImage(fileName);

	    //Removes the ones digit of every number
	    for (Pixel p : beardImg) {
	        int rPix = p.getRed();
	        rPix -= rPix % 10;
	        p.setRed(rPix);
        }//end of for loop

        //Allows the user to save the image
        System.out.print("Save the shaved image? y/n: ");
        String check = reader.next();
        if (check.equals("y")) {
            beardImg.saveAs();
        }//end of if statement
	}//end of shaveImage
	
	/**
	 * Encoding the file
     * <p>Encodes the file combining the message in black and white with the destination image</p>
     *
	 * @param messageFileName The file containing the black and white image
     * @param destinationFileName The file in which the black and white image will be saved
	 */
	public static void encode(String messageFileName, String destinationFileName){
        //Adds .png file ending to the filenames and instantiates the images
	    messageFileName += ".png";
	    destinationFileName += ".png";
		APImage messImg = new APImage(messageFileName);
		APImage finalImg = new APImage(destinationFileName);

		//Gets the height and width of the message file and displays the final image
		int width = messImg.getWidth();
		int height = messImg.getHeight();
        finalImg.draw();

        //Allows the user to press enter to begin encoding
        System.out.print("Begin encoding? ");
        reader.nextLine();

        //Begins the encoding process pixel by pixel
        for (int xAll = 0; xAll < width; xAll++) {
            for (int yAll = 0; yAll < height; yAll++) {
                Pixel pMes = messImg.getPixel(xAll, yAll);
                Pixel pFin = finalImg.getPixel(xAll, yAll);

                int mesNum = pMes.getRed();

                if (mesNum == 255) {
                    pFin.setRed(pFin.getRed() + 1);
                }//end of if statement
            }//end of for loop
        }//end of another for loop

        //Displays the image and allows the user to save it
        finalImg.draw();
        System.out.print("Save encoded image?  y/n: ");
        String check = reader.next();
        if (check.equals("y")) {
            finalImg.saveAs();
        }///end of if statement
	}//end of encode

}//end of class Steganography
