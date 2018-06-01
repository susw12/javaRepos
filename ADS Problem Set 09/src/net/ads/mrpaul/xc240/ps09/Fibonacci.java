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
<<<<<<< Updated upstream
        //define fibonacci array
        int[] fibonacci = new int[n];
        
        //set base cases and recursion
        for (int x = 0; x <= fibonacci.length, x++) {
            //base case
            if (x == 0) {
                fibonacci ;
            }
            else if (x == 1) {
                return 1;
            }
            //dynamic cases
            else {
                s
                
        
=======
        int[] fibonacci = new int[n];
        
>>>>>>> Stashed changes
    }
}
