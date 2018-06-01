package net.mrpaul.ads.XC240.ps06;

import java.util.Scanner;

/**
 * Calculates Euclidean GCD
 * Calculates the Euclidean GCD of two integers
 * <p>
 * ASDA PS06:
 * 4/21/18
 *
 * @author Sujay Swain
 */
public class EuclideanGCD {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        //get input from users
        int r;
        System.out.print("Enter n1: ");
        int n1 = reader.nextInt();
        System.out.print("Enter n2: ");
        int n2 = reader.nextInt();
        //loop until n2 is 0
        while(n2 != 0) {
            //r is a temp variable
            r = (int) (n1 - (Math.floor(n1 / n2)) * n2);
            //set n1 to n2
            n1 = n2;
            //set n2 to the remainder
            n2 = r;
            //formatting
            System.out.println("Step:");
            System.out.println("A Remainder: " + r);
            System.out.println("B\t\t" + "n1: " + n1 + " and n2: " + n2);
        }
        //output gcd
        System.out.println("GCD is " + n1);
    }
}
