package net.mrpaul.ads.XC240.ps06;


import java.math.BigInteger;

/**
 *
 */
public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    public Fraction(int n, int d) throws IllegalArgumentException {
        if (d < 0) throw new IllegalArgumentException("YOU CANNOT DIVIDE BY 0!");
        if (d < 0) this.numerator = -n;
        else this.numerator = n;
        this.denominator = d;
    }

    public Fraction(Fraction f2) {
        f2 = new Fraction();
    }

    public Fraction(int n) {
        this.numerator = n;
        this.denominator = 1;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
     }

    public void setDenominator(int d) throws IllegalArgumentException{
        if (d == 0) {
            throw new IllegalArgumentException("YOU CANNOT DIVIDE BY 0");
        }
        else {
            this.denominator = d;
        }
    }

    public void setNumerator(int n) {
        this.numerator = n;
        reduce();
    }

    public Fraction reduce() {
        int n = this.numerator, d = this.denominator, larger;
        if (n > d) {
            larger = n;
        }
        else {
            larger = d;
        }
        BigInteger b1 = BigInteger.valueOf(n);
        BigInteger b2 = BigInteger.valueOf(d);
        BigInteger gcdPrev = b1.gcd(b2);
        int gcd = gcdPrev.intValue();

        if (gcd != 0) {
            this.numerator /= gcd;
            this.denominator /= gcd;
        }

        return this;
    }

    public Fraction add(Fraction f2) {
        Fraction sum = new Fraction();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();

        sum.setNumerator(this.numerator*d2 + n2*this.denominator);
        sum.setDenominator(this.denominator*d2);
        sum.reduce();
        return sum;
    }

    public Fraction subtract(Fraction f2) {
        Fraction difference = new Fraction();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();

        difference.setNumerator(this.numerator*d2 - n2*this.denominator);
        difference.setDenominator(this.denominator*d2);
        difference.reduce();
        return difference;
    }

    public Fraction multiply(Fraction f2) {
        Fraction product = new Fraction();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();

        product.setNumerator(this.numerator * n2);
        product.setDenominator(this.denominator * d2);
        product.reduce();
        return product;
    }

    public Fraction divide(Fraction f2) {
        Fraction quotient = new Fraction();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();

        quotient.setNumerator(this.numerator / n2);
        quotient.setDenominator(this.denominator / d2);
        quotient.reduce();
        return quotient;
    }

    public Fraction getReciprocal() {
        Fraction reci = new Fraction();
        int holder = this.denominator;
        int d = this.numerator;
        int n = holder;

        reci.setDenominator(d);
        reci.setNumerator(n);
        reci.reduce();
        return reci;
    }

    public double getDoubleEquivalent() {
        double fractionValue = this.getNumerator()/this.getDenominator();
        return fractionValue;

    }

    public String toString() {
        String stringForm = String.valueOf(this.getNumerator()) + "/" + String.valueOf(this.getDenominator());
        return stringForm;
    }
}
