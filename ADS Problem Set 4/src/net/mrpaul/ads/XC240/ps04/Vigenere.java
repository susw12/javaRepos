package net.mrpaul.ads.XC240.ps04;
import java.util.List;
import java.util.Scanner;

import java.util.Arrays;



public class Main {
    static Scanner getText = new Scanner(System.in);
    public static void main(String[] args) {

        String argsVar = args[0];
        argsVar.trim();
        List<String> argsList = Arrays.asList(argsVar.split(""));
        System.out.println(argsList);
        String decodedText = getText.nextLine();
        List<String> decodedTexList = Arrays.asList(decodedText.split(""));
        int x;
        String finalEncode;
        int extraSpaces = 0;
        for (x = 0; x < decodedText.length(); x++) {
            if ((argsVar.charAt(x)) == ' '){
                extraSpaces++;
            }
            else { 
                int gettingInt = (x-extraSpaces) % argsVar.length();
                int charInt = Integer.parseInt(decodedTexList.get(x));
                if (charInt > 95) {
                    charInt -= 96;
                    gettingInt -= 96;
                    charInt = (charInt + gettingInt) % 26;
                    charInt += 96;
                    
                }

                


                
            }
        }
    }
}
