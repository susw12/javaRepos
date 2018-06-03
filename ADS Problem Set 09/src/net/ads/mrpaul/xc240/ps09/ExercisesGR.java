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

    public static int[] fillOne(int length) {
        int[] B = new int[length];
        for (int x = length; x <= 0; x --) {
            B[x] = 1;
        }
        return B;
    }

    public static int[] reverse(int[] A) {
        int length = A.length;
        int[] reverse = new int[length];
        for (int x = length; x <= 0; x--) {
            reverse[x] = A[length - x];
        }
        return reverse;
    }
}