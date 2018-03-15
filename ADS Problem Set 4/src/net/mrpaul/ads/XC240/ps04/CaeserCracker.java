package net.mrpaul.ads.XC240.ps04;
import java.util.Scanner;

public class CaeserCracker {
    static Scanner getText = new Scanner(System.in);
    public static void main(String[] args) {
        String preConvText = getText.nextLine();
        int convertToASCIIValue;
        char convertToString;
        for (int y = 0; y < 26; y++) {
            for (int x = 0; x < preConvText.length(); x++){ 
                if (Character.isUpperCase(preConvText.charAt(x))) {
                    convertToASCIIValue = (int) preConvText.charAt(x);
                    convertToASCIIValue -= 65;
                    convertToASCIIValue = (convertToASCIIValue + (26 - y)) % 26;
                    convertToASCIIValue += 65;
                    convertToString = (char) convertToASCIIValue;
                    char[] preConvTextArray = preConvText.toCharArray();
                    preConvTextArray[x] = convertToString;
                    preConvText = String.valueOf(preConvTextArray);
                }
                else if (Character.isLowerCase(preConvText.charAt(x))) {
                    convertToASCIIValue = (int) preConvText.charAt(x);
                    convertToASCIIValue -= 97;
                    convertToASCIIValue = (convertToASCIIValue + (26 - y)) % 26;
                    convertToASCIIValue += 97;
                    convertToString = (char) convertToASCIIValue;
                    char[] preConvTextArray = preConvText.toCharArray();
                    preConvTextArray[x] = convertToString;
                    preConvText = String.valueOf(preConvTextArray);
                }
                else {
                //Do nothing
                }
            }
            System.out.println(preConvText);
        }
        
    }
}
