package net.ads.mrpaul.xc240.ps09;

public class ExcercisesGR {
    public static void main(String[] arg) {

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