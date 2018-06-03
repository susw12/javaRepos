package net.ads.mrpaul.xc240.ps09;

/**
 * The array exercises
 *
 * <p>Three different array assignments</p>
 * ADS PS09: Greedy redux + eBay
 * 6/2/18
 *
 * @author Sujay Swain
 */

public class ExercisesGR {
    public static void main(String[] arg) {
        //IntelliJ requires this
    }

    /**
     * Creates one's array
     *
     * <p>Creates an array of a given length, filled to the brim (literally) with ones.</p>
     *
     * @param length Array's length
     * @return The array filled with ones
     */
    public static int[] fillOne(int length) {
        int[] a = new int[length];
        for (int i = 0; i < a.length; i++) {
            a[i] = 1;
        }
        return a;
    }

    /**
     * Reverses an array
     *
     * <p>Returns the reverse of a given array</p>
     *
     * @param a Array to be reversed
     * @return Reversed array
     */
    public static int[] reverse(int[] a) {
        int[] reverse = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            reverse[a.length - i - 1] = a[i];
        }
        return reverse;
    }


    /**
     * Inserts a number every 3 positions
     *
     * <p>Inserts a given integer every 3 elements in the array</p>
     *
     * @param a The array to insert i into
     * @param i The integer to insert
     * @return The new array with inserted number
     */
    public static int[] insertBetweenTriads(int[] a, int i) {
        int newLength = a.length * 4 / 3 + 1;
        int[] changedArray = new int[newLength];
        int counter = 0;
        for (int x = 0; x <= a.length; x++) {
            if (x % 3 == 0) {
                changedArray[x + counter] = i;
                counter++;
            }
            if (x < a.length) {
                changedArray[x + counter] = a[x];
            }
        }

        return changedArray;
    }
}