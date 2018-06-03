package net.ads.mrpaul.xc240.ps09;

/**
 * Fibonacci number generator
 *
 * <p>Generates the fibonacci number both recursively and dynamically and returns the time that it took in nanoseconds</p>
 * ADS PS09: Greedy redux + eBay
 * 6/2/2018
 *
 * @author Sujay Swain
 */

public class Fibonacci {
    /**
     * Runs functions
     *
     * <p>Runs the main method to generate values between 0 and 45 increasing by 5</p>
     * @param args
     */
    public static void main(String[] args) {
        for (int x = 0; x <= 45; x += 5) {
            returnTimeRecursive(x);
            returnTimeDynamic(x);
        }
    }

    /**
     * Returns recursive time
     *
     * <p>Runs recursive fibonacci and returns the value and time taken</p>
     *
     * @param n Position to calculate
     */
    public static void returnTimeRecursive(int n) {
        //returns time
        long startTime = System.nanoTime();
        int returnVal = recursiveFibonacci(n);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("recursiveFib(" + String.valueOf(n) + ") is " + String.valueOf(returnVal) + " and took " + String.valueOf(estimatedTime) + " nanoseconds");
    }

    /**
     * Returns dynamic time
     *
     * <p>Runs dynamic fibonacci and returns the value and time taken</p>
     *
     * @param n Position to calculate
     */
    public static void returnTimeDynamic(int n) {
        //returns time
        long startTime = System.nanoTime();
        int returnVal = dynamicFibonacci(n);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("dynamicFib(" + String.valueOf(n) + ") is " + String.valueOf(returnVal) + " and took " + String.valueOf(estimatedTime) + " nanoseconds");
    }

    /**
     * Recursive Fibonacci
     *
     * <p>Returns the nth Fibonacci number after taking forever while using recursive methods</p>
     * @param n Requested position
     * @return The nth Fibonacci number
     */

    public static int recursiveFibonacci(int n) {
        //base case
        int returnVal;
        if (n == 0) {
            returnVal = 0;
        } else if (n == 1) {
            returnVal = 1;
        }
        //recursive case n
        else {
            returnVal = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
        return returnVal;
    }

    /**
     * Dynamic Fibonacci
     *
     * <p>Returns the nth Fibonacci number after taking very little time while using dynamic methods</p>
     * @param n Requested position
     * @return The nth Fibonacci number
     */
    public static int dynamicFibonacci(int n) {
        //define fibonacci array
        int[] fibonacci = new int[n+1];

        //set base cases and write the dynamic method
        //base case
        for (int x = 0; x <= n; x++) {
            if (x == 0) {
                fibonacci[0] = 0;
            }
            else if (x == 1) {
                fibonacci[1] = 1;
            }
            //dynamic cases
            else {
                fibonacci[x] = fibonacci[x - 1] + fibonacci[x - 2];
            }
        }

        //return nth value
        return fibonacci[n];
    }
}
