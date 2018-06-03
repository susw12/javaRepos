package net.ads.mrpaul.xc240.ps09;

public class ChangeCalculator {

    public static void main(String[] args) {
        //Intellij requires a main method to run
    }

    /**
     * Calculates minimum coin number recursively
     *
     * <p>Calculates the minimum amount of change that is need to produce x dollars. </p>
     * <p> Does this by constantly reusing the recursive function over and over again. </p>
     *
     * @param amount amount of money given
     * @param coins array of usable coins
     * @return the minimum amount of coins needed
     */

    public static int recursiveMinChange(int amount, int[] coins) throws IllegalArgumentException {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Amount of change cannot be negative!");
        }
        int minNeeded = 9999999;
        int x;
        for (int coin: coins) {
            x = 1 + recursiveMinChange(amount - coin, coins);
            if (x < minNeeded) {
                minNeeded = x;
            }
        }
        return minNeeded;

    }

    /**
     * Calculates number of coins dynamically
     *
     * Calculates minimum number of coins needed to produce an amount of money. <p>
     * Creates an array of reachable values. <p>
     * Updates the array every change of number of coins. <p>
     * Returns the number of coins once the amount is reached. <p>
     *
     * @param amount amount to make
     * @param coins array of coin values
     * @return minimum number of coins needed
     */
    //public static int dynamicMinChange(int amount, int[] coins) {

    //}

}
