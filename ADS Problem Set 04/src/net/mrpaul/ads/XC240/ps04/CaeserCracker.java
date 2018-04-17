package net.mrpaul.ads.XC240.ps04;
import java.util.Scanner;

/**
*A simple Caeser Decoder
*
*A simple Caeser Decodering use a brute force method
*<p>
*ADS PS04: Crypto
*3/14/18
* 
*
*@author Sujay Swain
*/

public class CaeserCracker {
    static Scanner getText = new Scanner(System.in); //defining scanner as a global
    /**
    * Summary fragment: Brute force Caeser cracker
    * A very brute force merthod to crack a Caeser encrypted code
    * @author Sujay Swain
    * @param args user enter
    * @return final values for all possible
    */
    public static void main(String[] args) {
        //gets all the vars
        String preConvText = getText.nextLine();
        int convertToASCIIValue;
        char convertToString;
        //starts for all keyys
        for (int y = 0; y < 26; y++) {
            //for loop for each key
            for (int x = 0; x < preConvText.length(); x++){
                //Uppercase check and conversion 
                if (Character.isUpperCase(preConvText.charAt(x))) {
                    convertToASCIIValue = (int) preConvText.charAt(x);
                    convertToASCIIValue -= 65;
                    convertToASCIIValue = (convertToASCIIValue + (26 - y)) % 26;
                    convertToASCIIValue += 65;
                    convertToString = (char) convertToASCIIValue;
                    char[] preConvTextArray = preConvText.toCharArray();
                    preConvTextArray[x] = convertToString;
                    preConvText = String.valueOf(preConvTextArray);
                }//end of if
                //Lowercase check and conversion
                else if (Character.isLowerCase(preConvText.charAt(x))) {
                    convertToASCIIValue = (int) preConvText.charAt(x);
                    convertToASCIIValue -= 97;
                    convertToASCIIValue = (convertToASCIIValue + (26 - y)) % 26;
                    convertToASCIIValue += 97;
                    convertToString = (char) convertToASCIIValue;
                    char[] preConvTextArray = preConvText.toCharArray();
                    preConvTextArray[x] = convertToString;
                    preConvText = String.valueOf(preConvTextArray);
                }//end of else if
                else {
                //Do nothing
                }//end of else
            }//end of for
            //print out final output
            System.out.println(preConvText);
        }//end of for loop (main one)  
    }//end of class
}//end of CaeserCracker
