package net.mrpaul.ads.xc240.ps08;

/**
* Array manipulating class
*
* This program allows the user to perform many different functions on arrays.
*<p>
*ADS PS08: Arrays Potpourri
*5/16/18
*
*
*@author Sujay Swain
*/
public class ArraysPotpourri {
    public static void main(String[] args) {
        //INTELLIJ REQUIRES THIS TO COMPILE
    }
	/**
	 * Finds number of elements in range
	 * Finds the number of elements in the array from the lower to upper bound, inclusive.
	 * @param a int[] to search in
	 * @param min int lower bound
	 * @param max int upper bound
	 * @return num in range
	 */
	public static int countInRange (int[] a, int min, int max) {
		int count = 0;
		for (int x: a) {
			if (x >= min && x <= max) count++;
		}
		return count;
	}
	
	/**
	 * Determines if array is sorted
	 * Returns true if the array is non-decreasing and false otherwise
	 * @param a int[] to decide if sorted
	 * @return whether the array is sorted
	 */
	public static boolean isSorted (int[] a) {
		for (int i = 0; i <= a.length - 2; i++) {
			if (a[i+1] < a[i]) return false;
		}
		return true;
	}
	/**
	 * Determines range of array
	 * Finds the difference between the maximum and minimum elements of an array 
	 * @param a int[] to find range of
	 * @return range
	 */
	public static int range (int[] a) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int x: a) {
			if (x > max) max = x;
			if (x < min) min = x;
		}
		return max - min;
	}
	
	/**
	 * Sorts an array
	 * Uses a bubble sort to sort an array non-decreasingly
	 * @param a int[] to sort
	 * @return sorted array
	 */
	public static int[] sort (int[] a) {
		int temp;
		for (int time = 0; time < a.length; time++) {
			for (int i = 0; i <= a.length - 2; i++) {
				if (a[i] > a[i+1]) {
					temp = a[i];
					a[i] = a[i+1];
					a[i+1] = temp;
				}
			}
		}
		return a;
	}
	
	/**
	 * Finds mode of array
	 * Returns the mode of an array of integers.
	 * The elements lie from 0 to 100, inclusive.
	 * It returns the lowest of the modes if there are mutliple
	 * @param a int[] to find mode of
	 * @return mode of array
	 */
	public static int mode(int[] a) {
		int[] times = new int[100];
		for (int x: a) times[x-1]++;
		int maxTimes = 0;
		for (int x: times) if (x > maxTimes) maxTimes = x;
		int count = 0;
		while (times[count] != maxTimes) count++;
		return count + 1;		
	}
	
	/**
	 * Finds the standard deviation of an array
	 * Finds the standard deviation of an integer array through a formula.
	 * Takes the sum of squares of the elements minus the average.
	 * Divides by the array length minus 1.
	 * Takes the square root.
	 * @param a int[] to find standard deviation of
	 * @return standard deviation as double
	 */
	public static double stdev(int[] a) {
		double sum = 0;
		for (int x: a) sum += x;
		double mean = sum/a.length;
		double squareavg = 0;
		for (int x: a) squareavg += Math.pow((x - mean), 2.0);
		squareavg /= a.length - 1;
		return Math.sqrt(squareavg);
	}
	
	/**
	 * Finds kth largest element of array
	 * Sorts the array a and then finds its kth largest element.
	 * @param k number of largest element
	 * @param a int[] to search in
	 * @return kth largest element
	 */
	public static int kthLargest(int k, int[] a) {
		a = sort(a);
		return a[a.length - k];
	}
	
	/**
	 * Returns minimum gap
	 * Returns the minimum gap between adjacent elements in the array.
	 * It is always the second minus the first, rather than positive difference.
	 * @param a int[] to search in
	 * @return minimum gap
	 */
	public static int minGap(int[] a) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= a.length - 2; i++) min = Math.min(a[i+1]-a[i], min);
		return min;
	}
	
	/**
	 * Finds percent of numbers that are even
	 * Returns as a double the percent of numbers in an integer array that are even.
	 * @param a int[] to search in
	 * @return as double percentage of elements that are even
	 */
	public static double percentEven(int[] a) {
		int numEven = 0;
		for (int x: a) if (x % 2 == 0) numEven++;
		return (double) numEven/a.length * 100;
	}
	
	/**
	 * Determines if integers in an array are unique
	 * Sorts a list and determines if it is strictly increasing.
	 * @param a int[] to search in
	 * @return whether the array is unique
	 */
	public static boolean isUnique(int[] a) {
		a = sort(a);
		for (int i = 0; i <= a.length - 2; i++) {
			if (a[i] == a[i+1]) return false;
		}
		return true;
	}
	
	/**
	 * Returns best price is right bid
	 * Returns highest bid in an integer array not exceeding a price.
	 * @param a int[] of bids
	 * @param price price of object
	 * @return best bid
	 */
	public static int priceIsRight(int[] a, int price) {
		int bestGuess = -1;
		for (int x: a) {
			if (x <= price && x >= bestGuess) bestGuess = x;
		}
		return bestGuess;
	}
	
	/**
	 * Determines longest sorted sequence
	 * Finds the length of the longest sorted sequence in an integer array
	 * @param a int[] to find longest sorted sequence in
	 * @return length of longest sorted sequence
	 */
	public static int longestSortedSequence(int[] a) {
		int best = 0, current = 0, last = Integer.MIN_VALUE;
		for (int x: a) {
			if (x >= last) {
				current++;
			}
			else {
				if (current > best) best = current;
				current = 0;
			}
			last = x;
		}
		if (current > best) best = current;
		return best;
	}
	
	/**
	 * Determines whether an array contains another
	 * Determines whether an integer array contains another array in order.
	 * @param list1 int[] to search in
	 * @param list2 int[] to be contained
	 * @return whether list1 contains list2
	 */
	public static boolean contains(int[] list1, int[] list2) {
		int list2Index = 0;
		for (int i = 0; i < list1.length; i++) {
			if (list1[i] == list2[list2Index]) {
				if (++list2Index == list2.length) return true;
			}
			else list2Index = 0;
		}
		return false;
	}
	
	/**
	 * Collapses an integer array
	 * Creates an array that is the sum of adjacent elements of an original integer array.
	 * @param a array to collapse
	 * @return collapsed array
	 */
	public static int[] collapse(int[] a) {
		int[] collapsed = new int[a.length - 1];
		for (int i = 0; i <= a.length - 2; i++) {
			collapsed[i] = a[i] + a[i+1];
		}
		return collapsed;
	}
	/**
	 * Appends an integer array to another
	 * Creates a new integer array with first the elements of a1 and then those of a2.
	 * @param a1 first int[]
	 * @param a2 second int[]
	 * @return appended array
	 */
	public static int[] append(int[] a1, int[] a2) {
		int[] appended = new int[a1.length + a2.length];
		for (int i = 0; i < a1.length; i++) {
			appended[i] = a1[i];
		}
		for (int i = 0; i < a2.length; i++) {
			appended[i + a1.length] = a2[i];
		}
		return appended;
	}
	/**
	 * Counts vowels in a string
	 * Creates an integer array containing the number of vowels in a string.
	 * Its values are the numbers of a's, e's, i's, o's, u's.
	 * It only counts lower case letters.
	 * @param s string to search in
	 * @return int[] of number of vowels
	 */
	public static int[] vowelCount(String s) {
		int[] count = new int[5];
		char c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			switch (c) {
			case 'a':	count[0]++;
						break;
			case 'e':	count[1]++;
						break;
			case 'i':	count[2]++;
						break;
			case 'o':	count[3]++;
						break;
			case 'u':	count[4]++;
						break;
			}
		}
		return count;
	}
	
}
