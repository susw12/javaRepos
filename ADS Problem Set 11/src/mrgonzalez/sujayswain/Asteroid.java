package mrgonzalez.sujayswain.ps11;

import java.awt.Graphics;

/**
 * An asteroid that floats in space.
 * An asteroid that floats around in space during the game.
 * <p>
 * ADS PS11: Asteroids
 * 9/18/18
 * 
 * @author Sujay Swain
 */
public class Asteroid extends Polygon {
	int width;
	int height;
	double stepSize = 1.5;
	
	/**
	 * Instantiate a asteroid
	 * <p>The purpose of this method is to instantiate a asteroid with inShape and inPosition and inRotation and w and h.</p>
	 * 
	 * @author Sujay Swain
	 * @param inShape a point[] used as the in shape
	 * @param inPosition a point used as the in position
	 * @param inRotation a double used as the in rotation
	 * @param w an int used for instantiating a asteroid
	 * @param h an int used for instantiating a asteroid
	 */
	public Asteroid(Point[] inShape, Point inPosition, double inRotation, int w, int h) {
		super(inShape, inPosition, inRotation);
		
		width = w;
		height = h;
	}
	
	/**
	 * Paint method
	 * <p>The purpose of this method is to paint with brush.</p>
	 * 
	 * @author Sujay Swain
	 * @param brush a graphics used as the brush
	 */
	public void paint(Graphics brush) {
		Point[] p = this.getPoints();
		int[] x = new int [p.length];
		int[] y = new int [p.length];
		for (int i = 0; i < p.length; i++) {
			x[i] = (int)p[i].getX();
			y[i] = (int)p[i].getY();
		}
		brush.fillPolygon(x, y, p.length);
	}

	/**
	 * Move method
	 * <p>The use of this method is to move.</p>
	 * 
	 * @author Sujay Swain
	 */
	public void move() {
		boolean forward = true;
		boolean left = false;
		boolean right = false;
		position = forward ? new Point(((position.getX() + (stepSize  * Math.cos(Math.toRadians(rotation))) % width + width) % width), (((position.getY()+(stepSize * Math.sin(Math.toRadians(rotation)))) % height + height) % height)) : position;
		this.rotate(left ? -(int)stepSize : (right ? (int)stepSize : 0));
	}
}
