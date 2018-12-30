package net.mrgonzalez.xc240.exercise3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

/**
 * A set of exercise to test our knowledge for ArrayLists
 *
 * <p>Our teacher, Mr. Gonzalez, has provided parameters to write a few exercises to test our knowledge of ArrayLists in Java.</p>
 * <p>He has also requested us to come up with and code our own "really cool" function</p>
 *
 * ADS Ex03: Exercise 3
 *
 * Date: 10/18/2018
 *
 *
 *
 * @author Sujay Swain
 */

public class ListExercises {

    public static void main(String[] args) {
        //A testing space for functions
    }
    /**
     * <ol>
     *     <li>Read all the integers in the file (one per line) and insert each number directly into an ArrayList pointed to by a List variable.</li>
     *     <li>Once inserted, print the number of numbers in the list.</li>
     *     <li>Then call a method to print the list in a horizontal row using a for-each loop. (If you want to do this in the same method, that's fine.)</li>
     *     <li>Then call a method to traverse the loop again, this time using a for loop, and remove all odd integers from the list. (If you want to do this in the same method, that's fine.)</li>
     *     <li>Once again, print the number of numbers in the list and call a method to print the list in a horizontal row using an iterator.</li>
     *     <li>Lastly, print out only the first and last integers in the list. Label each one.</li>
     * </ol>
     *
     * @param fileName
     *
     * @author Sujay Swain
     */
    public static void navarroExercises(String fileName) {
        Scanner readFile = new Scanner(System.in);
        List<Integer> fileInts = new ArrayList<>();

        while(readFile.hasNextLine()) {
            fileInts.add(Integer.valueOf(readFile.nextLine()));
        }

        System.out.println(fileInts.size());

        for (int lines : fileInts) {
            System.out.print(lines + " ");
        }

        List<Integer> copyFileInts = new ArrayList<>();

        for (int x = 0; x < fileInts.size(); x++) {
            if (fileInts.get(x) % 2 == 0) {
                copyFileInts.add(fileInts.get(x));
            }
        }

        System.out.print("\n Size: " + copyFileInts.size() + "\n");
        for (int lines : copyFileInts) {
            System.out.print(lines + " ");
        }

        System.out.println("\n First: " +  copyFileInts.get(0) + "\n Last: " + copyFileInts.get(copyFileInts.size()-1));
    }

    /**
     * <h1>maxLength()</h1>
     *
     * <p>Takes a List of Strings as a parameter and that returns the length of the longest string in the list.</p>
     * <p>Returns 0 on an empty list</p>
     *
     * @param listString
     * @return longestLength
     *
     * @author Sujay Swain
     */
    public static int maxLength(List<String> listString) {
        int longestLength = 0;
        for (int a = 0; a < listString.size(); a++) {
            if (listString.get(a).length() > longestLength) {
                longestLength = listString.get(a).length();
            }
        }
        return longestLength;
    }

    /**
     * <h1>swapPairs</h1>
     *
     * <p>switches the order of values in a List of Strings (passed via parameter) in a pairwise fashion and returns the result</p>
     *
     * @param original
     * @return original
     *
     * @author Sujay Swain
     */
    public static List<String> swapPairs(List<String> original) {
        for (int x = 0; x < original.size()-1; x+= 2) {
            Collections.swap(original, x, x+1);
        }
        return original;
    }

    /**
     * <h1>removeEvenLength</h1>
     *
     * <p>Takes a List of Strings as a parameter and removes all of the strings of even length from the list.</p>
     *
     * @param list
     * @return list
     *
     * @author Sujay Swain
     */
    public static List<String> removeEvenLength(List<String> list) {
        for (int x = 0; x < list.size(); x++) {
            if (list.get(x).length() % 2 == 0) {
                list.remove(x);
                x--;
            }
        }
        return list;

    }

    /**
     * <h1>doubleList</h1>
     *
     * <p>Takes a List of Strings as a parameter and that replaces every string with two of that string</p>
     *
     * @param original
     * @return finalList
     *
     * @author Sujay Swain
     */
    public static List<String> doubleList(List<String> original) {
        List<String> finalList = new ArrayList<>();
        for (int x = 0; x < original.size(); x++) {
            finalList.add(original.get(x));
            finalList.add(original.get(x));
        }
        return finalList;
    }

    /**
     * <h1>minToFront</h1>
     *
     * <p>Takes a List of ints as a parameter and that moves the minimum value in the list to the front, otherwise preserving the order of the elements</p>
     *
     * @param original
     * @return original
     *
     * @author Sujay Swain
     */
    public static List<Integer> minToFront(List<Integer> original) {
        int min = original.get(original.size()-1);
        for (int x = 1; x < original.size(); x++) {
            if (min > original.get(x)) {
                min = original.get(x);
            }
        }
        for (int x = 0; x < original.size(); x++) {
            if (original.get(x) == min) {
                original.remove(x);
                original.add(0, min);
            }
        }

        return original;
    }

