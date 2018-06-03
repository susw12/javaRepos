package net.ads.mrpaul.xc240.ps09;


/**
 * Calculates minimum amount of changed need
 *
 * Calculates the minimum amount of changed need both recursively and dynamically
 * ADS PS09: Greedy redux + eBay
 * 6/2/2018
 *
 * @author Sujay Swain
 */
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
            return 9999999;
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
     * <p>Calculates the minimum amount of coins needed for x amount of money. </p>
     * <p>Then creates an array with reachable values.</p>
     * <p>It then updates the array with each instance of a change of coins</p>
     * <p>It finally returns the amount of coins needed with it reaches the target amount.</p>
     *
     *
     * @param amount amount to make
     * @param coins array of coin values
     * @return minimum number of coins needed
     */


    public static int dynamicMinChange(int amount, int[] coins) {
        int currentNumCoins = 0;
        int[][] coinNumbers = {new int[coins.length]};
        int[][] newCoinNumbers;
        while (true) {
            currentNumCoins++;
            newCoinNumbers = new int[coinNumbers.length * coins.length][0];
            int n = 0;
            for (int[] x: coinNumbers) {
                for (int i = 0; i < x.length; i++) {
                    int[] k = x.clone();
                    k[i]++;
                    newCoinNumbers[n] = k;
                    n++;
                }
            }
            coinNumbers = newCoinNumbers.clone();
            for (int[] create: coinNumbers) {
                int total = 0;
                for (int m = 0; m < create.length; m++) {
                    total += create[m] * coins[m];
                }
                if (amount == total) {
                    return currentNumCoins;
                }
            }
        }
    }

}
