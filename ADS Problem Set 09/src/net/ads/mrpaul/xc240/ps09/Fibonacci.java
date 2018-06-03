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

    public static void main(String[] args) {
        for (int x = 0; x <= 45; x += 5) {
            returnTimeRecursive(x);
            returnTimeDynamic(x);
        }
    }

    public static void returnTimeRecursive(int n) {
        //returns time
        long startTime = System.nanoTime();
        int returnVal = recursiveFibonacci(n);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("recursiveFib(" + String.valueOf(n) + ") is " + String.valueOf(returnVal) + " and took " + String.valueOf(estimatedTime) + " nanoseconds");
    }

    public static void returnTimeDynamic(int n) {
        //returns time
        long startTime = System.nanoTime();
        int returnVal = dynamicFibonacci(n);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("dynamicFib(" + String.valueOf(n) + ") is " + String.valueOf(returnVal) + " and took " + String.valueOf(estimatedTime) + " nanoseconds");
    }

    public static int recursiveFibonacci(int n) {
        //base case
        int returnVal;
        if (n == 0) {
            returnVal = 0;
        } else if (n == 1) {
            returnVal = 1;
        }
        //recursive case
        else {
            returnVal = recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
        return returnVal;
    }

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
