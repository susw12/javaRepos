package net.mrpaul.ads.XC240.ps06;

import java.util.Random;

public class Dice {
    private Random generator = new Random();
    private int currentSide;
    private int numRolls;
    private int numOnes;
    private int numTwos;
    private int numThrees;
    private int numFours;
    private int numFives;
    private int numSixes;

    public Dice() {

    }

    public Dice(long seed) {
        this.generator.setSeed(seed);
    }

    public void roll() {
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

    public int getCurrentSide() {
        return currentSide;
    }

    public int getNumRolls() {
        return numRolls;
    }

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

    public double getPercentages(int num) {
        double sendVar = 0;
        switch (num) {
            case 1: sendVar = numOnes/numRolls;
            case 2: sendVar = numTwos/numRolls;
            case 3: sendVar = numThrees/numRolls;
            case 4: sendVar = numFours/numRolls;
            case 5: sendVar = numFives/numRolls;
            case 6: sendVar = numSixes/numRolls;
        }
        return sendVar;
    }

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
