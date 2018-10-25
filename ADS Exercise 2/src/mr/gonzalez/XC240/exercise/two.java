package mr.gonzalez.XC240.exercise;


/**
 * ADSB: Exercise 02
 * 10/15/2018
 * @author Sujay Swain
 */


public class two {
    /**
     * Base Case: Returns the same character
     * Recursive Case 1: Runs the method with the first character at the end
     */
    public static String reverseString(String s) {
        int length = s.length();
        if(length<=1) {
            return s;
        }
        else {
            return reverseString(s.substring(1)) + s.charAt(0);
        }
    }

    /**
     * Base Case: Adds the number to a sum = 0, and return the sum
     * Recursive Case 1: Add the first digit to a sum and remove that digit and put the new number through the function again.
     */

    public static int sumDigits(int num){
        int sum = 0;
        if (num == 0) {
            return sum;
        }
        sum = num%10 + sumDigits(num/10);
        return sum;
    }

    /**
     * Base Case: Adds 1 or 0 to a sum depending on whether or not the one digit is a 7 and then returns the sum
     * Recursive Case 1: Checks the first digit to see if it as a 7 and adds 1 or 0 appropriately. Then, it removes the digit and inputs the new number into the function again.
     */
    public static int count7(int num) {
        int ret = 0;
        if(num == 0) {
            return ret;
        }
        if(num%10 == 7) {
            ret += 1;
        }
        ret += count7(num/10);
        return ret;
    }

    /**
     * Base Case: Multiples the value into the return value variable and returns return value
     * Recursive Case 1: multiples the return value variable into the given number and then recursively calls the function using the same number and the second number minus 1.
     */
    public static int powerN(int base, int n) {
        int ret = 1;
        if(base == 1) {
            return ret;
        }
        if(n == 1) {
            return base;
        }
        ret *= base;
        n -= 1;
        ret *= powerN(base, n);
        return ret;
    }

    /**
     * Base Case: Returns false
     * Recursive Case 1: Takes the current index and checks if the next index is equal to 10x this value.
     * Returns true or it runs the function again starting at the next index.
     */
    public static boolean array220(int[] a, int index) {
        if (a.length < 2 ) {
            return false;
        }
        else if (index+1 >= a.length) {
            return false;
        }
        else if (a[index] * 10 == a[index+1]) {
            return true;
        }
        else {
            return array220(a, index+1);
        }
    }

    /**
     * Base case: if the second number is greater than the first number, return the second number
     * Recursive Case 1: return the value that comes from running the second number in the first number place
     * and the remainder of the first number divided by the second number
     */
    public static int euclideanGCD(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        else if (num1 >= num2 && num2 > 0) {
            return euclideanGCD(num2, num1%num2);
        }
        else {
            return euclideanGCD(num2, num1);
        }
    }

    /**
     * Base Case: Checks the one character to see if there in a string of vowels and add 1 or 0 to a sum. Then the sum is returned.
     * Recursive Case 1: Adds 1 or 0, appropriately, to the return value and runs the the function again using the substring that omits the first character.
     */
    public static int countVowel(String s) {
        if (s.length() == 0) return 0;

        if ("AEIOUaeiou".indexOf(s.substring(0, 1)) < 0) {
            return countVowel(s.substring(1));
        }
        else {
            return 1 + countVowel(s.substring(1));
        }
    }

    /**
     * Base Case: Returns 1
     * Recursive Case: If the first digit is equal to the last digit, it runs the function again with the first and the last digit removed.
     */
    public static int isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("\\s","");
        if(s.length() == 0 || s.length() == 1) {
            return 1;
        }

        if(s.charAt(0) == s.charAt(s.length()-1)) {
            return isPalindrome(s.substring(1, s.length()-1));
        }
        return 0;
    }
}
