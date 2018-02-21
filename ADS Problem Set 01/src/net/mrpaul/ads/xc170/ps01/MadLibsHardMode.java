package net.mrpaul.ads.xc170.ps01;

/**            <-----------note the extra star
 *Mad Lib program
 *
 *This program does a Napoleon History Mad Lib
 *<p>
 *Accel PS01: Mad Libs
 *Date
 *
 *
 *@author Sujay Swain
 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Summary fragment: <5 words on this method's purpose
 * A description of what this method does, organized using HTML tags like <p>
 * Creates a Mad Lib
 * Randomizes the Mad Lib
 * Separate paragraphs using <p> and </p> (put text inside those tags)
 */

public class MadLibsHardMode {
    public static void main(String[] args) {
        //Initialize variables and randomize lists
        int[] randomizeMain = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};//End of list
        Integer[] useArray = Arrays.stream(randomizeMain).boxed().toArray(Integer[]::new);
        Collections.shuffle(Arrays.asList(useArray));
        String[] inputValues = {"","","","","","","","","","","","","","","",""};//End of list
        String[] inputTypes = {"Adjective","Adjective","Adjective","Adjective","Adjective","An Italian Word","City","Noun","Noun","Noun","Occupation","Past Tense Verb","Plural Noun","Plural Noun","Plural Noun","Plural Noun"};//End of list
        int x = 0;
        Scanner valGet = new Scanner(System.in);
        int callVar;

        //Shuffle through inputs
        for (x=0; useArray.length > x; x++) {
            callVar = useArray[x];
            System.out.print("Enter a " + inputTypes[callVar] + ":");
            inputValues[useArray[x]] = valGet.nextLine();
        }//End of for loop
        System.out.println(Arrays.toString(inputValues));

        //Prints out Mad Lib
        System.out.println("Although he was Emperor of France, Napoleon Bonaparte was actually\n" +
                "a Corsican, born on a small " + inputValues[0] + " in the Mediterranean\n" +
                "Sea. When he was just ten years old, Napoleon was sent to a military\n" +
                inputValues[1] + " in France, where his " + inputValues[2] + "stature\n" +
                "earned him the nickname of \"The " + inputValues[3] + " Corporal.\" At 24,\n" +
                "he was made an " + inputValues[4] + " General and married Josephine,\n" +
                "the daughter of a well-known Parisian " + inputValues[5] + ". Soon after\n" +
                "that, he defeated the Italians at " + inputValues[6] + " and in 1804 was\n" +
                "proclaimed Emperor of all the " + inputValues[7] + " But he made\n" +
                "an " + inputValues[8] + " mistake and attacked Russia. He reached Moscow, but\n" +
                "the " + inputValues[9] + " had burned all their " + inputValues[10] + " and his men\n" +
                "got frozen " + inputValues[11] + ". In 1914, he was " + inputValues[12] + " and\n" +
                "sent to Elba. But a year later, he came back to France and for 100 days\n" +
                "was again the " + inputValues[13] + ". However, he was defeated at Waterloo\n" +
                "and imprisoned on the island of St. Helena, an " + inputValues[14] + " place\n" +
                "which resembled " + inputValues[15] + ".");

    }//End of main()
}//End of MadLibsHardMode()
