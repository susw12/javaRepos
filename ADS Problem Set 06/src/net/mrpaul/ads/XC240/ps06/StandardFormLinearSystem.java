package net.mrpaul.ads.XC240.ps06;
/**
 * Calculates and displays a system of linear equations.
 * 
 * This program creates, calculates, and displays a system of linear equations.
 * <p>
 * ADSA PS06: StandardFormLinearSystem
 * 4/21/2018
 * 
 * 
 * @author Sujay Swain
 */
public class StandardFormLinearSystem {
	//Variable declarations
	StandardFormLine l1, l2;
	/**
	 * Initialize the two variables needed
	 * It initializes this.l1 and this.l2.
	 * <p>
	 * @author Sujay Swain
	 * @param line1: a linear equation
	 * @param line2: a linear equation
	 */
	public StandardFormLinearSystem(StandardFormLine line1, StandardFormLine line2) {
		this.l1 = line1;
		this.l2 = line2;
	}
	/**
	 * Creates l1 and l2 equations
	 * It creates standard linear equations for l1 and l2.
	 * <p>
	 * @author Sujay Swain
	 * @return none
	 */
	public StandardFormLinearSystem() {
		//initialize variables
		l1 = new StandardFormLine();
		l2 = new StandardFormLine();
	}
	/**
	 * Set line to l1/l2
	 * It sets the line equation to either l1 or l2, depending on lineNumber.
	 * <p>
	 * @author Sujay Swain
	 * @param lineNumber: tells program to set line to either l1 or l2
	 * @param line: equation of linear line
	 */
	public void setLine(int lineNumber, StandardFormLine line) {
		if(lineNumber == 1) {
			this.l1 = line;
		}
		else {
			this.l2 = line;
		}
	}
	/**
	 * Returns the equation for l1
	 * It returns the equation for the first line.
	 * <p>
	 * @author Sujay Swain
	 * @return equation for l1
	 */
	public StandardFormLine getLine1() {
		return this.l1;
	}
	/**
	 * Returns the equation for l2
	 * It returns the equation for the second line.
	 * <p>
	 * @author Sujay Swain
	 * @return equation for l2
	 */
	public StandardFormLine getLine2() {
		return this.l2;
	}
	/**
	 * Converts both equations to strings
	 * It converts l1 and l2 to strings and displays them.
	 * <p>
	 * @author Sujay Swain
	 * @return the two equations as strings, one per line
	 */
	public String toString() {
		return l1.toString() + "\n" + l2.toString();
	}
	/**
	 * Calculates if slopes are equal
	 * It calculates if the slopes are equal.
	 * It returns true if they are equal, and false otherwise.
	 * <p>
	 * @author Sujay Swain
	 * @return true or false if slopes are same or not
	 */
	public boolean haveSameSlope() {
		//if slopes are the same
		if(l1.getSlope() == l2.getSlope()) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Calculates if have infinite solutions
	 * It calcultes if the equations have infinite solutions.
	 * It returns true if they do, and false otherwise.
	 * <p>
	 * @author Sujay Swain
	 * @return true or false if equations have infinite solutions or not
	 */
	public boolean hasInfiniteSolutions() {
		//initialize variables
		double a1 = l1.getA(), a2 = l2.getA();
		double b1 = l1.getB(), b2 = l2.getB();
		double c1 = l1.getC(), c2 = l2.getC();
		
		//test if ratio between x, y, z values are the same
		if(a1/a2 == b1/b2 && a1/a2 == c1/c2) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Calculates if lines are parallel
	 * It calculates if the two lines are parallel.
	 * It returns true if they are and false otherwise.
	 * <p>
	 * @author Sujay Swain
	 * @return true or false if lines are parallel or not
	 */
	public boolean areParallel() {
		//initialize variables
		double b1 = l1.getB(), b2 = l2.getB();
		double c1 = l1.getC(), c2 = l2.getC();
		//if slopes are equal
		if(l1.getSlope() == l2.getSlope()) {
			//check to see if they are the same line
			if(c1/b1 == c2/b2) {
				return false;
			}
			else {
				return true;
			}
		}
		else {
			return false;
		}
	}
	/**
	 * Solves the system of equations
	 * It calculates the solution point (x, y) by solving for the determinants.
	 * It uses Cramer's Rule.
	 * <p>
	 * @author Sujay Swain
	 * @return point(x, y) as the solutions
	 */
	public Point solve() {
		//variable declarations
		int x, y;
		//initialize variables
		double a1 = l1.getA(), a2 = l2.getA();
		double b1 = l1.getB(), b2 = l2.getB();
		double c1 = l1.getC(), c2 = l2.getC();
		
		//if parallel
		if(l1.getSlope() == l2.getSlope() && c1/b1 == c2/b2) {
			return null;
		}
		else {
			//find determinants of x and y
			x = (int) ((int)(c1 * b2 - c2 * b1)/(a1 * b2 - a2 * b1));
			y = (int) ((int)(a1 * c2 - a2 * c1)/(a1 * b2 - a2 * b1));
			Point solution = new Point(x, y);
			return solution;
		}
	}
}
