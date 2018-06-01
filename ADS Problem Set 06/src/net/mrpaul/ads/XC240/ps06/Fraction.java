package net.mrpaul.ads.XC240.ps06;


import java.math.BigInteger;

/**
 * Creates and manage Fractions
 * Creates and manages Fractions along with preforming calculations
 * <p>
 * ADSA PS06: Fraction
 * 4/21/18
 *
 * @author Sujay Swain
 */
public class Fraction {
    //variable declaration
    private int numerator;
    private int denominator;

    /**
     * Initializes Fraction object
     * Creates a Fraction object that has a value of 1
     * <p>
     * @author Sujay Swain
     */
    public Fraction(){
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Initializes Fraction object with values
     * Creates a Fraction with values for n and d
     * <p>
     * @author Sujay Swain
     * @param n
     * @param d
     * @throws IllegalArgumentException Divide by zero error
     */
    public Fraction(int n, int d) throws IllegalArgumentException {
        if (d < 0) throw new IllegalArgumentException("YOU CANNOT DIVIDE BY 0!");
        if (d < 0) this.numerator = -n;
        else this.numerator = n;
        this.denominator = d;
    }

    /**
     * Reinitialize Fraction values
     * Reinitialize a Fraction from another one
     * <p>
     * @author Sujay Swain
     * @param f2
     */
    public Fraction(Fraction f2) {
        f2 = new Fraction();
    }

    /**
     * Initializes Fraction object with values
     * Creates a Fraction with values for n
     * <p>
     * @author Sujay Swain
     * @param n
     */
    public Fraction(int n) {
        this.numerator = n;
        this.denominator = 1;
    }

    /**
     * Gets denominator
     * Gets the value for denominator
     * <p>
     * @author Sujay Swain
     * @return denominator
     */
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Gets numerator
     * Gets the value for numerator
     * <p>
     * @author Sujay Swain
     * @return numerator
     */
    public int getNumerator() {
        return this.numerator;
     }

    /**
     * Sets denominator value
     * Sets a value for denominator that is not 0
     * <p>
     * @author Sujay Swain
     * @param d
     * @throws IllegalArgumentException
     */
    public void setDenominator(int d) throws IllegalArgumentException{
        if (d == 0) {
            throw new IllegalArgumentException("YOU CANNOT DIVIDE BY 0");
        }
        else {
            this.denominator = d;
        }
    }

    /**
     * Sets numerator value
     * Sets a value for numerator that is not 0
     * <p>
     * @author Sujay Swain
     * @param n
     */
    public void setNumerator(int n) {
        this.numerator = n;
        reduce();
    }

    /**
     * Returns reduced fraction
     * Returns a reduced form of the fraction
     * <p>
     * @author Sujay Swain
     * @return this.toString()
     */
    public Fraction reduce() {
        int n = this.numerator, d = this.denominator, larger;
        //gets the value
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
        //sets the values
        if (gcd != 0) {
            this.numerator /= gcd;
            this.denominator /= gcd;
        }

        return this;
    }

    /**
     * Returns sum
     * Returns sum of two fractions
     * <p>
     * @author Sujay Swain
     * @param f2
     * @return sum.toString()
     */
    public Fraction add(Fraction f2) {
        Fraction sum = new Fraction();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();
        //sets the values
        sum.setNumerator(this.numerator*d2 + n2*this.denominator);
        sum.setDenominator(this.denominator*d2);
        sum.reduce();
        return sum;
    }

    /**
     * Returns difference
     * Returns difference of two fractions
     * <p>
     * @author Sujay Swain
     * @param f2
     * @return difference.toString()
     */
    public Fraction subtract(Fraction f2) {
        Fraction difference = new Fraction();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();
        //sets values
        difference.setNumerator(this.numerator*d2 - n2*this.denominator);
        difference.setDenominator(this.denominator*d2);
        difference.reduce();
        return difference;
    }

    /**
     * Returns product
     * Returns product of two fractions
     * <p>
     * @author Sujay Swain
     * @param f2
     * @return product.toString()
     */
    public Fraction multiply(Fraction f2) {
        Fraction product = new Fraction();

        int n2 = f2.getNumerator();
        int d2 = f2.getDenominator();
        //sets values
        product.setNumerator(this.numerator * n2);
        product.setDenominator(this.denominator * d2);
        product.reduce();
        return product;
    }

    /**
     * Returns quotient
     * Returns quotient of two fractions
     * <p>
     * @author Sujay Swain
     * @param f2
     * @return quotient.toString()
     */
    public Fraction divide(Fraction f2) {
        return this.multiply(f2.getReciprocal());
    }

    /**
     * Returns reciprocal
     * Returns reciprocal of a fractions
     * <p>
     * @author Sujay Swain
     * @return reci.toString()
     */
    public Fraction getReciprocal() {
        Fraction reci = new Fraction();
        int holder = this.denominator;
        int d = this.numerator;
        int n = holder;
        //sets appropriate values for variables
        reci.setDenominator(d);
        reci.setNumerator(n);
        reci.reduce();
        return reci;
    }

    /**
     * Returns double value
     * Returns double value of a fractions
     * <p>
     * @author Sujay Swain
     * @return stringForm;
     */
    public double getDoubleEquivalent() {
        double fractionValue = this.getNumerator()/this.getDenominator();
        return fractionValue;

    }

    /**
     * Return string value
     * Returns the string value of the fraction
     * <p>
     * @author Sujay Swain
     * @return stringForm
     */
    public String toString() {
        String stringForm = String.valueOf(this.getNumerator()) + "/" + String.valueOf(this.getDenominator());
        return stringForm;
    }
}
