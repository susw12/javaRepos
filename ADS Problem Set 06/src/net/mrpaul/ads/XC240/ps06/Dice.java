package net.mrpaul.ads.XC240.ps06;

import java.util.Random;
/**
 * Rolls dice and records stats
 *
 * This program rolls dices and records the stats for users to use.
 * <p>
 * ADSA PS06: Dice
 * 4/21/18
 *
 * @author Sujay Swain
 */
public class Dice {
    //Variable declaration
    private Random generator = new Random();
    private int currentSide;
    private int numRolls;
    private int numOnes;
    private int numTwos;
    private int numThrees;
    private int numFours;
    private int numFives;
    private int numSixes;

    /**
     * Initializes an empty object
     * Creates a basic object for dice with zilch in it.
     * <p>
     * @author Sujay Swain
     *
     */
    public Dice() {

    }

    /**
     * Creates a object with seed
     * Creates a basic dice object with a seed
     * <p>
     * @author Sujay Swain
     * @param seed
     */
    public Dice(long seed) {
        this.generator.setSeed(seed);
    }

    /**
     * Rolls the die
     * Rolls the die and stores the information in appropriate variables
     * <p>
     * @author Sujay Swain
     */
    public void roll() {
        //uses the random generator
        this.currentSide = this.generator.nextInt(6)+1;
        this.numRolls += 1;
        switch (currentSide) {
            case 1: this.numOnes += 1;
                    break;
            case 2: this.numTwos += 1;
                    break;
            case 3: this.numThrees += 1;
                    break;
            case 4: this.numFours += 1;
                    break;
            case 5: this.numFives += 1;
                    break;
            case 6: this.numSixes += 1;
                    break;
        };
    }

    /**
     * Gets side
     * Gets the current side
     * <p>
     * @author Sujay Swain
     * @return currentSide
     */
    public int getCurrentSide() {
        return currentSide;
    }

    /**
     * Returns roll number
     * Returns the number of rolls for this die
     * <p>
     * @author Sujay Swain
     * @return numRolls
     */
    public int getNumRolls() {
        return numRolls;
    }

    /**
     * Returns rolls per side
     * Returns the number of times a side has been the result of a roll
     * <p>
     * @author Sujay Swain
     * @param num
     * @return sendVar
     */
    public int getNumRolls(int num) {
        int sendVar = 0;
        switch (num) {
            case 1: sendVar = numOnes;
            case 2: sendVar = numTwos;
            case 3: sendVar = numThrees;
            case 4: sendVar = numFours;
            case 5: sendVar = numFives;
            case 6: sendVar = numSixes;
        }
        return sendVar;
    }

    /**
     * Returns percentage per side
     * Returns the percentage of times a side has been the result of a roll
     * <p>
     * @author Sujay Swain
     * @param num
     * @return sendVar
     */
    public double getPercentages(int num) {
        double sendVar = 0;
        switch (num) {
            case 1: sendVar = numOnes/numRolls * 100;
            case 2: sendVar = numTwos/numRolls * 100;
            case 3: sendVar = numThrees/numRolls * 100;
            case 4: sendVar = numFours/numRolls * 100;
            case 5: sendVar = numFives/numRolls * 100;
            case 6: sendVar = numSixes/numRolls * 100;
        }
        return sendVar;
    }

    /**
     * Variable reset
     * Resets the variables for die
     * <p>
     * @author Sujay Swain
     */
    public void reset() {
        numRolls = 0;
        numOnes = 0;
        numTwos = 0;
        numThrees = 0;
        numFours = 0;
        numFives = 0;
        numSixes = 0;
    }
}
