package net.mrpaul.ads.XC240.ps04;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;



public class Vigenere {
    static Scanner getText = new Scanner(System.in);
    public static void main(String[] args) {
        String argsVar = args[0];
        argsVar.trim();
        List<String> argsList = Arrays.asList(argsVar.split(""));
        System.out.println(argsList);
String decodedText = getText();    }
}