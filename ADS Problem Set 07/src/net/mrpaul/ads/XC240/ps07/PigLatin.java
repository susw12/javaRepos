package net.mrpaul.ads.XC240.ps07;

import java.util.ArrayList;

public class PigLatin {
    private static char[] vowels = new char[21];
    static char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};

    public static void main(String[] args) {
        startOfFirstConsonantCluster("ADSA");
        System.out.println("SECOND");
        startOfFirstConsonantCluster("lajskfd");

    }

    public static boolean yConso(String string1) {
        string1.toLowerCase();
        //Checks to see if y is a vowel
        boolean yConso = false;
        for (int x = 0; x < string1.length(); x++) {
            if (string1.charAt(x) == ('a')) {
                yConso = true;
            } else if (string1.charAt(x) == 'e') {
                yConso = true;
            } else if (string1.charAt(x) == 'i') {
                yConso = true;
            } else if (string1.charAt(x) == 'o') {
                yConso = true;
            } else if (string1.charAt(x) == 'u') {
                yConso = true;
            } else {
                yConso = false;
            }
        }

        return yConso;

    }

    public static int startOfFirstConsonantClusterMethod(String string1) {

        boolean yConso = yConso(string1);
        string1.toLowerCase();
        boolean returned = false;
        //Checks for vowels
        for (int x = 0; x < string1.length(); x++) {
            if (yConso) {
                if (string1.charAt(x) == 'y') {
                    return (x);
                    returned = true;
                    break;
                }
            } else {
                for (int n = 0; true; n++) {
                    if ((consonants[x]) == (string1.charAt(x))) {
                        return (x);
                        returned = true;
                        break;
                    }
                }
            }
            if (!returned) {
                System.out.println(-1);
            }
        }
    }

    public static int endOfFirstConsonantClusterMethod(String string1) {
        boolean yConso = yConso(string1);
        boolean returned = false;
        string1.toLowerCase();
        for (int x = string1.length(); x >= 0; x--) {
            if (yConso) {
                if (string1.charAt(x) == 'y') {
                    System.out.println(x);
                    returned = true;
                    break;
                }
            } else {
                for (int n = 0; true; n++) {
                    if ((consonants[x]) == (string1.charAt(x))) {
                        System.out.println(x);
                        returned = true;
                        break;
                    }
                }
            }
            if (!returned) {
                System.out.println(-1);
            }
        }
    }
}