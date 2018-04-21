package net.mrpaul.ads.XC240.ps06;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        numerator = 1;
        denominator = 1;
    }

    public Fraction(int num) {
        numerator = num;
        denominator = 1;
    }

    public Fraction(int num, int den) throws IllegalArgumentException {
        if (den < 0) throw new IllegalArgumentException("YOU CANNOT DIVIDE BY 0!");
        if (den < 0) numerator = -num;
        else numerator = num;
        denominator = den;
    }


}
