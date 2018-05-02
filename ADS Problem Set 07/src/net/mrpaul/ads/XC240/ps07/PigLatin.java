package net.mrpaul.ads.XC240.ps07;

import java.util.ArrayList;

public class PigLatin {
    static char[] consonants = {'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'z'};
    static char[] vowels = {'a', 'e', 'i', 'o', 'u'};

    public static void main(String[] args) {
        System.out.println(startOfFirstConsonantClusterMethod("ADSA"));

        System.out.println(endOfFirstConsonantClusterMethod("pry"));
    }

    public static boolean yConso(String string1) {
        string1 = string1.toLowerCase();
        //Checks to see if y is a vowel
        boolean yConso = false;
        for (int x = 0; x < string1.length(); x++) {
            if (string1.charAt(x) == ('a')) {
                yConso = true;
                break;
            } else if (string1.charAt(x) == 'e') {
                yConso = true;
                break;
            } else if (string1.charAt(x) == 'i') {
                yConso = true;
                break;
            } else if (string1.charAt(x) == 'o') {
                yConso = true;
                break;
            } else if (string1.charAt(x) == 'u') {
                yConso = true;
                break;
            } else {
                yConso = false;
            }
        }

        return yConso;

    }

    public static int startOfFirstConsonantClusterMethod(String string1) {
        boolean yConso = yConso(string1);
        boolean returned = false;
        int finalValue = 0;
        string1 = string1.toLowerCase();
        for (int x = 0; x < string1.length(); x++) {
            if (!yConso) {
                if (string1.charAt(x) == 'y') {
                    finalValue = x-1;
                    returned = true;
                    break;
                }
            }
            else {
                for (int n = 0; n < consonants.length; n++) {
                    if ((consonants[n]) == (string1.charAt(x))) {
                        finalValue = x-1;
                        returned = true;
                        break;
                    }
                }
            }
            if (returned) {
                break;
            }
        }
        if (!returned) {
            finalValue = -1;
        }
        return finalValue;
    }

    public static int endOfFirstConsonantClusterMethod(String string1) {
        boolean yConso = yConso(string1);
        boolean returned = false;
        int finalValue = 0;
        string1 = string1.toLowerCase();

        for (int x = 0; x < string1.length(); x++) {
            if (!yConso) {
                if (string1.charAt(x) == 'y') {
                    finalValue = x;
                    returned = true;
                    break;
                }
            }
            else {
                for (int n = 0; n < vowels.length; n++) {
                    if ((vowels[n]) == (string1.charAt(x))) {
                        finalValue = x;
                        returned = true;
                        break;
                    }
                }
            }
            if (returned) {
                break;
            }
        }
        if (!returned) {
            finalValue = -1;
        }
        return finalValue;
    }

    public String stringToPiglatin(String word) {
        String english = word;
        String pigLatin = "";
        if (startOfFirstConsonantClusterMethod(english) != 0) {
            pigLatin = english + "way";
        }

        else {
            int removal = startOfFirstConsonantClusterMethod(english);
            pigLatin =
        }




        return pigLatin;
    }
}
