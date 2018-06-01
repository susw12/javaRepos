package net.mrpaul.ads.XC240.ps04;
import java.util.Scanner;

/**
*A simple Caeser encoder
*
*A simple Caeser encoder using CLI inputs
*<p>
*ADS PS04: Crypto
*3/14/18
* 
*
*@author Sujay Swain
*/

public class Caeser {
    static Scanner getText = new Scanner(System.in); //defining scanner as a global
    /**
    * Summary fragment: Simple Caeser encoder
    * A very quick Caeser encoder in Java
    * @author Sujay Swain
    * @param args user enter adn a single integer CLI input
    * @return final values for encode entry
    */
    public static void main(String[] args) {
        //getting cli inputs and intitating vars
        int keyShift = Integer.parseInt(args[0]);
        int keyShiftFinal = keyShift % 26;
        String preConvText = getText.nextLine();
        int convertToASCIIValue;
        char convertToString;
        //checks for uppcase
        for (int x = 0; x < preConvText.length(); x++){ 
            if (Character.isUpperCase(preConvText.charAt(x))) {
                convertToASCIIValue = (int) preConvText.charAt(x);
                convertToASCIIValue -= 65;
                convertToASCIIValue = (convertToASCIIValue + keyShift) % 26;
                convertToASCIIValue += 65;
                convertToString = (char) convertToASCIIValue;
                char[] preConvTextArray = preConvText.toCharArray();
                preConvTextArray[x] = convertToString;
                preConvText = String.valueOf(preConvTextArray);
            }//end of if
            //checks for lowercase
            else if (Character.isLowerCase(preConvText.charAt(x))) {
                convertToASCIIValue = (int) preConvText.charAt(x);
                convertToASCIIValue -= 97;
                convertToASCIIValue = (convertToASCIIValue + keyShift) % 26;
                convertToASCIIValue += 97;
                convertToString = (char) convertToASCIIValue;
                char[] preConvTextArray = preConvText.toCharArray();
                preConvTextArray[x] = convertToString;
                preConvText = String.valueOf(preConvTextArray);
            }//end of else if
            //checks for everything else
            else {
            //Do nothing
            }//end of else
        }
        System.out.println(preConvText);

    }//end of main
}//end of Caeser
