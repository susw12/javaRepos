package net.mrpaul.ads.XC240.ps06;
/**
 * Creates Standard Form Equations for lines
 *
 * This program creates standard form equations from lines by either using a default value, user input values or
 * two points.
 * <p>
 * ADSA PS06: StandardFormLine
 * 4/21/18
 *
 * @author Sujay Swain
 */
public class StandardFormLine {
    //Initializing variables for program
    private double a;
    private double b;
    private double c;

    /**
     * Sets default variable values and initializes object
     * Sets the default values for the variables a, b, and c and initializes the object.
     * <p>
     * @author Sujay Swain
     *
     */
    public StandardFormLine() {
        this.a = -1;
        this.b = 1;
        this.c = 1;
    }

    /**
     * Sets variables values as user initializes it
     * Sets the user inputted values for a, b and c and initializes the object
     * <p>
     * @author Sujay Swain
     *
     * @param a
     * @param b
     * @param c
     */
    public StandardFormLine(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Sets variables values from points initializes it
     * Uses the user inputted points to set values for a, b and c and initializes the object
     * <p>
     * @author Sujay Swain
     *
     * @param a
     * @param b
     *
     */
    public StandardFormLine(Point a, Point b) {
        //gets the appropriate variable
        double m = (b.getY()-a.getY())/(b.getX()-a.getX());
        this.a = -m;
        this.b = 1;
        this.c = a.getY()-m*a.getX();
    }

    /**
     * Sets "a" value
     * Sets value for "a"
     * <p>
     * @author Sujay Swain
     * @param a
     *
     */
    public void setA(double a) {
        this.a = a;
    }

    /**
     * Sets "b" value
     * Sets value for "b"
     * <p>
     * @author Sujay Swain
     *
     * @param b
     *
     */
    public void setB(double b) {
        this.b = b;
    }

    /**
     * Sets "c" value
     * Sets value for "c"
     * <p>
     * @author Sujay Swain
     *
     * @param c
     *
     */
    public void setC(double c) {
        this.c = c;
    }

    /**
     * Gets "a" value
     * Gets value for "a"
     * <p>
     * @author Sujay Swain
     *
     * @return a
     */
    public double getA() {
        return this.a;
    }

    /**
     * Gets "b" value
     * Gets value for "b"
     * <p>
     * @author Sujay Swain
     *
     * @return b
     */
    public double getB() {
        return this.b;
    }

    /**
     * Gets "c" value
     * Gets value for "c"
     * <p>
     * @author Sujay Swain
     *
     * @return c
     */
    public double getC() {
        return this.c;
    }

    /**
     * Calculates the slope
     * Calculates the slope from the formula.
     * <p>
     * @author Sujay Swain
     *
     * @return slope
     */
    public double getSlope() {
        //gets the slope
        if (b != 0) {
            return(-(a/b));
        } else {
            throw new IllegalArgumentException("Invalid slope.");
        }
    }

    /**
     * Return the string version
     * Returns the equation as a string
     * <p>
     * @author Sujay Swain
     *
     * @return string value
     */
    public String toString() {
        return (this.getA() + "x + " + this.getB() + "y = " + this.getC());
    }
}
