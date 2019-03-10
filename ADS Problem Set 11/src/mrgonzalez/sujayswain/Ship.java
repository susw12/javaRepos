package mrgonzalez.sujayswain.ps11;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * The ship class.
 * This class provides drawing and controlling a ship.
 * <p>
 * ADS PS11: Asteroids
 * 9/20/18
 * 
 * @author Sujay Swain
 */
public class Ship extends Polygon implements KeyListener {

	double stepSize = 0;
	boolean left;
	boolean right;
	boolean pressed;
	boolean listening = false;
	int height;
	int width;
	List<Asteroid> bullets = new ArrayList<Asteroid>();
	
	/**
	 * Instantiate a ship
	 * <p>The purpose of this method is to instantiate a ship with inShape and inPosition and inRotation and w and h.</p>
	 * 
	 * @author Sujay Swain
	 * @param inShape a point[] used as the in shape
	 * @param inPosition a point used as the in position
	 * @param inRotation a double used as the in rotation
	 * @param w an int used for instantiating a ship
	 * @param h an int used for instantiating a ship
	 */
	public Ship(Point[] inShape, Point inPosition, double inRotation, int w, int h) {
		super(inShape, inPosition, inRotation);
		
		width = w;
		height = h;
	}
	
	/**
	 * Paint method
	 * <p>The use of this method is to paint with brush.</p>
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
		for (int i = 0; i < bullets.size(); i++) {
			brush.setColor(Color.white);
			bullets.get(i).paint(brush);
			bullets.get(i).move();
		}
	}

	/**
	 * Move method
	 * <p>The purpose of this method is to move.</p>
	 * 
	 * @author Sujay Swain
	 */
	public void move() {
		stepSize += pressed ? (stepSize > 5 ? 0 : 0.1) : stepSize < 0.05 ? 0 : -0.05;
		position = new Point(((position.getX() + (stepSize  * Math.cos(Math.toRadians(rotation))) % width + width) % width), (((position.getY()+(stepSize * Math.sin(Math.toRadians(rotation)))) % height + height) % height));
		this.rotate(left ? -2 : (right ? 2 : 0));
	}

	/**
	 * Key pressed
	 * <p>The goal of this method is to key pressed with e.</p>
	 * 
	 * @author Sujay Swain
	 * @param e a keyevent used for keying pressed
	 */
	public void keyPressed(KeyEvent e) {
		if (listening) {
			if (e.getKeyCode() == KeyEvent.VK_UP) pressed = true;
			if (e.getKeyCode() == KeyEvent.VK_LEFT) left = true;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = true;
			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				Asteroid bullet = new Asteroid(new Point[] {new Point(0, 0), new Point(5, 0), new Point(5, 5), new Point (0, 5)}, new Point(position.getX() + 20*Math.cos(Math.toRadians(rotation)), position.getY() + 20 * Math.sin(Math.toRadians(rotation))), rotation, width, height);
				bullet.stepSize = 10;
				bullets.add(bullet);	
			}
		}
	}

	/**
	 * Key released
	 * <p>The use of this method is to key released with e.</p>
	 * 
	 * @author Sujay Swain
	 * @param e a keyevent used for keying released
	 */
	public void keyReleased(KeyEvent e) {
		if (listening) {
			if (e.getKeyCode() == KeyEvent.VK_UP) pressed = false;
			if (e.getKeyCode() == KeyEvent.VK_LEFT) left = false;
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) right = false;
		}
	}

	/**
	 * Key typed
	 * <p>The use of this method is to key typed with e.</p>
	 * 
	 * @author Sujay Swain
	 * @param e a keyevent used for keying typed
	 */
	public void keyTyped(KeyEvent e) {
		
	}
	
}
