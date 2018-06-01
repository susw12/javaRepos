package net.ads.mrpaul.xc240.ps09;


public class Fibonacci {

    public static void main(String[] args) {
        returnTime(0);
        returnTime(5);
        returnTime(10);

    }

    public static void returnTime(int n) {
        //returns time
        long startTime = System.nanoTime();
        int returnVal = recursiveFibonacci(n);
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println("recursiveFib(" + String.valueOf(n) + ") is " + String.valueOf(returnVal) + " and took " + String.valueOf(estimatedTime) + " nanoseconds");
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

        System.out.println(returnVal);
        return returnVal;
    }

    public static int dynamicFibonacci(int n) {
        //define fibonacci array
        int[] fibonacci = new int[n];

        //set base cases and recursion
        //base case
        for (int x = 0; x <= fibonacci.length; x++) {
            if (x == 0) {
                fibonacci[0] = 0;
            } else if (x == 1) {
                fibonacci[1] = 1;
            }
            //dynamic cases
            else {
                fibonacci[x] = fibonacci[x - 1] + fibonacci[x - 2];
            }
        }

        //return nth value
        return fibonacci[n - 1];
    }
}
