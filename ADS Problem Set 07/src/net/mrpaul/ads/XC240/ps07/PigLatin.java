package net.mrpaul.ads.XC240.ps07;

import java.io.*;
import java.util.*;

/**
 *
 */
public class PigLatin {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Auto-generated method stub
        //fileToPigLatin("text_to_latin.txt");
    }
    public static int startOfFirstConsonantCluster(String s) {
        int length = s.length();
        int index = length+2;
        s = s.toLowerCase();

        for(int i = 0; i < length; i++) {
            try
            {
                // checking valid integer using parseInt() method
                Integer.parseInt(s);
                break;
            }
            catch (NumberFormatException e)
            {
                if(s.charAt(i) != 'a'&&s.charAt(i) != 'e'&&s.charAt(i)!='i'&&s.charAt(i)!='o'&&s.charAt(i)!='u') {
                    index = i;
                }
                //if y
                if(s.charAt(i) == 'y') {
                    //if y is first letter
                    if(i == 0 && s.charAt(i) == 'y') {
                        //if 2nd letter is vowel, y is consonant
                        if(s.charAt(i + 1)=='a'||s.charAt(i + 1)=='e'||s.charAt(i + 1)=='i'||s.charAt(i + 1)=='o'||s.charAt(i + 1)=='u') {
                            index = 0;
                        }
                        else if(i > 0 && i < length-1) {
                            //if letter before and after y are NOT consonants, y is consontant
                            if(!(s.charAt(i - 1)!='a'&&s.charAt(i - 1)!='e'&&s.charAt(i - 1)!='i'&&s.charAt(i - 1)!='o'&&s.charAt(i - 1)!='u' &&
                                    s.charAt(i + 1)!='a'&&s.charAt(i + 1)!='e'&&s.charAt(i + 1)!='i'&&s.charAt(i + 1)!='o'&&s.charAt(i + 1)!='u')) {
                                index = i;
                            }
                        }
                    }//end if
                }//end if
                //if index got changed
                if(index != length+2) {
                    break;
                }
            }//end catch

        }//end for
        if(s.equals("") || index == length+2) {
            index = -1;
        }
        //vowel when surrounded by consonants or at end of word
        return index;
    }

    public static int endOfFirstConsonantCluster(String s) {
        int length = s.length();
        int index = length+2;
        boolean counter = false;
        int c = 0;
        s = s.toLowerCase();

        for(int i = 0; i < length; i++) {
            try
            {
                // checking valid integer using parseInt() method
                Integer.parseInt(s);
                break;
            }
            catch (NumberFormatException e)
            {
                //if not vowel
                if(s.charAt(i) != 'a'&&s.charAt(i) != 'e'&&s.charAt(i)!='i'&&s.charAt(i)!='o'&&s.charAt(i)!='u') {
                    //if y
                    if(s.charAt(i) == 'y') {
                        //if y is first letter
                        if(i == 0 && s.charAt(i) == 'y') {
                            //if 2nd letter is vowel, y is consonant
                            if(s.charAt(i + 1)=='a'||s.charAt(i + 1)=='e'||s.charAt(i + 1)=='i'||s.charAt(i + 1)=='o'||s.charAt(i + 1)=='u') {
                                counter = true;
                                index = i;
                                c += 1;
                            }
                        }//end if
                        else if(i > 0 && i < length-1) {
                            //if letter before and after y are NOT consonants, y is consontant
                            if((s.charAt(i - 1)=='a'||s.charAt(i - 1)=='e'||s.charAt(i - 1)=='i'||s.charAt(i - 1)=='o'||s.charAt(i - 1)=='u') ||(
                                    s.charAt(i + 1)=='a'||s.charAt(i + 1)=='e'||s.charAt(i + 1)=='i'||s.charAt(i + 1)=='o'||s.charAt(i + 1)=='u')) {
                                counter = true;
                                index = i;
                                c += 1;
                            }
                            else {
                                counter = false;
                                break;
                            }
                        }//end else if
                    }//end main y if
                    else if(s.charAt(i)!='y') {
                        counter = true;
                        index = i;
                        c += 1;
                    }
                }//end main if
                //if is a vowel
                else {
                    if(c == 0) {
                        counter = true;
                    }
                    else {
                        counter = false;
                        break;
                    }
                }
            }//end catch
        }//end for
        if(s.equals("") || index == length+2) {
            index = -1;
        }
        //vowel when surrounded by consonants or at end of word
        return index;
    }//end endOfFirstConsonantCluster

    public static String wordToPigLatin(String s) {
        String newS, subString;
        int cluster;
        s = s.trim();
        s = s.toLowerCase();
        newS = s;
        int length = s.length();
        char[] vowel = {'a', 'e', 'i', 'o', 'u'};
        char letter = s.charAt(0);

        //if begin with vowel
        if(letter == 'a'||letter=='e'||letter=='i'||letter=='o'||letter=='u'||letter=='A'||
                letter=='E'||letter=='I'||letter=='O'||letter=='U') {
            newS += "way";
        }
        else if((letter == 'Y' || letter=='y') && (s.charAt(1)!='a'&&s.charAt(1)!='e'&&s.charAt(1)!='i'&&s.charAt(1)!='o'&&s.charAt(1)!='u'&&s.charAt(1)!='A'
                &&s.charAt(1)!='E'&&s.charAt(1)!='I'&&s.charAt(1)!='O'&&s.charAt(1)!='U')) {
            newS += "way";
        }

        //if begin with consonant
        else {
            cluster = endOfFirstConsonantCluster(s);
            subString = s.substring(0, cluster+1);
            //remove beginning consonant cluster
            newS = newS.replace(subString, " ");
            newS = newS.trim();
            newS = newS + subString + "ay";
        }
        return newS;
    }//end wordToPigLatin

    public static int findStartOfEndingPuncSeq(String s) {
        s = s.toLowerCase();
        int index = 0;
        String[] letter = {".", "-", "!", "?", ",", ";"};
        int length = s.length();
        for(int i=0; i<length; i++) {
            for(int j=0; j<6; j++) {
                String sub = s.substring(i, i+1);

                if(s.contains(letter[j]) && sub.contains(letter[j])) {
                    index = i;
                    break;
                }
                else {
                    index = -1;
                }
                if(index != -1) {
                    break;
                }
            }
            if(index != -1) {
                break;
            }
        }

        return index;
    }//end findStartOfEndingPuncSeq

    public static void fileToPigLatin(String s) throws FileNotFoundException {
        String x, write;
        Scanner reader = new Scanner (new File (s));
        PrintWriter writer = new PrintWriter(new File("file_PL.txt"));
        while(reader.hasNext()) {
            x = reader.next();
            //if doesn't end in punctuation
            if(findStartOfEndingPuncSeq(x)==-1) {
                write = wordToPigLatin(x);
                write += " ";
                writer.write(write);
            }
            else {
                String sub = x.substring(findStartOfEndingPuncSeq(x));
                if(sub.equals(x)) {
                    write = x + " ";
                    writer.write(write);
                }
                else {
                    x = x.replaceAll(sub, "");
                    write = wordToPigLatin(x);
                    write = write + sub + " ";
                    writer.write(write);
                }
            }
        }
        writer.close();
    }//end fileToPigLatin
}