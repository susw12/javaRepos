package net.mrpaul.ads.xc240.ps08;

public class ArraysPotpourri {
    public static void main(String[] args) {

    }
    public static void bubbleSort(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1])
                {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
    public static int lastIndexOf(int arr[], int val) {
        int finalIndex = -1;
        for (int x = arr.length-1; x >= 0; x--) {
            if (val == arr[x]) {
                finalIndex = x;
                break;
            }
        }
        return finalIndex;
    }
    public static int range(int arr[]) {
        bubbleSort(arr);
        int range = arr[arr.length-1] - arr[0];
        return range;
    }
    public static int countInRange(int arr[], int min, int max) {
        bubbleSort(arr);
        int minIndex = -1;
        int maxIndex = -1;
        for (int x = arr.length - 1; x >= 0; x--) {
            if (min == arr[x]) {
                minIndex = x;
                break;
            }
        }
        for (int x = arr.length - 1; x >= 0; x--) {
            if (max == arr[x]) {
                maxIndex = x;
                break;
            }
        }
        if (minIndex == -1 || maxIndex == -1) {
            return -1;
        } else {
            //int inRange
        }

    }
    public static boolean isSorted(int[] arr) {
        int [] copyArray;
        copyArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copyArray[i] = arr[i];
        }
        bubbleSort(arr);
        if (arr == copyArray)
            return true;

        else
            return false;
    }


    public static int arrayMode(int n, int[] arr) {
        int personalMax = 1, totalMax = 0, maxNum = 0;

        for (int i = 0; i < n - 1; i++) {

            if (arr[i] == arr[i + 1]) {
                personalMax++;

                if (totalMax < personalMax) {
                    totalMax = personalMax;
                    maxNum = arr[i];
                }
            } else {
                personalMax = 1;
            }
        }
        return maxNum;
    }

    
}
