package net.mrpaul.ads.XC240.ps04;
import java.util.List;
import java.util.Scanner;

/**
*A simple Vigenere encoder
*
*A simple Vigenere encoder using CLI inputs
*<p>
*ADS PS04: Crypto
*3/14/18
* 
*
*@author Sujay Swain
*/

public class Vigenere{
    static Scanner getText = new Scanner(System.in); //defining scanner as a global
    /**
    * Summary fragment: Simple Vigenere encoder
    * A very quick Vigenere encoder in Java
    * @author Sujay Swain
    * @param args user enter adn a single string CLI input
    * @return final values for encode entry
    */
    public static void main(String[] args) {
        if(args.length > 1 || args.length < 1) {
            System.out.println("Only one argument!");
        }//end if
        else {
            //declares variables
            String decodeKey = args[0];
            decodeKey = decodeKey.toLowerCase();
            int placeOnKey = 0, key, keyLength = decodeKey.length();
            System.out.println("What do you want to encrypt?");
            String decodedText = getText.nextLine();
            int positionPlace = decodedText.length();
            String encodedText = "";
            
            //converting char by char with Caeser Cipher
            for (int i=0; i<positionPlace; i++) {
                char changeChar = decodedText.charAt(i);
                if (Character.isAlphabetic(changeChar)) {
                    int ascii = (int) changeChar;
                    key = (int) decodeKey.charAt(placeOnKey);
                    key -= 97;
                    //when lower case
                    if (Character.isLowerCase(changeChar)) {
                        ascii = (key + ascii - 97) % 26 + 97;
                    }//end if
                    //whn upper case
                    else {
                        ascii = (key + ascii - 65) % 26 + 65;
                    }//end else
                    changeChar = (char) ascii;
                    placeOnKey = (placeOnKey + 1) % keyLength;
                }//end if
                encodedText += changeChar;
            }//end for loop
        //Print the text
        System.out.println(encodedText);
        }//end main else statement
    }//end main
}//end Vigenere
