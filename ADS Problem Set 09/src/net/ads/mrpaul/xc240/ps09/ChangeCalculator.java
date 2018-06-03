package net.ads.mrpaul.xc240.ps09;

public class ChangeCalculator {

    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] <= arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }

    public static int recursiveMinChange(int n, int[] coins) {
        int valueCheck = coins[0];
        if (n - valueCheck < 0) {

        }
    }
}