    /**
     * <h1>removeDuplicates</h1>
     *
     * <p>Takes as a parameter a sorted List of Strings and that eliminates any duplicates from the list.</p>
     *
     * @param original
     * @return original
     *
     * @author Sujay Swain
     */
    public static List<String> removeDuplicates(List<String> original) {
        String compare = original.get(0);
        for (int x = 1; x < original.size(); x++) {
            if (original.get(x).equals(compare)) {
                original.remove(x);
                x--;
            }
            else {
                compare = original.get(x);
            }
        }
        return original;
    }

    /**
     * <h1>stutter</h1>
     *
     * <p>Takes a List of Strings and an integer k as parameters and that replaces every string with k copies of that string</p>
     *
     * @param original
     * @param k
     * @return finalList
     *
     * @author Sujay Swain
     */
    public static List<String> stutter(List<String> original, int k) {
        List<String> finalList = new ArrayList<>();
        if (k < 0) {
            original = finalList;
        }
        else {
            for (int x = 0; x < original.size(); x++) {
                for (int y = 0; y < k; y++) {
                    finalList.add(original.get(x));
                }
            }
            original = finalList;
        }
        return finalList;
    }

    /**
     * <h1>markLength4</h1>
     *
     * <p>takes a List of Strings as a parameter and that places a string of four asterisks "$&*#" in front of every string of length 4</p>
     *
     * @param original
     * @return original
     *
     * @author Sujay Swain
     */
    public static List<String> markLength4(List<String> original) {
        for (int x = 0; x < original.size(); x++) {
            if (original.get(x).length() == 4) {
                original.add(x, "$&*#");
                x++;
            }
        }
        return original;
    }

    /**
     * <h1>removeShorterStrings</h1>
     *
     * <p>Takes a List of Strings as a parameter and that removes from each successive pair of values the shorter string in the pair</p>
     *
     * @param original
     * @return finalList
     *
     * @author Sujay Swain
     */
    public static List<String> removeShorterStrings(List<String> original) {
        List<String> finalList = new ArrayList<>();
        boolean checkTest = false;
        for (int x = 0; x < original.size()-1; x += 2) {
            if (original.get(x).length() == original.get(x+1).length()) {
                finalList.add(original.get(x+1));
            }
            else if (original.get(x).length() < original.get(x+1).length()) {
                finalList.add(original.get(x+1));
            }
            else {
                finalList.add(original.get(x));
            }
         }
         if (original.size() % 2 != 0) {
             finalList.add(original.get(original.size()-1));
         }
         return finalList;
    }

    /**
     * <h1>interleave</h1>
     *
     * <p>Accepts two Lists of integers a1 and a2 as parameters and inserts the elements of a2 into a1 at alternating indexes </p>
     * <p>If the lists are of unequal length, the remaining elements of the longer list are left at the end of a1</p>
     *
     * @param a1
     * @param a2
     * @return a2
     *
     * @author Sujay Swain
     */
    public static List<Integer> interleave(List<Integer> a1, List<Integer> a2) {
        for (int x = 0; x < a1.size(); x++)
            a2.add(2*x, a1.get(x));

        return a2;
    }

    /**
     * <h1>closestPerfect</h1>
     *
     * <p>Takes an integer array and states which value is the closest to a perfect square.</p>
     *
     * <p>For example, if the array is [15,78,90,143], the square root of each of these values would be taken then the difference to the near whole number would be calculated and stored in a new array</p>
     * <p>Then, the smallest value would be taken and that would be used to return the number closest to a square.</p>
     * <p>If there is more than one perfect square, then it only provides one (it does not matter which one).</p>
     *
     * <p>Here is a sample JUnit</p>
     * public void testClosestPerfect() {
     *    assertEquals(ListExercises.closestPerfect(l3), 4);
     *    assertEquals(ListExercises.closestPerfect(l4), 1292);
     * }
     *
     * @param a1
     *
     * @author Sujay Swain
     */
    public static int closestPerfect(List<Integer> a1) {
        int closestValIndex = 0;
        double smallestDiff = Math.abs(Math.ceil(Math.sqrt(a1.get(0)))-Math.sqrt(a1.get(0)));
        for (int x = 1; x < a1.size(); x++) {
            double tempDiff = Math.abs(Math.ceil(Math.sqrt(a1.get(x)))-Math.sqrt(a1.get(x)));
            if (tempDiff < smallestDiff) {
                smallestDiff = tempDiff;
                closestValIndex = x;
            }
        }
        return a1.get(closestValIndex);
    }
}
