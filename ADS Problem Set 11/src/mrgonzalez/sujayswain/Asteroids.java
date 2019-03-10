package mrgonzalez.sujayswain.ps11;

/*
CLASS: Asteroids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * The main game class.
 * This class provides the main game and creation of the ship and asteroids.
 * <p>
 * ADS PS11: Asteroids
 * 9/20/18
 * 
 * @author Sujay Swain
 */
class Asteroids extends Game {
	
	int counter = 0;
	
	Ship ship;
	Asteroid[] asteroids = new Asteroid[10];

	/**
	 * Instantiate an asteroids game
	 * <p>The goal of this method is to instantiate an asteroids game.</p>
	 * 
	 * @author Sujay Swain
	 */
	public Asteroids() {
	    super("Asteroids!",800,600);
	    this.setFocusable(true);
		this.requestFocus();
		
		Random r = new Random();
		
		ship = new Ship(new Point[] {new Point(0, 0), new Point(10, 0), new Point(20, 5), new Point(10, 10), new Point (0, 10)}, new Point(width/2, height/2), 270, width, height);
		this.addKeyListener(ship);
		
		for (int i = 0; i < asteroids.length; i++) {
			asteroids[i] = new Asteroid(new Point[] {new Point(0, 0), new Point(10*r.nextInt(5)+1, 0), new Point(10*r.nextInt(5)+1, 10*r.nextInt(5)+1), new Point (0, 10*r.nextInt(5)+1)}, new Point(r.nextInt(width), r.nextInt(height)), r.nextInt(360), width, height);
		}
	}
  
	/**
	 * Paint method
	 * <p>The purpose of this method is to paint with brush.</p>
	 * 
	 * @author Sujay Swain
	 * @param brush a graphics used as the brush
	 */
	public void paint(Graphics brush) {
		counter++;
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	Color shipColor = Color.red;
    	
    	brush.setColor(Color.white);
    	if (counter == 50) {
    		ship.listening = true;
    	}
    	if (counter < 50 && counter % 10 >= 5) {
    		shipColor = Color.black;
    	}
    	for (int i = 0; i < asteroids.length; i++) {
    		if (asteroids[i] == null) continue;
    		asteroids[i].move();
    		if (ship.collides(asteroids[i])) {
    			respawnShip();
    		}
        	for (int j = 0; j < ship.bullets.size(); j++) {
        		if (ship.bullets.get(j).collides(asteroids[i])) {
        			asteroids[i] = null;
        			ship.bullets.remove(j);
        			break;
        		}
        		if (ship.bullets.get(j).collides(ship)) {
        			respawnShip();
        			ship.bullets.remove(j);
        			break;
        		}
        	}
    		if (asteroids[i] == null) continue;
    		asteroids[i].paint(brush);
    	}
    	
    	brush.setColor(shipColor);
    	ship.move();
    	ship.paint(brush);
  }
	
	/**
	 * Respawn ship
	 * <p>The use of this method is to respawn ship.</p>
	 * 
	 * @author Sujay Swain
	 */
	public void respawnShip() {
		ship.position = new Point(width/2, height/2);
		ship.listening = false;
		ship.stepSize = 0;
		ship.rotation = 270;
		ship.pressed = false;
		ship.left = false;
		ship.right = false;
		counter = 0;
	}
	
	/**
	 * Main method
	 * <p>This method runs the main program.</p>
	 * 
	 * @author Sujay Swain
	 * @param args a string[] used as the args
	 */
	public static void main (String[] args) {
   		Asteroids a = new Asteroids();
		a.repaint();
  }
}