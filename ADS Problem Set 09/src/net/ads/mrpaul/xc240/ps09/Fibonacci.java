package net.ads.mrpaul.xc240.ps09;

public class Fibonacci {
    public static int recursiveFibonacci(int n) {
        //base case
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        //recursive case
        else {
            return recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2);
        }
    }

    public static int dynamicFibonacci(int n) {
        int[] fibonacci = int
    }
}
